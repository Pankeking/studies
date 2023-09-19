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
        StdOut.println("Elapsed time: " + elapsedTime);
    }
    public static void sort(Comparable<ShellSort>[] numbers) {
        int N = numbers.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for
            }
        }
    }
}