public class MaxPQ<Key extends Comparable<Key>> {
    // private int N;
    private Key[] prioQueue;
    private int value;
    private int size = 0;
    
    public MaxPQ() {
        // Create an empty priority queue
        prioQueue = (Key[])  new Object[2];
    }
    public void insert(Key x) {
        // insert a key into the priority queue
        int length = prioQueue.length - 1;
        if (size > 0 && size == length) resize(length * 2);
        prioQueue[++size] = x;
        swim(size);
    }
    public Key delMax() {
        // return and remove the largest key
        Key max = prioQueue[1];
        swap(1, N--);
        Key key = null;
        return key;
    }

    // 
    //BASIC OPS
    //

    private void sink(int k) {
        while (k*2 <= size) {
            int j = k * 2;
            if (j < size && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && k < k/2) {
            swap(k, k/2);
            k = k/2;
        }
    }

    //
    // Helper Functions
    //
    private void swap(int v, int q) {
        Key tmp = prioQueue[v];
        prioQueue[v] = prioQueue[q];
        prioQueue[q] = tmp;
    }
    private boolean less(int v, int w) {
        if (v == w) return false;
        return v.compareTo((Key) w) < 0;
    }
    private int compareTo(Key other) {
        return Integer.compare(this.value, that.value);
    }
    private void resize(int capacity) {
        Key[] copy = (Key[]) new Object[capacity];
        for (int i = 1; i < size; i++) {
            if (prioQueue[i] != null) {
                copy[i] = prioQueue[i];
            }
        }
        prioQueue = copy;
    }
}