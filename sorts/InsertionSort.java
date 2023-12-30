import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion implements Comparable<Insertion> {

    private int value;

    public Insertion(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);
        
        Insertion[] arr = new Insertion[length];
        
        int i = 0;
        while (!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            arr[i] = new Insertion(num);
            i++;
        }
        long startTime = System.nanoTime();
        sort(arr);
        Long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
        StdOut.println("Insertion sort elapsed time: " + elapsedTime);
    }   
    

    public static void sort(Comparable<Insertion>[] numbers) {
        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(numbers[j], numbers[j - 1])){
                    exch(numbers, j, j - 1);
                } else break;
            }
        }
    }

    private static void exch(Comparable<Insertion>[] a, int i, int j) {
        Comparable<Insertion> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    private static boolean less(Comparable<Insertion> v, Comparable<Insertion> w) {
        // StdOut.println("element: ");
        return v.compareTo((Insertion) w) < 0;
    }
    @Override
    public int compareTo(Insertion other) {
        // Define how two instances of SelectionSort should be compared.
        // In this case, we're comparing them based on their 'value' field.
        return Integer.compare(this.value, other.value);
    }
}