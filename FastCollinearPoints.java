import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {

    private LineSegment[] lineSeg;
    private int numberOfSeg = 0;

    public FastCollinearPoints(Point[] points) {    // finds all line segments containing 4 or more points
        checkNullPoints(points);
        int length = points.length;
        Stack<LineSegment> fastStack = new Stack<LineSegment>();
        Point[] copy = new Point[length];
        Arrays.sort(points);
        for (int i = 0; i < length; i++) {
            copy[i] = points[i];
        }
        // Iterate every point as origin and sort by slopes
        for (int i = 0; i < length - 3; i++) {
            if (i < 10) {
                StdOut.println(String.format("\npoints[%d]: %s\n",i, points[i].toString()));
            }
            Comparator<Point> tmpComp = points[i].slopeOrder();
            // mergeSort(copy, tmpComp);
            Arrays.sort(copy, tmpComp);
            for (int j = i + 1; j < length - 2; j++) {
                double slopeJ = points[i].slopeTo(copy[j]);
                double slopeK = points[i].slopeTo(copy[j + 1]);
                double slopeL = points[i].slopeTo(copy[j + 2]);
                if (slopeJ == slopeK && slopeJ == slopeL) {
                    // for (int k = j + 2; points[i].slopeTo(copy[k]) != slopeJ; k++) {
                    //     slopeL = points[i].slopeTo(copy[k]);
                    //     j = k;
                    // }
                    LineSegment lineSegment = new LineSegment(points[i],copy[j + 2]);
                    // fastStack.push(new LineSegment(points[i], copy[j]));
                    StdOut.println(lineSegment);
                    fastStack.push(lineSegment);
                    numberOfSeg++;
                }
                if ( i< 10) {

                    StdOut.println(String.format("slopeJ: %.2f  / slopeK: %.2f  / slopeL: %.2f",slopeJ, slopeK, slopeL));
                }
            }
        }

        lineSeg = new LineSegment[numberOfSeg];
        for (int i = 0; i < numberOfSeg; i++) {
            lineSeg[i] = fastStack.pop();
        }
        
    }   

    private void checkNullPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
        }    
    }

    private static void mergeSort(Point[] points, Point[] aux, int lo, int hi, Comparator<Point> comparator) {
        int length = points.length;
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(points, aux, lo, mid, comparator);
        mergeSort(points, aux, lo, mid, comparator);
        merge(points, aux, lo, mid, hi, comparator);
    }

    public static void mergeSort(Point[] points, Comparator<Point> comparator) {
        Point[] aux = new Point[points.length];
        mergeSort(points, aux, 0, points.length - 1,comparator);
    }

    private static void merge(Point[] points, Point[] aux, int lo, int mid, int hi, Comparator<Point> comparator) {

    }

    public           int numberOfSegments()    {    // the number of line segments
        return numberOfSeg;
    }

    public LineSegment[] segments()            {    // the line segments
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
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
        p.draw();
    }
    StdDraw.show();

    // print and draw the line segments
    FastCollinearPoints collinear = new FastCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
        StdOut.println(segment);
        segment.draw();
    }
    StdDraw.show();
}
}