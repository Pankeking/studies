import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// TODO foundTriplets re-sizing array improve performance?

public class ThreeSum {
    
    private int[] inputNumbers;
    private int[][] foundTriplets;
    private int tripletCount;

    public ThreeSum(int n) {
        inputNumbers = new int[n];
        foundTriplets = new int[n * n][3];
        tripletCount = 0;

        for (int i = 0; i < n; i++) {
            int number = StdIn.readInt();
            inputNumbers[i] = number;
        }

        Arrays.sort(inputNumbers);
        for (int i = 0; i < n; i++) {
            // Positive means all i, j, k are positive and not equal to 0-sum
            if (inputNumbers[i] > 0) break;

            // skip duplicates
            if (i > 0 && inputNumbers[i] == inputNumbers[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // skip duplicates
                if (j > i + 1 && inputNumbers[j] == inputNumbers[j - 1]) continue;

                int target = -(inputNumbers[i] + inputNumbers[j]);
                int thirdIndex = binarySearch(inputNumbers, target, j + 1);
                if (thirdIndex != -1 && thirdIndex > j) {
                    foundTriplets[tripletCount] = new int[]{inputNumbers[i], inputNumbers[j], inputNumbers[thirdIndex]};
                    tripletCount++;
                }
            }
        }
    } 

    private int binarySearch(int[] a, int key, int startIndex) {
        int left = startIndex;
        int right = a.length - 1;
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
        int sampleSize = StdIn.readInt();
        
        ThreeSum threeSum = new ThreeSum(sampleSize);
        for (int[] triplet : threeSum.foundTriplets) {
            if (triplet[0] != 0 && triplet[1] != 0 && triplet[2] != 0) {
                StdOut.println(String.format("%d + %d + %d = 0",triplet[0], triplet[1], triplet[2]));
            }
            
        }
        StdOut.println(String.format("Amount of 3-Sum triplets: %d", threeSum.tripletCount));
    }
}