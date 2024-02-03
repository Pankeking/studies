import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class KdTree {

  private static class Node {
    private Point2D p;
    private RectHV rect;
    private Node lb;
    private Node rt;

    public Node(Point2D p) {
      this.p    = p;
      this.lb   = null;
      this.rt   = null;
    }
  }

  private int axis; // -1 for X  // 0 for start // 1 for Y 
  private int size;
  private Node root;

  public KdTree() {
    this.size = 0;
    this.axis = 0;
    this.root = null;
  }

  public boolean isEmpty() {
    return this.size == 0;
  } 
  private int size() {
    return this.size;
  }

  public void insert(Point2D p) {
    if (p == null) throw new IllegalArgumentException("Called insert() with a null point");
    RectHV rect = new RectHV(0, 0, 1, 1);
    Node root = insert(p, true, this.root, rect);
    this.root = root;
  }

  private Node insert(Point2D p, boolean vertical, Node root, RectHV rect) { // axis X true  // axis 1 Y
    if (root == null) {
      this.size++;
      Node node = new Node(p);
      node.rect = rect;
      return node;
    }
    double cmp;
    // Positive compare  for lower point -> left/bottom
    // Negative && equal for higher point -> right/top
    if (vertical) cmp = root.p.x() - p.x(); 
    else          cmp = root.p.y() - p.y();

    RectHV nextRect = null;

    // 
    if (root.p.equals(p)) return root;

    if (cmp > 0 && vertical)  {
      // decrease X max
      if (root.lb == null) nextRect = new RectHV(rect.xmin(), rect.ymin(), root.p.x(), rect.ymax());
      // Do not recalculate rect
      else nextRect = root.lb.rect;

      Node node = insert(p, !vertical, root.lb, nextRect);
      root.lb = node;
    } 
    else if (cmp > 0 && !vertical)  {
      // decrease Y max
      if (root.lb == null) nextRect = new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), root.p.y());
      // Do not recalculate rect
      else nextRect = root.lb.rect;

      Node node = insert(p, !vertical, root.lb, nextRect);
      root.lb = node;
    } 
    else if (cmp < 0 && vertical) {
      // increase X min
      if (root.rt == null) nextRect = new RectHV(root.p.x(), rect.ymin(), rect.xmax(), rect.ymax());
      // Do not recalculate rect
      else nextRect = root.rt.rect;

      Node node = insert(p, !vertical, root.rt, nextRect);
      root.rt = node;
    }
    else if (cmp < 0 && !vertical) {
      // increase Y min
      if (root.rt == null) nextRect = new RectHV(rect.xmin(), root.p.y(), rect.xmax(), rect.ymax());
      // Do not recalculate rect
      else nextRect = root.rt.rect;

      Node node = insert(p, !vertical, root.rt, nextRect);
      root.rt = node;
    }
    else {
      // default right node
      // if (root.rt == null) nextRect = rect;
      // else nextRect = root.rt.rect;
      Node node = insert(p, !vertical, root.rt, rect);
      root.rt = node;
    }
    //
    return root;
  }

  public boolean contains(Point2D p) {
    if (p == null) throw new IllegalArgumentException("Called contains() with a null point");
    if (this.root == null) return false;
    Node current = this.root;
    boolean vertical = true;
    double cmp;
    while (current != null) {
      if (current.p.equals(p)) return true;

      if (vertical) {
        cmp = current.p.x() - p.x();
      } else {
        cmp = current.p.y() - p.y();
      }
      vertical = !vertical;

      if (cmp > 0) {
        current = current.lb;
      } else {
        current = current.rt;
      }
    }
    return false;
  }

  public void draw() {
    StdDraw.setXscale(0, 1);
    StdDraw.setYscale(0, 1);
    draw(this.root, true);
    return;
  }
  private void draw(Node node, boolean vertical) {
    if (node == null) {
      return;
    }
    
    // Draw Point
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.0001);
    node.p.draw();

    // Draw Line
    if (vertical) {
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.setPenRadius(0.0005);
      StdDraw.line(node.p.x(), node.rect.ymin(), node.p.x(), node.rect.ymax());
    } else {
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.setPenRadius(0.0005);
      StdDraw.line(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.p.y());
    }

    // Recursively draw left-bottom and right-top subtrees
    draw(node.lb, !vertical);
    draw(node.rt, !vertical);
  }

  public Iterable<Point2D> range(RectHV rect) {
    Queue<Point2D> points = new Queue<Point2D>();
    range(this.root, rect, points, true);
    return points;
  }

  private void range(Node node, RectHV rect, Queue<Point2D> queue, boolean vertical) {
    if (node == null) {
      return;
    }
    if (rect.contains(node.p)) {
      queue.enqueue(node.p);
    }

    double cmp;
    if (vertical) cmp = node.p.x() - rect.xmin();
    else          cmp = node.p.y() - rect.ymin();
      
    if (vertical && rect.xmax() > node.p.x() && node.p.x() > rect.xmin()) {
      range(node.lb, rect, queue, !vertical);
      range(node.rt, rect, queue, !vertical);
      return;
    } else if (vertical && cmp > 0) {
      range(node.lb, rect, queue, !vertical);
      return;
    } else if (vertical && cmp <= 0) {
      range(node.rt, rect, queue, !vertical);
      return;
    }

    if (rect.ymax() > node.p.y() && node.p.y() > rect.ymin()) {
      range(node.lb, rect, queue, !vertical);
      range(node.rt, rect, queue, !vertical);
    } else if (cmp > 0) {
      range(node.lb, rect, queue, !vertical);
    } else {
      range(node.rt, rect, queue, !vertical);
    }
  }

  public Point2D nearest(Point2D p) {
    return null;
  }



  public static void main(String[] args) {
    // Point2D queryPoint = new Point2D(0.5, 0.7);
    // KdTree tree = new KdTree();
    // tree.insert(queryPoint);

    // for (int i = 0; i < 12800; i++) {
    //     double x = StdRandom.uniformDouble(0.0, 1.0);
    //     double y = StdRandom.uniformDouble(0.0, 1.0);
    //     Point2D point = new Point2D(x, y);
    //     tree.insert(point);
    //     StdOut.printf(" Found: %b\n", tree.contains(point));
    // }

    // StdOut.println(tree.contains(new Point2D(0.5, 0.7)));
    // StdOut.println(tree.contains(new Point2D(0.3, 0.3)));
    // return;
  }
}