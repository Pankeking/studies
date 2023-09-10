import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

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
        front.up = null;
        front.item = null;
        front.down = back;
        back.up = front;
        back.down = null;
        back.item = null;
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
        if (item == null) throw new IllegalArgumentException();
        if (isEmpty()) {
            front.item = item;
            back = front;
        } else {
            Node oldFront = front;
            Node front = new Node();
            front.item = item;
            oldFront.up = front;
            front.down = oldFront;
        }
        dequeSize++;
    }

    // add item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (isEmpty()) {
            back.item = item;
            front = back;
        } else {
            Node oldBack = back;
            Node back = new Node();
            back.item = item;
            oldBack.down = back;
            back.up = oldBack;
        }
        dequeSize++;
    }
    // remove and return item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = front.item;
        front = front.down;
        dequeSize--;
        return item;
    }
    // remove and return item from the back
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = back.item;
        back = back.up;
        dequeSize--;
        return item;
    }
    // return an iterator over items from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    } 
    private class DequeIterator implements Iterator<Item> {
        private Node current = front;

        public boolean hasNext() { return current != null; }
        public Item next() {
            Item item = current.item;
            current = current.down;
            return item;
        }
    }
    // unit testing (required)    
    public static void main(String[] args) {
        Deque<Integer> test = new Deque<Integer>();
        StdOut.println(test.size());
        StdOut.println(test.isEmpty());
        test.addFirst(2);
        test.addFirst(3);
        test.addLast(1);
        StdOut.println(test.removeLast());
        StdOut.println(test.removeFirst());
        StdOut.println(test.size());
        StdOut.println(test.removeLast());
        StdOut.println(test.size());


    }

}