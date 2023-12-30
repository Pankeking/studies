import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PitonicSearch {
    
    private int[] pitonicArray;
    private boolean result;

    public PitonicSearch(int sampleSize, int target) {
        pitonicArray = new int[sampleSize];
        for (int i = 0; i < sampleSize; i++) {
            int number = StdIn.readInt();
            // StdOut.println(number);
            pitonicArray[i] = number;
        }
        int peak = binaryPeak(pitonicArray);
        result = binarySearch(pitonicArray, 0, peak - 1, target) || binarySearch(pitonicArray, peak, pitonicArray.length - 1, target);
    }
    
    private int binaryPeak(int[] biArray) {
        int left = 0;
        int right = biArray.length - 1;
        int mid = left + ((right - left) / 2);
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (biArray[mid] <= biArray[mid + 1]) {
                left = mid;
            } else if (biArray[mid] <= biArray[mid - 1]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private boolean binarySearch(int[] biArray, int left, int right, int target) {
        // search peak
        while (left < right) {
            int mid = left + ((right - left) / 2);
            // 70: 70 / 71: 71
            if (biArray[mid] == target) {
                StdOut.println(String.format("mid: %d, biArray[mid]: %d", mid, biArray[mid]));
                return true;
            } 
            else if (target < biArray[mid]) {
                if (biArray[left] < biArray[right]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (target > biArray[mid]) {
                
                if (biArray[left] < biArray[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        int sampleSize = StdIn.readInt();
        int target = 188888; // test
        PitonicSearch test = new PitonicSearch(sampleSize, target);
        StdOut.println(test.result);
    }
}