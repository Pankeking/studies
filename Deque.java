public class Deque<Item> implements Iterable<Item> {

    private int dequeSize = 0;

    private Node front = null;
    private Node back = null;

    private class Node {
        Item item;
        Node up;
        Node down;
    }
    
    // Construct an empty deque
    public Deque() {
        Node front = new Node();
        Node back = new Node();
    }

    // is the deQueue empty?
    public boolean isEmpty() {
        return dequeSize == 0;
    }

    // return the number of items in the deque
    public int size() {
        return dequeSize;
    }

    // add item to the front
    public void addFirst(Item item) {
        dequeSize++;
    }

    // add item to the back
    public void addLast(Item item) {
        dequeSize++;
    }
    // remove and return item from the front
    public Item removeFirst() {
        dequeSize--;
    }
    // remove and return item from the back
    public Item removeLast() {
        dequeSize--;
    }
    // return an iterator over items from front to back
    public Iterator<Item> iterator() {

    }
    // unit testing (required)    
    public static void main(String[] args) {

    }

}