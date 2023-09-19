import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SelectionSort implements Comparable<SelectionSort>{

    private int value;

    public SelectionSort(int value) {
        this.value = value;

    }
    public static void main(String[] args) {

        int length = Integer.parseInt(args[0]);
        SelectionSort[] arr = new SelectionSort[length];
        int i = 0;
        while (!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            arr[i] = new SelectionSort(num);
            i++;
        }
        sort(arr);
        for (SelectionSort element : arr) {
            StdOut.println(element.value);
        }
    }

    public static void sort(Comparable<SelectionSort>[] numbers) {
        
        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(numbers[j], numbers[min])) {
                    min = j;
                }
            }
            exch(numbers, i, min);
        }
    }
    private static void exch(Comparable<SelectionSort>[] a, int i, int j) {
        Comparable<SelectionSort> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean less(Comparable<SelectionSort> v, Comparable<SelectionSort> w) {
        // StdOut.println("element: ");
        return v.compareTo((SelectionSort) w) < 0;
    }
    @Override
    public int compareTo(SelectionSort other) {
        // Define how two instances of SelectionSort should be compared.
        // In this case, we're comparing them based on their 'value' field.
        return Integer.compare(this.value, other.value);
    }
}