public class Percolation {

    private int[][] site;


    public Percolation(int N) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                site[i][j] = j;
                // first and last row connect to upper and lower index
            }
        }
    }

    public void open(int row, int col) {
        if(row <= 0 || col <=0) {
            IllegalArgumentException;
        }
    }

    public boolean isOpen(int row, int col) {
        // connect to adyacent open, 4 step loop? 
    }

    public boolean isFull(int row, int col) {

    }

    public int numberOfOpenSites() {

    }

    public boolean percolates() {

    }

    public static void main(String[] args) {
        Percolation test = new Percolation(20);
    }


    
}