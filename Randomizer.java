import edu.princeton.cs.algs4.StdRandom;

public class Randomizer {
    public static void shuffle (Object[] a) {
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