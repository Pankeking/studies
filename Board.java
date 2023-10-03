import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Board {

    private int N;
    private int[][] board;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].length != tiles.length) {
                throw new IllegalArgumentException("Not n-by-n dimensions");
            }
        }
        N = tiles.length;
        board = tiles;
    }
    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(N + "\n");
        for (int i = 0; i < N; i++) {
            sb.append(" ");
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return N;
    }

    // number of tiles out of place
    public int hamming() {
        return -1;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return -1;
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
                
        Board board = new Board(tiles);
        String sBoard = board.toString();
        StdOut.println(sBoard);
        
    }

}