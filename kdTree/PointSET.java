import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET; 


public class PointSET {
	private int size;
	private SET<Point2D> set;

	public PointSET() { // construct an empty set of points 
		this.size = 0;
		this.set = new SET<Point2D>();
	}                   

	public boolean isEmpty() { // is the set empty? 
		return this.set.isEmpty();
	}

	public int size() { // number of points in the set 
		return this.set.size();
	}

	public void insert(Point2D p) {     // add the point to the set (if it is not already in the set)
		if (p == null) throw new IllegalArgumentException();
		this.set.add(p);
		return;
	}

	public boolean contains(Point2D p) { // does the set contain point p?
		if (p == null) throw new IllegalArgumentException();
		return this.set.contains(p);
	}

	public void draw() { // draw all points to standard draw 
    for (Point2D point: this.set) {
      double x = point.x();
      double y = point.y();
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.setPenRadius(0.005);
      StdDraw.point(x, y);
    }
		return;
	}

	public Iterable<Point2D> range(RectHV rect) { // all points that are inside the rectangle (or on the boundary) 
		if (rect == null) throw new IllegalArgumentException();
    SET<Point2D> inbox = new SET<Point2D>();
    for (Point2D point: this.set) {
      if (rect.contains(point)) {
        inbox.add(point);
      }
    }
		return inbox;
	} 

	public Point2D nearest(Point2D p) { // a nearest neighbor in the set to point p; null if the set is empty 
		if (p == null) throw new IllegalArgumentException();
    if (this.set.size() == 0) return null;
    double min = Double.POSITIVE_INFINITY;
    Point2D nearestPoint = p;
    for (Point2D query: this.set) {
      double queryDistance = query.distanceTo(p);
      if (query != p && queryDistance < min) {
        min = queryDistance;
        nearestPoint = query;
      }
    }
		return nearestPoint;
	}

	public static void main(String[] args) { // unit testing of the methods (optional)
		String filename = args[0];
		In in = new In(filename);
		PointSET test = new PointSET();
		StdOut.println(test.isEmpty());
		while (!in.isEmpty()) {
			double x = in.readDouble();
			double y = in.readDouble();
			Point2D point = new Point2D(x, y);
			test.insert(point);
		}
		Point2D queryPoint = new Point2D(0.082912, 0.519);
		boolean queryResult = test.contains(queryPoint);
		// test.draw();
    RectHV cyanRect = new RectHV(0.3, 0.2, 0.4, 0.6);
    RectHV redRect = new RectHV(0.1, 0.1, 0.4, 0.6);
		StdOut.println(queryResult);
		StdOut.println(test.size());
		StdOut.println(test.isEmpty());
    Iterable<Point2D> cyanPoints = test.range(cyanRect);
    Iterable<Point2D> redPoints = test.range(redRect);
    // test.draw();
    // for (Point2D current: cyanPoints) {
    //   double x = current.x();
    //   double y = current.y();
    //   StdDraw.setPenColor(StdDraw.CYAN);
    //   StdDraw.setPenRadius(0.005);
    //   StdDraw.point(x, y);
    // }
    // for (Point2D current: redPoints) {
    //   double x = current.x();
    //   double y = current.y();
    //   StdDraw.setPenColor(StdDraw.RED);
    //   StdDraw.setPenRadius(0.005);
    //   StdDraw.point(x, y);
    // }
    Point2D neighbourPoint = new Point2D(0.072, 0.29);
    StdOut.println(test.nearest(neighbourPoint));
	} 
}