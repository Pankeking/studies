import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {



    public void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, (arr.length -1) );
        assert isSorted(arr);
    }

    private void sort(Comparable[] arr, int low, int high) {
        if (high <= low) return;
        int j = partition(arr, low, high);
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
        assert isSorted(arr, low, high);
    }
    
    // partition the subarray a[low..high] so that a[low..j-1] <= a[j] <= a[j+1..high]
    // and return the index j.
    public static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];

        while (true) {
            // find item on low to swap
            while (less(a[++i], v)) {
                if (i == high) break;
            }
            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == low) break;
            }
            // check if pointers cross
            if (i >= j) break;
            swap(a, i, j);
            
        }
        // put partitioning item v at a[j]
        swap(a, low, j);
        
        // now, a[lo ... j - 1] <= a[j + 1 ... high]
        return j;
    }

    public static void main(String[] args) {
        return;
    }

    // Helper Functions

    public static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    // Assert sorted

    private static boolean isSorted(Comparable[] arr) {
        return isSorted(arr, 0, arr.length - 1);
    }
    private static boolean isSorted(Comparable[] arr, int low, int high) {
        for (int i = low + 1; i < high; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}