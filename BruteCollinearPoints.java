import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    
    private LineSegment[] lineSeg;
    private int numberOfSeg = 0;
    
    public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
        int length = points.length;
        Arrays.sort(points);
        Stack<LineSegment> Lstack = new Stack<LineSegment>();
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                double slopeJ = points[i].slopeTo(points[j]);
                
                for (int k = j + 1; k < length - 1; k++) {
                    double slopeK = points[i].slopeTo(points[k]);
                    
                    for (int l = k + 1; l < length; l++) {
                        if (slopeJ != slopeK) break;
                        double slopeL = points[i].slopeTo(points[l]);
                        
                        if (slopeJ == slopeK && slopeK == slopeL) {
                            Lstack.push(new LineSegment(points[i], points[l]));
                            numberOfSeg++;
                            StdOut.println(numberOfSeg);
                        }
                    }
                }
            }
        }
        StdOut.println(numberOfSeg);
        lineSeg = new LineSegment[numberOfSeg];
        for (int i = 0; i < numberOfSeg; i++) {
            lineSeg[i] = Lstack.pop();
        }
    }   

    public int numberOfSegments() {                 // the number of line segments
        return numberOfSeg;
    }   

    public LineSegment[] segments() {               // the line segments
        return lineSeg;
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
        StdOut.println(p);
    }
    StdDraw.show();
    
    // StdDraw.setPenRadius(0.01);
    StdDraw.setPenColor(50,120,200);
    // print and draw the line segments
    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
    StdOut.println(collinear.numberOfSegments());
    StdOut.println(collinear.segments());
    for (LineSegment segment : collinear.segments()) {
        if (segment != null) segment.draw();
        
    }
    StdDraw.show();
}

}