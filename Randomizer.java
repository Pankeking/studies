import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Randomizer {
    

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        Object[] array = new Object[size];
        int i = 0;
        while(!StdIn.isEmpty()) {
            array[i] = StdIn.readInt();
            i++;
        }
        shuffle(array);
        for (Object element : array) {
            StdOut.println(element);
        }
    }

    public static void shuffle(Object[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniformInt(i + 1);
            exchange(a, i, r);
        }
    }

    public static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}