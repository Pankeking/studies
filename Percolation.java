import edu.princeton.cs.algs4.StdOut;

public class Percolation {

    private boolean[][] site;
    private int[][] path;


    public Percolation(int N) {
        site = new boolean[N][N];
        path = new int[N][N];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {

                // first and last row connect to upper and lower index
                if(i == 1 || i == N) path[i][j] = 0;
                else path[i][j] = j;
                StdOut.println("does it get here?");
                // All sites start blocked
                site[i][j] = false;
            }
        }
    }

    private void checkArgument(int row, int col) {
        if(row <= 0 || col <=0) {
            throw new IllegalArgumentException("Argument must be positive Integer");
        }
    }

    public void open(int row, int col) {
        checkArgument(row, col);
        if(!isOpen(row,col)) {

        } else return;
    }
    
    public boolean isOpen(int row, int col) {
        checkArgument(row, col);
        // connect to adyacent open, 4 step loop? 
        return site[row][col];
    }
    
    public boolean isFull(int row, int col) {
        checkArgument(row, col);
        return true;
    }
    
    public int numberOfOpenSites() {
        return 0;
    }
    
    public boolean percolates() {
        return true;

    }

    public static void main(String[] args) {
        Percolation test = new Percolation(20);
        test.isOpen(0,0);
    }


    
}