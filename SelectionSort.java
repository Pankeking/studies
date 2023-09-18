import edu.princeton.cs.algs4.StdIn;

public class SelectionSort {
    public static void main(String[] args) {

        int[] numbers = StdIn.readAllInts();
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) min = numbers[j];
            }
        }
    }
}