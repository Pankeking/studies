public class MaxPQ<Key extends Comparable<Key>> {
    // private int N;
    private Key[] priorityQueue;
    private int size = 0;
    


    public MaxPQ() {
        // Create an empty priority queue
        priorityQueue = (Key[])  new Object[2];
    }
    //
    // Basic Ops
    //
    public boolean isEmpty() {
        return size == 0;
    } 
    public int size() {
        return size;
    }
    
    
    // 
    // Heap OPS
    //
    public void insert(Key x) {
        int length = priorityQueue.length - 1;
        if (size > 0 && size == length) resize(length * 2);
        
        // insert a key into the priority queue
        priorityQueue[++size] = x;
        swim(size);
    }

    public Key delMax() {
        // return and remove the largest key
        if (isEmpty()) throw new IllegalStateException("Priority queue is empty");
    
        Key max = priorityQueue[1];
        swap(1, size--);

        int length = priorityQueue.length - 1;
        if (size > 0 && size <= length / 4) resize(length / 2);

        sink(1);
        priorityQueue[size+1] = null;
        return max;
    }
    
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
        Key tmp = priorityQueue[v];
        priorityQueue[v] = priorityQueue[q];
        priorityQueue[q] = tmp;
    }
    private boolean less(int v, int w) {
        if (v == w) return false;
        return priorityQueue[v].compareTo((Key) priorityQueue[w]) < 0;
    }

    // private int compareTo(Key other) {
    //     return Integer.compare(this.value, other.value);
    // }

    private void resize(int capacity) {
        Key[] copy = (Key[]) new Object[capacity];
        for (int i = 1; i < size; i++) {
            if (priorityQueue[i] != null) {
                copy[i] = priorityQueue[i];
            }
        }
        priorityQueue = copy;
    }
}