import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    // private int arraySize;
    private int size = 0;
    private Item item;

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
        if (size > items.length) resize(2 * items.length);
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
        items[randomIndex] = items[size]; 
        items[--size] = null;
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
        return new RandomQueueIterator();
    }
    
    private class RandomQueueIterator implements Iterator<Item> {
        private int current = 0;

        private Item[] iterableCopy = (Item[]) new Object[size]; {
            for (int i = 0; i < size; i++) {
                iterableCopy[i] = items[i];
            }
            StdRandom.shuffle(iterableCopy);
        }
        public boolean hasNext() { return current < size; }
        public Item next() {
            Item item = iterableCopy[current];
            current++;
            return item;
        }
    }

    public static void main(String[] args) {

    }
}
