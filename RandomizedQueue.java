import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    // private int arraySize;
    private int size = 0;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    // is the RandomizedQueue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the numbers of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        int length = items.length;
        if (size > 0 && size == length) resize(2 * length);
        items[size] = item;
        size++;
    }

    // expand or shrink array
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) copy[i] = items[i];
        }
        items = copy;
    }

    // remove and return random item
    public Item dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        // retrieve random item
        int randomIndex = StdRandom.uniformInt(size);
        Item item = items[randomIndex];
        // last non-null item into retrieved item position
        if (randomIndex != size - 1) {
            items[randomIndex] = items[size - 1]; 
        }
        items[size - 1] = null;
        size--;
        int length = items.length;
        if (size > 0 && size == length / 4) resize(length / 2);
        return item;
    }

    // return a random item without removing it
    public Item sample() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int randomIndex = StdRandom.uniformInt(size);
        return items[randomIndex];
    }

    // return an independent iterator over the items in random order
    public Iterator<Item> iterator() {
        
        StdRandom.shuffle(items);
        return new RandomQueueIterator();
    }
    
    private class RandomQueueIterator implements Iterator<Item> {
        
        int current = 0;
        public boolean hasNext() { return current < size; }
        public Item next() {
            if (current >= size) throw new java.util.NoSuchElementException();
            Item item = items[current];
            current++;
            return item;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> test = new RandomizedQueue<>();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);
        test.enqueue(7);
        test.enqueue(8);
        for (Integer item : test) {
            StdOut.println(item);
        }
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println("dequeue: " + test.dequeue());
        Iterator<Integer> iterator = test.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            StdOut.println(item);
        }
        StdOut.println(test.size());
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println("sample: " + test.sample());
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println(test.isEmpty());
        StdOut.println("size: " + test.size());
        StdOut.println("dequeue: " + test.dequeue());
        StdOut.println(test.isEmpty());
        StdOut.println("size: " + test.size());
    }
}
