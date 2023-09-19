import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BottomUpMerge implements Comparable<BottomUpMerge> {

    private int value;

    public BottomUpMerge(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);
        BottomUpMerge[] arr = new BottomUpMerge[length];

        int i = 0;
        while(!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            arr[i] = new BottomUpMerge(num);
            i++;
        }
        long startTime = System.nanoTime();
        sort(arr);
        Long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
        StdOut.println("Merge sort elapsed time: " + elapsedTime);
        
    }

    private static void sort(Comparable<BottomUpMerge>[] a, Comparable<BottomUpMerge>[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable<BottomUpMerge>[] numbers) {
        BottomUpMerge[] aux = new BottomUpMerge[numbers.length];
        sort(numbers, aux, 0, numbers.length - 1);
    }
    
    private static void merge(Comparable<BottomUpMerge>[] a, Comparable<BottomUpMerge>[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);    // precondition: a[lo..mid]       is sorted
        assert isSorted(a, mid + 1, hi); // precondition: a[mid + 1..hi]  is sorted

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi )              a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];  
        }
        assert isSorted(a, lo, hi);  // post condition: a[lo..hi] is sorted
    }

    public static boolean isSorted(Comparable<BottomUpMerge>[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    private static boolean less(Comparable<BottomUpMerge> v, Comparable<BottomUpMerge> w) {
        return v.compareTo((BottomUpMerge) w) < 0;
    }
    public int compareTo(BottomUpMerge other) {
        return Integer.compare(this.value, other.value);
    }
}