import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int arraySize;
    private int size = 0;
    private Item item;

    public RandomizedQueue() {
        items = (Item[]) new Object[0];
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
        for (int i = 0; i < arraySize; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // remove and return random item
    public Item deQueue() {
        Item item = items[size--];
        items[size] = null; 
        return item;
    }

    // return a random item without removing it
    public Item sample() {
        Item item = null;
        return item;
    }

    // return an independent iterator over the items in random order
    Iterator<Item> iterator() {

    }
    public static void main(String[] args) {

    }
}
