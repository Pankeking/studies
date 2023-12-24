import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;#

public class redblackTree<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node middle;
    private Node right;
    private int count;
    
    public Node(Key key, Value val) {
      this.key = key;
      this.value = val;
    }
  }


}