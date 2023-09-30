import edu.princeton.cs.algs4.StdRandom;

public class Quick {



    public void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, (arr.length -1) );
        assert isSorted(arr);
    }

    private void sort(Comparable[] arr, int lo, int hi) {
        Comparable pivot = arr[lo];
        return;
    }
    
    public void partition() {
        return;
    }

    public static void main(String[] args) {
        return;
    }

    // Helper Functions

    public static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }
    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Assert sorted

    private static boolean isSorted(Comparable[] arr) {
        return isSorted(arr, 0, arr.length - 1);
    }
    private static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}