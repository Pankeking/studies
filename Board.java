import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

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
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] < 0) throw new IllegalArgumentException("Invalid negative value");
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
                if (size >= 10) {
                    sb.append(" ");
                    if (board[i][j] / size == 0) sb.append(" ");
                }
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
                    
                    int xBoard = board[i][j] % size;
                    int yBoard = board[i][j] / size;

                    int xCorrect = correct % size;
                    int yCorrect = correct / size;

                    int x1 = xBoard == 0 ? size : xBoard;
                    int x2 = xCorrect == 0 ? size : xCorrect;
                    int deltaX = abs(x1 - x2);

                    int y1 = xBoard == 0 ? yBoard - 1 : yBoard;
                    int y2 = xCorrect == 0 ? yCorrect - 1 : yCorrect;
                    int deltaY = abs(y1 -y2);

                    count += deltaX + deltaY;
                }
            }
        }
        return count;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) {
                    if (board[i][j] != 0) return false;
                    else continue;
                }
                if (board[i][j] != (i * size) + j + 1) return false;
            }
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        if (that.dimension() != this.dimension()) return false;
        if (that.board.length != this.board.length) return false;
        for (int i = 0; i < that.board.length; i++) {
            if (that.board[i].length != this.board[i].length) return false;
            for (int j = 0; j < that.board[i].length; j++) {
                if (that.board[i][j] != this.board[i][j]) return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> boardStack = new Stack<Board>(); 
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    if (i != 0) {
                        int[][] copyUp = deepCopy(board);
                        swap(copyUp, i, j, i-1, j);
                        Board upBoard = new Board(copyUp);
                        boardStack.push(upBoard);
                    }
                    if (i != size - 1) {
                        int[][] copyDown = deepCopy(board);
                        swap(copyDown, i, j, i+1, j);
                        Board downBoard = new Board(copyDown);
                        boardStack.push(downBoard);
                    }
                    if (j != 0) {
                        int[][] copyLeft = deepCopy(board);
                        swap(copyLeft, i, j, i, j-1);
                        Board leftBoard = new Board(copyLeft);
                        boardStack.push(leftBoard);
                    }
                    if (j != size - 1) {
                        int[][] copyRight = deepCopy(board);
                        swap(copyRight, i, j, i, j+1);
                        Board rightBoard = new Board(copyRight);
                        boardStack.push(rightBoard);
                    }
                    return boardStack;
                }
            }
        }
        return boardStack;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] twin = deepCopy(board);
        int x = StdRandom.uniformInt(size);
        int y = StdRandom.uniformInt(size);
        int dx = StdRandom.uniformInt(size);
        int dy = StdRandom.uniformInt(size);
        while (twin[y][x] == 0) {
            x = StdRandom.uniformInt(size);
            y = StdRandom.uniformInt(size);
        }
        while (twin[dy][dx] == 0) {
            dx = StdRandom.uniformInt(size);
            dy = StdRandom.uniformInt(size);
        }
        swap(twin, y, x, dy, dx);
        return new Board(twin);
    }

    // Helper functions
    private int abs(int k) {
        return k >= 0 ? k : -k;
    }
    private void swap(int[][] swapBoard, int y, int x, int dy, int dx) {
        int tmp = swapBoard[y][x];
        swapBoard[y][x] = swapBoard[dy][dx];
        swapBoard[dy][dx] = tmp;
    }
    private int[][] deepCopy(int[][] baseBoard) {
        int[][] copyBoard = new int[baseBoard.length][];
        for (int i = 0; i < baseBoard.length; i++) {
            copyBoard[i] = Arrays.copyOf(baseBoard[i], baseBoard[i].length);
        }
        return copyBoard;
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
        int[][] tiles3 = {
            {8,1,3},
            {4,0,2},
            {7,6,5}
        };
        int[][] tiles4 = {
            {1,2,3},
            {4,5,6},
            {7,8,0}
        };
        Board board = new Board(tiles);
        Board equalBoard = new Board(tiles3);
        String sBoard = board.toString();
        int size = board.dimension();
        int hamming = board.hamming();
        int manhattan = board.manhattan();
        boolean equality = board.equals(equalBoard);
        boolean goal = board.isGoal();
        Iterable<Board> neighbors = board.neighbors();
        Board twin = board.twin();
        StdOut.println(sBoard);
        StdOut.println("\n\n\nsize: " + size);
        StdOut.println("hamming: " + hamming);
        StdOut.println("manhattan: " + manhattan);
        StdOut.println("equals: " + equality);
        StdOut.println("Goal: " + goal);
        for (Board nextMove : neighbors) {
            StdOut.println("\n");
            StdOut.println(nextMove.toString());
        }
        StdOut.println("original: " + board.toString());
        StdOut.println("twin: " + twin.toString());
    }

}