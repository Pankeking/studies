import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellSort implements Comparable<ShellSort> {

    private int value;

    public ShellSort(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);
        ShellSort[] arr = new ShellSort[length];

        int i = 0;
        while(!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            arr[i] = new ShellSort(num);
            i++;
        }
        long startTime = System.nanoTime();
        sort(arr);
        Long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
        StdOut.println("Java Shell sort: " + elapsedTime + "ms");
        // for (ShellSort element : arr) {
        //     StdOut.println(element.value);
        // }
        
    }
    
    public static void sort(Comparable<ShellSort>[] numbers) {
        int N = numbers.length;
        // // Shell sort is insertion sort by h positions
        // // H is determined as non trivial increment value
        for (int h = N / 3; h > 0; h /= 3) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(numbers[j], numbers[j - h]); j -= h) {
                    exch(numbers, j , j - h);
                }
            }
        }
        // Shell Sort on while loop
        // VVVVVVVVVVVVVVV
        // VVVVVVVVVVVVVVV
        // VVVVVVVVVVVVVVV
        // int h = 1;
        // while (h < N / 3) {
        //     h = 3 * h + 1;
        // }
        // while (h >= 1) {
        //     // h-sort the array
        //     for (int i = h; i < N; i++) {
        //         for (int j = i; j >= h && less(numbers[j], numbers[j - h]); j -= h) {
        //             exch(numbers, j , j - h);
        //         }
        //     }
        //     h = h / 3;
        // }
    }
    private static void exch(Comparable<ShellSort>[] a, int i, int j) {
        Comparable<ShellSort> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean less(Comparable<ShellSort> v, Comparable<ShellSort> w) {
        return v.compareTo((ShellSort) w) < 0;
    }
    public int compareTo(ShellSort other) {
        return Integer.compare(this.value, other.value);
    }
}