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
        int manhattan;
    }
    private SearchNode solutionNode;
    private class SearchNodeComparator implements Comparator<SearchNode> {
        public int compare(SearchNode one, SearchNode two) {
            int manhattan1 = one.manhattan + one.moves;
            int manhattan2 = two.manhattan + two.moves;
            int compare = Integer.compare(manhattan1, manhattan2);
            if (compare == 0) {
                return Integer.compare(one.manhattan, two.manhattan);
            }
            return compare;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();

        SearchNode initialNode = new SearchNode();
        initialNode.board = initial;
        initialNode.prev = null;
        initialNode.moves = 0;
        initialNode.manhattan = initial.manhattan();

        SearchNode twinNode = new SearchNode();
        Board twin = initial.twin();
        twinNode.board = twin;
        twinNode.prev = null;
        twinNode.moves = 0;
        twinNode.manhattan = twin.manhattan();

        Comparator<SearchNode> comparator = new SearchNodeComparator();
        MinPQ<SearchNode> priorityQ = new MinPQ<SearchNode>(comparator);
        MinPQ<SearchNode> twinQ = new MinPQ<SearchNode>(comparator);

        priorityQ.insert(initialNode);
        twinQ.insert(twinNode);
        while (!priorityQ.isEmpty() || !twinQ.isEmpty()) {
            SearchNode currentNode = priorityQ.delMin();
            SearchNode currentTwin = twinQ.delMin();
            if (currentNode.board.isGoal()) {
                solutionNode = currentNode;
                break;
            }
            if (currentTwin.board.isGoal()) {
                solutionNode.moves = -1;
            }
            Iterable<Board> boards = currentNode.board.neighbors();
            for (Board board : boards) {
                if (currentNode.prev != null && board.equals(currentNode.prev.board)) continue;
                SearchNode newSearchNode = new SearchNode();
                newSearchNode.board = board;
                newSearchNode.prev = currentNode;
                newSearchNode.moves = currentNode.moves + 1;
                newSearchNode.manhattan = board.manhattan();
                priorityQ.insert(newSearchNode);
            }
            Iterable<Board> twinBoards = currentTwin.board.neighbors();
            for (Board twinBoard : twinBoards) {
                if (currentTwin.prev != null && twinBoard.equals(currentTwin.prev.board)) continue;
                SearchNode newTwinSearchNode = new SearchNode();
                newTwinSearchNode.board = twinBoard;
                newTwinSearchNode.prev = currentTwin;
                newTwinSearchNode.moves = currentTwin.moves + 1;    
                newTwinSearchNode.manhattan = twinBoard.manhattan();
                twinQ.insert(newTwinSearchNode);
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return solutionNode.moves >= 0;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return solutionNode.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Stack<Board> solvedStack = new Stack<Board>();
        SearchNode currentSolutionNode = solutionNode;
        while (currentSolutionNode != null) {
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
            // int i = 0;
            for (Board board : solver.solution()) {
                // StdOut.println("Step: " + i);
                StdOut.println(board);
                // i++;
            }
        }
    }

}