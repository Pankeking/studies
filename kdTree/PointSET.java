import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
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
		StdOut.println(this.set);
		return;
	}

	public Iterable<Point2D> range(RectHV rect) { // all points that are inside the rectangle (or on the boundary) 
		if (rect == null) throw new IllegalArgumentException();
		return null;
	} 

	public Point2D nearest(Point2D p) { // a nearest neighbor in the set to point p; null if the set is empty 
		if (p == null) throw new IllegalArgumentException();
		return null;
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
		StdOut.println(queryResult);
		StdOut.println(test.size());
		StdOut.println(test.isEmpty());


	} 
}