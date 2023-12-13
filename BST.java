import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
  private Node root;  
  
  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    private int count;
    
    public Node(Key key, Value val) {
      this.key = key;
      this.value = val;
    }
  }

  public int size() {
    return size(root);
  }
  private int size(Node node) {
    if (node == null) return 0;
    return node.count;
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }
  private Node put(Node current, Key key, Value val) {
        if (current == null) return new Node(key, val);
        int compared = key.compareTo(current.key);
        if (compared < 0) {
            current.left = put(current.left, key, val);
        } 
        else if (compared > 0) {
            current.right = put(current.right, key, val);
        }
        else {
            current.value = val;
        }
        current.count = 1 + size(current.left) + size(current.right);
        return current;
  } 

  public Value get(Key key) {
        Node current = root;
        while (current != null) {
            int compared = key.compareTo(current.key);
            if      (compared < 0) current = current.left;
            else if (compared > 0) current = current.right;
            else                   return current.value;
        }
        return null;
  }
    
    public int rank(Key key) {
        return rank(key, root);
    }
    private int rank(Key key, Node node) {
        if (node == null) return 0;
        int compared = key.compareTo(node.key);
        if (compared < 0) return rank(key, node.left);
        else if (compared > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }

    public Key floor(Key key) {
        Node rootFloor = floor(root, key);
        if (rootFloor == null) return null;
        return rootFloor.key;
    }
    private Node floor(Node current, Key key) {
        if (current == null) return null;

        int cmp = key.compareTo(current.key);
        if (cmp == 0) return current;
        if (cmp < 0) return floor(current.left, key);

        Node rightFloor = floor(current.right, key);
        if (rightFloor != null) return rightFloor;

        else return current;
    }

    public Key ceiling(Key key) {
        Node rootCeiling = ceiling(root, key);
        if (rootCeiling == null) return null;
        return rootCeiling.key;
    }
    private Node ceiling(Node current, Key key) {
        if (current == null) return null;

        int cmp = key.compareTo(current.key);
        if (cmp == 0) return current;
        if (cmp > 0) return ceiling(current.right, key);

        Node leftCeiling = ceiling(current.left, key);
        if (leftCeiling != null) return leftCeiling;

        else return current;
    }

  public Value min() {
        Node current = root;
        while (current != null) {
            if (current.left == null) return current.value;
            current = current.left;
        }
        return null;
  }
  public Value max() {
        Node current = root;
        while (current != null) {
            if (current.right == null) return current.value;
            current = current.right;
        }
        return null;
  }

  public void delete(Key key) {}

  public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
  }
  private void inorder(Node node, Queue<Key> q) {
        if (node == null) return;
        inorder(node.left, q);
        q.enqueue(node.key);
        inorder(node.right, q);
  }
  


  public static void main(String[] args) {
    BST<Integer, String> bst = new BST<>();
    bst.put(50, "key of 50");
    bst.put(30, "key of 30");
    bst.put(20, "key of 20");
    bst.put(40, "key of 40");
    bst.put(70, "key of 70");
    bst.put(60, "key of 60");
    bst.put(80, "key of 80");
   

    Iterable<Integer> iter = bst.keys();
    for (Integer key : iter) {
        StdOut.println(key);
    }
  }
}
