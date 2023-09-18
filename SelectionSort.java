import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdIn;

public class SelectionSort implements Comparable<SelectionSort>{

    private int value;

    public SelectionSort(int value) {
        this.value = value;

    }
    public static void main(String[] args) {

        SelectionSort[] arr = new SelectionSort[8000];
        int i = 0;
        while (!StdIn.isEmpty()) {
            arr[i] = new SelectionSort(StdIn.readInt());
            i++;
        }
        sort(arr);
    }

    public static void sort(Comparable[] numbers) {

        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) 
                if (less(numbers[j], numbers[min])) 
                    min = j;
            exch(numbers, i, min);
        }
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    @Override
    public int compareTo(SelectionSort other) {
        // Define how two instances of SelectionSort should be compared.
        // In this case, we're comparing them based on their 'value' field.
        return Integer.compare(this.value, other.value);
    }
}