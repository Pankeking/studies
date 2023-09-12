import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        
        int k = Integer.parseInt(args[0]);
        int j = 0;
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            if (j < k) {
                j++;
                randomizedQueue.enqueue(StdIn.readString());
            }
        }
        for (String s : randomizedQueue) {
            StdOut.println(s);
        }
    }
}