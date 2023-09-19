import edu.princeton.cs.algs4.Merge;

public class MergeSort implements Comparable<MergeSort> {

    private int value;

    public MergeSort(int value) {
        this.value = value;
    }
    
    
    private static void merge(Comparable<MergeSort>[] a, Comparable<MergeSort>[] aux, int lo, int mid, int hi) {
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
        assert isSorted(a, lo, hi);  // postcondition: a[lo..hi] is sorted
    }

    private static boolean less(Comparable<MergeSort> v, Comparable<MergeSort> w) {
        return v.compareTo((MergeSort) w) < 0;
    }
    public int compareTo(MergeSort other) {
        return Integer.compare(this.value, other.value);
    }
}