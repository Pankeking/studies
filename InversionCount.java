import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InversionCount implements Comparable<InversionCount> {

    public InversionCount(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);
        InversionCount[] arr = new InversionCount[length];

        int i = 0;
        while(!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            arr[i] = num;
            i++;
        }
        long startTime = System.nanoTime();
        int counter = count(arr);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1_000_000;
        StdOut.println("Inversion count: " + counter);
    }
}