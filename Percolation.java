import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] site;
    private int size;
    private WeightedQuickUnionUF helperUF;
    private int openSites;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("Argument is out of bounds");
        size = n;
        site = new boolean[n * n + 1];
        openSites = 0;
        helperUF = new WeightedQuickUnionUF((n * n) + 2); // index 0  and index N + 1 for top and bottom references
        site[0] = false;
        for (int i = 1; i <= (size * size); i++) {
            // first and last row connect to upper and lower index
            // StdOut.println("find 5: " + helperUF.find(5));
            if (i <= size) helperUF.union(0, i);
            if (i > (size * (size - 1))) {
                helperUF.union((size * size) + 1, i);
                // StdOut.println((size * size) + 1 + " i:" + i);
            }
            site[i] = false; // All sites start blocked
        }
    }
    private int xyTo1D(int row, int col) {
        return ((row - 1) * size) + col;
    }
    private int checkArgument(int row, int col) {
        if (row <= 0 || col <= 0 || row > size || col > size) throw new IllegalArgumentException("Argument is out of bounds");
        return xyTo1D(row, col);
    }

    public void open(int row, int col) {
        int center = checkArgument(row, col);
        if (!isOpen(row, col) && !site[center]) {
            site[center] = true;
            // StdOut.println("Opened: " + row + ", " + col + " // center: " + center);
            openSites++;
            // if(openSites != numberOfOpenSites()) StdOut.println("New open sites: " + openSites + "  function number of open: " + numberOfOpenSites());
            // connect center to left
            if (col > 1 && isOpen(row, col - 1)) {
                int left = xyTo1D(row, col - 1);
                helperUF.union(center, left);
                // StdOut.println("opened left");
            }
            // connect center to right
            if (col < size && isOpen(row, col + 1)) {
                int right = xyTo1D(row, col + 1);
                helperUF.union(center, right);
                // StdOut.println("opened right");
            }
            // connect center to top
            if (row > 1 && isOpen(row - 1, col)) {
                int top = xyTo1D(row - 1, col);
                helperUF.union(center, top);
                // StdOut.println("opened top");
            }
            // connect center to bottom
            if (row < size && isOpen(row + 1, col)) {
                int bottom = xyTo1D(row + 1, col);
                helperUF.union(center, bottom);
                // StdOut.println("opened bottom");
            }
        }
    }
    public boolean isOpen(int row, int col) {
        int i = checkArgument(row, col);
        return site[i];
    }
    public boolean isFull(int row, int col) {
        int i = checkArgument(row, col);
        return isOpen(row, col) && helperUF.find(i) == helperUF.find(0);
    }
    public int numberOfOpenSites() {
        return openSites;
    }
    public boolean percolates() {
        // StdOut.println("find top: " + helperUF.find(0) + "  find bottom: " + helperUF.find((size * size) + 1 ));
        if (openSites < size) return false;
        return helperUF.find(0) == helperUF.find((size * size) + 1);
    }
    public static void main(String[] args) {
        int testingSize = 2;

        Percolation test = new Percolation(testingSize);
        // for(int i = 1; i <= testingSize; i++) {
        //     for(int j = 1; j <= testingSize; j++) {
        //         if(i == testingSize) StdOut.println(test.helperUF.find(test.xyTo1D(i,j)));
        //     }
        // }
        // while(!test.percolates()) {
        //     int i = StdRandom.uniformInt(1, testingSize + 1);
        //     int j = StdRandom.uniformInt(1, testingSize + 1);
        //     test.open(i,j);
        // }
        StdOut.println(test.percolates());
        test.open(1, 1);
        StdOut.println(test.percolates());
        test.open(2, 2);
        StdOut.println(test.percolates());
        StdOut.println(test.percolates() ? "Percolates at: " + test.numberOfOpenSites() : "Doesn't percolate");
    }
}
