public class BST<Key extends Comparable<Key>, Value> {

  private Node root;  
  
  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    
    public Node(Key key, Value val) {
      this.key = key;
      this.val = val;
    }
  }

  public void put(Key key, Value val) {
    
    Node current = root;
    while (current != null) {
      int compared = key.compareTo(current.key);
      if      (compared < 0) current = current.left;
      else if (compared > 0) current = current.right;
      else                   return current
    }
    current.key = key;
    current.val = val;
    return current;
  }

  public Value get(Key key) {
    Node current = root;
    while (current != null) {
      int compared = key.compareTo(current.key)
      if      (compared < 0) current = current.left;
      else if (compared > 0) current = current.right;
      else                   return current.value;
    }
    return null;
  }

  public void delete(Key key) {}

  public Iterable<Key> iterator() {}
  


  public static void main(String[] args) {
  }
}
