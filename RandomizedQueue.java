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
    public void enQueue(Item item) {
        if (size == items.length) resize(2 * items.length);
        items[size++] = item;
    }

    // expand or shrink array
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // remove and return random item
    public Item deQueue() {
        // retrieve random item
        int randomIndex = StdRandom.uniformInt(size);
        Item item = items[randomIndex];
        // last non-null item into retrieved item position
        items[randomIndex] = items[--size]; 
        items[size] = null;
        if (size > 0 && size == items.length / 4) resize(items.length / 2);
        return item;
    }

    // return a random item without removing it
    public Item sample() {
        int randomIndex = StdRandom.uniformInt(size);
        return items[randomIndex];
    }

    // return an independent iterator over the items in random order
    public Iterator<Item> iterator() {
        StdRandom.shuffle(items, 0, size);
        return new RandomQueueIterator();
    }
    
    private class RandomQueueIterator implements Iterator<Item> {
        private int current = 0;
        public boolean hasNext() { return current < size; }
        public Item next() {
            Item item = items[current];
            current++;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> test = new RandomizedQueue<>();
        test.enQueue(1);
        test.enQueue(2);
        test.enQueue(3);
        test.enQueue(4);
        test.enQueue(5);
        test.enQueue(6);
        test.enQueue(7);
        test.enQueue(8);
        for (Integer item : test) {
            StdOut.println(item);
        }
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println("deQueue: " + test.deQueue());
        Iterator<Integer> iterator = test.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            StdOut.println(item);
        }
        StdOut.println(test.size());
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println("deQueue: " + test.deQueue());
        StdOut.println(test.isEmpty());
    }
}
