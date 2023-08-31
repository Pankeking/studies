import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;

public class ThreeSum {
    
    private int[] numbers;
    private int[][] result;
    private int[] trie;
    
    public ThreeSum(int n) {
        numbers = new int[n][3];
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            int number = StdIn.readInt();
            numbers[i] = number;
        }

        Arrays.sort(numbers);
        // loop 2 numbers as case  O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = binarySearch(numbers, -(numbers[i] + numbers[j]));
                if (k != -1 && k > j) {
                    result[resultIndex] = new int[]{numbers[i], numbers[j], numbers[k]};
                    resultIndex++;
                }
            }
        }
        // result[] size
        // check repeated trios?
    } 

    private int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ThreeSum threeSum = new ThreeSum(n);
    }
}