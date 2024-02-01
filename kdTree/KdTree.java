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
    if (p == null) throw new IllegalArgumentException();
    Node root = insert(p, -1, this.root);
    this.root = root;
  }

  private Node insert(Point2D p, int axis, Node root) { // axis -1 X  // axis 1 Y
    this.size++;
    if (root == null) {
      Node node = new Node(p);
      node.rect = new RectHV(0, 0, 1, 1);
      return node;
    }
    double cmp;
    if (axis < 0) cmp = root.p.x() - p.x();
    else          cmp = root.p.y() - p.y();

    axis = axis > 0 ? -1 : 1;
    if (cmp > 0)  {
      Node node = insert(p, axis, root.lb);
      root.lb = node;
    } 
    else if (cmp <= 0) {
      Node node = insert(p, axis, root.rt);
      root.rt = node;
    }
    return root;
  }

  public boolean contains(Point2D p) {
    if (p == null) throw new IllegalArgumentException();
    if (this.root == null) return false;
    Node current = this.root;
    int axis = -1;
    double cmp;
    while (current != null) {
      if (current.p.equals(p)) return true;

      if (axis < 0) {
        cmp = current.p.x() - p.x();
        axis = 1;
      } else {
        cmp = current.p.y() - p.y();
        axis = -1;
      }

      if (cmp > 0) {
        current = current.lb;
      } else {
        current = current.rt;
      }
    }
    return false;
    
  }

  public void draw() {
    return;
  }

  public Iterable<Point2D> range(RectHV rect) {
    return null;
  }

  public Point2D nearest(Point2D p) {
    return null;
  }



  public static void main(String[] args) {
    Point2D queryPoint = new Point2D(0.5, 0.7);
    KdTree tree = new KdTree();
    tree.insert(queryPoint);

    for (int i = 0; i < 12800; i++) {
        double x = StdRandom.uniformDouble(0.0, 1.0);
        double y = StdRandom.uniformDouble(0.0, 1.0);
        Point2D point = new Point2D(x, y);
        tree.insert(point);
        StdOut.printf(" Found: %b\n", tree.contains(point));
    }

    StdOut.println(tree.contains(new Point2D(0.5, 0.7)));
    StdOut.println(tree.contains(new Point2D(0.3, 0.3)));
    return;
  }
}