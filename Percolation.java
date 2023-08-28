import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] site;
    private int size;
    private WeightedQuickUnionUF helperUF;


    public Percolation(int N) {
        size = N;
        site = new boolean[N * N + 1];
        helperUF = new WeightedQuickUnionUF(N * N + 2); // index 0  and index N + 1 for top and bottom references
        site[0] = true;
        for(int i = 1; i <= (N * N); i++) {
            // first and last row connect to upper and lower index
            if(i <= N) helperUF.union(i, 0);

            // All sites start blocked
            site[i] = false;
            
        }
    }

    private int xyto1D(int row, int col) {
        return ((row - 1) * size) + col;
    }

    private void checkArgument(int row, int col) {
        if(row <= 0 || col <=0) throw new IllegalArgumentException("Argument must be positive Integer");
    }
    

    public void open(int row, int col) {
        checkArgument(row, col);
        if(!isOpen(row,col)) {
            int center = xyto1D(row, col);
            site[center] = true;

            // connect center to left
            if(isOpen(row, col - 1)) {
                int left = xyto1D(row, col - 1);
                helperUF.union(center, left);
            }
            
            // connect center to right
            if(isOpen(row, col + 1)) {
                int right = xyto1D(row, col + 1);
                helperUF.union(center, right);
            }
            
            // connect center to top
            if(isOpen(row - 1, col)) {
                int top = xyto1D(row - 1, col);
                helperUF.union(center, top);
            }
            
            // connect center to bottom
            if(isOpen(row + 1, col)) {
                int bottom = xyto1D(row + 1, col);
                helperUF.union(center, bottom);
            }
        } else return;
    }
    
    public boolean isOpen(int row, int col) {
        checkArgument(row, col);
        int i = xyto1D(row, col);
        return site[i];
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
        for (int i = 1; i <= 20; i++) {
            for(int j = 1; j <= 20; j++) {
                StdOut.println(i + "," + j + " is: " + (test.isOpen(i,j) ? "Open" : "Blocked"));
                // StdOut.println("Path to :" + i + "," + j + " is: " + test.path[i][j]);
            }
        }
    }


    
}

/**
 * (x0,y-1) // x1, y0 // x0,y1 // x-1,y0
 * 
 * 
 * 
 * 
 * 
 * 
 * 
(1,1)   (2,1)   (3,1)   (4,1)   (5,1)   (6,1)   (7,1)   (8,1)   (9,1)   (10,1)  (11,1)  (12,1)  (13,1)  (14,1)  (15,1)  (16,1)  (17,1)  (18,1)  (19,1)  (20,1)  
(1,2)   (2,2)   (3,2)   (4,2)   (5,2)   (6,2)   (7,2)   (8,2)   (9,2)   (10,2)  (11,2)  (12,2)  (13,2)  (14,2)  (15,2)  (16,2)  (17,2)  (18,2)  (19,2)  (20,2)  
(1,3)   (2,3)   (3,3)   (4,3)   (5,3)   (6,3)   (7,3)   (8,3)   (9,3)   (10,3)  (11,3)  (12,3)  (13,3)  (14,3)  (15,3)  (16,3)  (17,3)  (18,3)  (19,3)  (20,3)  
(1,4)   (2,4)   (3,4)   (4,4)   (5,4)   (6,4)   (7,4)   (8,4)   (9,4)   (10,4)  (11,4)  (12,4)  (13,4)  (14,4)  (15,4)  (16,4)  (17,4)  (18,4)  (19,4)  (20,4)  
(1,5)   (2,5)   (3,5)   (4,5)   (5,5)   (6,5)   (7,5)   (8,5)   (9,5)   (10,5)  (11,5)  (12,5)  (13,5)  (14,5)  (15,5)  (16,5)  (17,5)  (18,5)  (19,5)  (20,5)  
(1,6)   (2,6)   (3,6)   (4,6)   (5,6)   (6,6)   (7,6)   (8,6)   (9,6)   (10,6)  (11,6)  (12,6)  (13,6)  (14,6)  (15,6)  (16,6)  (17,6)  (18,6)  (19,6)  (20,6)  
(1,7)   (2,7)   (3,7)   (4,7)   (5,7)   (6,7)   (7,7)   (8,7)   (9,7)   (10,7)  (11,7)  (12,7)  (13,7)  (14,7)  (15,7)  (16,7)  (17,7)  (18,7)  (19,7)  (20,7)  
(1,8)   (2,8)   (3,8)   (4,8)   (5,8)   (6,8)   (7,8)   (8,8)   (9,8)   (10,8)  (11,8)  (12,8)  (13,8)  (14,8)  (15,8)  (16,8)  (17,8)  (18,8)  (19,8)  (20,8)  
(1,9)   (2,9)   (3,9)   (4,9)   (5,9)   (6,9)   (7,9)   (8,9)   (9,9)   (10,9)  (11,9)  (12,9)  (13,9)  (14,9)  (15,9)  (16,9)  (17,9)  (18,9)  (19,9)  (20,9)  
(1,10)  (2,10)  (3,10)  (4,10)  (5,10)  (6,10)  (7,10)  (8,10)  (9,10)  (10,10) (11,10) (12,10) (13,10) (14,10) (15,10) (16,10) (17,10) (18,10) (19,10) (20,10) 
(1,11)  (2,11)  (3,11)  (4,11)  (5,11)  (6,11)  (7,11)  (8,11)  (9,11)  (10,11) (11,11) (12,11) (13,11) (14,11) (15,11) (16,11) (17,11) (18,11) (19,11) (20,11) 
(1,12)  (2,12)  (3,12)  (4,12)  (5,12)  (6,12)  (7,12)  (8,12)  (9,12)  (10,12) (11,12) (12,12) (13,12) (14,12) (15,12) (16,12) (17,12) (18,12) (19,12) (20,12) 
(1,13)  (2,13)  (3,13)  (4,13)  (5,13)  (6,13)  (7,13)  (8,13)  (9,13)  (10,13) (11,13) (12,13) (13,13) (14,13) (15,13) (16,13) (17,13) (18,13) (19,13) (20,13) 
(1,14)  (2,14)  (3,14)  (4,14)  (5,14)  (6,14)  (7,14)  (8,14)  (9,14)  (10,14) (11,14) (12,14) (13,14) (14,14) (15,14) (16,14) (17,14) (18,14) (19,14) (20,14) 
(1,15)  (2,15)  (3,15)  (4,15)  (5,15)  (6,15)  (7,15)  (8,15)  (9,15)  (10,15) (11,15) (12,15) (13,15) (14,15) (15,15) (16,15) (17,15) (18,15) (19,15) (20,15) 
(1,16)  (2,16)  (3,16)  (4,16)  (5,16)  (6,16)  (7,16)  (8,16)  (9,16)  (10,16) (11,16) (12,16) (13,16) (14,16) (15,16) (16,16) (17,16) (18,16) (19,16) (20,16) 
(1,17)  (2,17)  (3,17)  (4,17)  (5,17)  (6,17)  (7,17)  (8,17)  (9,17)  (10,17) (11,17) (12,17) (13,17) (14,17) (15,17) (16,17) (17,17) (18,17) (19,17) (20,17) 
(1,18)  (2,18)  (3,18)  (4,18)  (5,18)  (6,18)  (7,18)  (8,18)  (9,18)  (10,18) (11,18) (12,18) (13,18) (14,18) (15,18) (16,18) (17,18) (18,18) (19,18) (20,18) 
(1,19)  (2,19)  (3,19)  (4,19)  (5,19)  (6,19)  (7,19)  (8,19)  (9,19)  (10,19) (11,19) (12,19) (13,19) (14,19) (15,19) (16,19) (17,19) (18,19) (19,19) (20,19) 
(1,20)  (2,20)  (3,20)  (4,20)  (5,20)  (6,20)  (7,20)  (8,20)  (9,20)  (10,20) (11,20) (12,20) (13,20) (14,20) (15,20) (16,20) (17,20) (18,20) (19,20) (20,20)

 */