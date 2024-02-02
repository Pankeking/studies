import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KdTreeInputVisualizer {

  public static void main(String[] args) {
    RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
    KdTree kdtree = new KdTree();
    
    while (!StdIn.isEmpty()) {
      double x = StdIn.readDouble();
      double y = StdIn.readDouble();
      Point2D p = new Point2D(x, y);
      if (rect.contains(p)) {
        kdtree.insert(p);
      }
    }
    kdtree.draw();
    StdDraw.show();
  }
}