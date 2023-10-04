import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

    private class SearchNode {
        Board board;
        SearchNode prev;
        int moves;
    }
    private SearchNode solutionNode;
    private class SearchNodeComparator implements Comparator<SearchNode> {
        public int compare(SearchNode one, SearchNode two) {
            int manhattan1 = one.board.manhattan() + one.moves;
            int manhattan2 = two.board.manhattan() + two.moves;
            return Integer.compare(manhattan1, manhattan2);
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();

        SearchNode initialNode = new SearchNode();
        initialNode.board = initial;
        initialNode.prev = null;
        initialNode.moves = 0;

        Comparator<SearchNode> comparator = new SearchNodeComparator();
        MinPQ<SearchNode> priorityQ = new MinPQ<SearchNode>(comparator);

        priorityQ.insert(initialNode);
        while (!priorityQ.isEmpty()) {
            SearchNode currentNode = priorityQ.delMin();
            if (currentNode.board.isGoal()) {
                solutionNode = currentNode;
                break;
            }
            Iterable<Board> boards = currentNode.board.neighbors();
            for (Board board : boards) {
                SearchNode newSearchNode = new SearchNode();
                newSearchNode.board = board;
                newSearchNode.prev = currentNode;
                newSearchNode.moves = currentNode.moves + 1;
                priorityQ.insert(newSearchNode);
            } 
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Stack<Board> solvedStack = new Stack<Board>();
        SearchNode currentSolutionNode = solutionNode;
        while (currentSolutionNode.prev != null) {
            solvedStack.push(currentSolutionNode.board);
            currentSolutionNode = currentSolutionNode.prev;
        }
        return solvedStack;
    }

    // test client (see below) 
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable()) {
            StdOut.println("No solution possible");
        }
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution()) {
                StdOut.println(board);
            }
        }
    }

}