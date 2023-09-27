import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    
    private LineSegment[] lineSeg;
    private int numberOfSeg = 0;
    
    public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
        checkNullPoints(points);
        int length = points.length;
        Arrays.sort(points);
        Stack<LineSegment> bruteStack = new Stack<LineSegment>();
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                double slopeJ = points[i].slopeTo(points[j]);
                
                for (int k = j + 1; k < length - 1; k++) {
                    double slopeK = points[i].slopeTo(points[k]);
                    
                    for (int p = k + 1; p < length; p++) {
                        if (slopeJ != slopeK) break;
                        double slopeP = points[i].slopeTo(points[p]);
                        
                        if (slopeJ == slopeK && slopeK == slopeP) {
                            bruteStack.push(new LineSegment(points[i], points[p]));
                            numberOfSeg++;
                        }
                    }
                }
            }
        }
        lineSeg = new LineSegment[numberOfSeg];
        for (int i = 0; i < numberOfSeg; i++) {
            lineSeg[i] = bruteStack.pop();
        }
    }   

    private void checkNullPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
        }    
    }

    public int numberOfSegments() {                 // the number of line segments
        return numberOfSeg;
    }   

    public LineSegment[] segments() {               // the line segments
        LineSegment[] copy = lineSeg;
        return copy;
    }   

    public static void main(String[] args) {

    // read the n points from a file
    In in = new In(args[0]);
    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
        int x = in.readInt();
        int y = in.readInt();
        points[i] = new Point(x, y);
    }
    
    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setPenRadius(0.01);
    StdDraw.setXscale(0, 32767);
    StdDraw.setYscale(0, 32767);
    for (Point p : points) {
        p.draw();
    }
    StdDraw.show();
    
    // StdDraw.setPenRadius(0.01);
    StdDraw.setPenColor(50, 120, 200);
    // print and draw the line segments
    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
        if (segment != null) {
            segment.draw();
            StdOut.println(segment);
        }
        
    }
    StdDraw.show();
}

}