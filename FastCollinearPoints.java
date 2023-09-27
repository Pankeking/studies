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
            for (int i = 0; i < length; i++) {
                copy[i] = points[i];
            }
            Arrays.sort(copy);
            // Iterate every point as origin and sort by slopes
            for (int i = 0; i < length - 3; i++) {
                Point origin = points[i];
                Comparator<Point> slopeComparator = origin.slopeOrder();
                mergeSort(copy, slopeComparator);
                // Arrays.sort(copy, tmpComp);
                for (int j = 1; j < length - 2; j++) {
                    double slopeJ = origin.slopeTo(copy[j]);
                    double slopeK = origin.slopeTo(copy[j + 1]);
                    double slopeL = origin.slopeTo(copy[j + 2]);
                    if (slopeJ == slopeK && slopeJ == slopeL) {
                        int l = j + 2;
                        for (int k = l; slopeL != slopeJ; k++) {
                            slopeL = origin.slopeTo(copy[k]);
                            l = k;
                        }
                        LineSegment lineSegment = new LineSegment(origin,copy[l]);
                        // StdOut.println(lineSegment);
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

        private static void mergeSort(Point[] points, Point[] aux, int lo, int hi, Comparator<Point> slopeComparator) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            mergeSort(points, aux, lo, mid, slopeComparator);
            mergeSort(points, aux, mid + 1, hi, slopeComparator);
            merge(points, aux, lo, mid, hi, slopeComparator);
        }

        public static void mergeSort(Point[] points, Comparator<Point> slopeComparator) {
            Point[] aux = new Point[points.length];
            mergeSort(points, aux, 0, points.length - 1, slopeComparator);
        }

        private static void merge(Point[] points, Point[] aux, int lo, int mid, int hi, Comparator<Point> slopeComparator) {
            for (int k = lo; k <= hi; k++) {
                aux[k] = points[k];
            }

            int i = lo;
            int j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if      (i > mid)                                points[k] = aux[j++];
                else if (j > hi )                                points[k] = aux[i++];
                else if (slopeComparator.compare(aux[j], aux[i]) < 0) points[k] = aux[j++];
                else                                             points[k] = aux[i++];
            }
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