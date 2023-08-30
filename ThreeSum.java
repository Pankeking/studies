import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;

public class ThreeSum {
    
    private int[] numbers;
    private int[] result;
    
    public ThreeSum(int n) {
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = StdIn.readInt();
            numbers[i] = number;
        }

        Arrays.sort(numbers);
        // loop 2 numbers as case  O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j++) {
                int k = binarySearch(numbers, -(numbers[i] + numbers[j]));
            }
        }
        // binary search their negative sum
        // append numbers, i,j,k together to result[]
        // result[] size
        // check repeated trios?
    } 

    private int binarySearch(int[] numbersArray, int doubleSum) {
        int newIndex = numbersArray.length / 2;

        if (numbersArray[newIndex] == doubleSum) return newIndex;
        else if (numbersArray[newIndex] > doubleSum) {
            // cut array in half?? java??
            return binarySearch(
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ThreeSum threeSum = new ThreeSum(n);
    }
}