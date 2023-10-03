import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Board {

    private int size;
    private int[][] board;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].length != tiles.length) {
                throw new IllegalArgumentException("Not n-by-n dimensions");
            }
        }
        size = tiles.length;
        board = tiles;
    }
    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size + "\n");
        for (int i = 0; i < size; i++) {
            sb.append(" ");
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    // number of tiles out of place
    public int hamming() {
        int hamming = 0;
        for (int i = 0; i < size; i++) 
            for (int j = 0; j < size; j++) {
                if (board[i][j] != ((i * size) + j + 1) && board[i][j] != 0) {
                    hamming += 1;
                }
            }
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int correct = (i * size) + j + 1;
                if (board[i][j] != 0 && board[i][j] != correct) {
                    int mBoard = board[i][j] % size;
                    int dBoard = board[i][j] / size;
                    int mCorrect = correct % size;
                    int dCorrect = correct / size;

                    int x1 = mBoard == 0 ? size : mBoard;
                    int x2 = mCorrect == 0 ? size : mCorrect;
                    int deltaX = abs(x1 - x2);

                    int y1 = mBoard == 0 ? dBoard - 1 : dBoard;
                    int y2 = mCorrect == 0 ? dCorrect - 1 : dCorrect;
                    int deltaY = abs(y1 -y2);

                    count += deltaX + deltaY;
                }
            }
        }
        return count;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // Helper absolute function
    private int abs(int k) {
        return k >= 0 ? k : -k;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        
        In in = new In(args[0]);
        int n = in.readInt();
        int [][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        int[][] tiles2 = {
            {8,1,3},
            {4,0,2},
            {7,6,5}
        };
        Board board = new Board(tiles);
        String sBoard = board.toString();
        int size = board.dimension();
        int hamming = board.hamming();
        int manhattan = board.manhattan();
        StdOut.println(sBoard);
        StdOut.println("\n\n\nsize: " + size);
        StdOut.println("hamming: " + hamming);
        StdOut.println("manhattan: " + manhattan);
    }

}