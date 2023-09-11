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
        front = new Node();
        back = new Node();
        front.up = null;
        front.down = back;
        back.up = front;
        back.down = null;
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
        Node oldFront = front;
        front = new Node();
        front.item = item;
        front.up = null;
        if (isEmpty()) {
            back = front;
            back.down = null;
        }
        else {
            front.down = oldFront;
            oldFront.up = front;
        }
        dequeSize++;
    }

    // add item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldBack = back;
        back = new Node();
        back.item = item;
        if (isEmpty()) {
            front = back;
            back.up = null;
        } else {
            back.up = oldBack;
            oldBack.down = back;
        }
        dequeSize++;
    }
    // remove and return item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = front.item;
        front = front.down;
        if (dequeSize == 1) {
            front = null;
            back = null;
        }
        dequeSize--;
        return item;
    }
    // remove and return item from the back
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = back.item;
        back = back.up;
        if (dequeSize == 1) {
            back = null;
            front = null;
        }
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
        Deque<Integer> test = new Deque<>();
        StdOut.println(test.size());
        StdOut.println(test.isEmpty());
        test.addFirst(2);
        test.addFirst(3);
        test.addFirst(4);
        test.addLast(1);
        test.addFirst(5);
        test.addLast(10);
        test.addLast(11);
        StdOut.println("r-first: " + test.removeFirst());
        StdOut.println("r-first: " + test.removeFirst());
        StdOut.println("r-first: " + test.removeFirst());
        StdOut.println("r-last: " + test.removeLast());
        StdOut.println("size: " + test.size());
        StdOut.println("r-last: " + test.removeLast());
        StdOut.println("r-last: " + test.removeLast());
        // StdOut.println("r-last: " + test.removeLast());
        StdOut.println("r-first: " + test.removeFirst());
        StdOut.println("size: " + test.size());
        StdOut.println(test.front);
        StdOut.println(test.back);
        test.addFirst(2);
        StdOut.println("r-first: " + test.removeFirst());
        for (Integer item : test) {
            StdOut.println(item);
        }
        StdOut.println(test.back);
        StdOut.println("size: " + test.size());
        


    }

}