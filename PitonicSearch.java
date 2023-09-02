import edu.princeton.cs.algs4.StdIn;

public class PitonicSearch {
    
    private int[] pitonicArray;
    private boolean result;

    public PitonicSearch(int sampleSize, int target) {
        for (int i = 0; i < sampleSize; i++) {
            
            int number = StdIn.readInt();
            pitonicArray[i] = number;
        }

        result = binarySearch(pitonicArray, peak, target);
    }

    private int binaryPeak(int[] biArray) {
        int left = 0;
        int right = biArray.length - 1;
        while (left <= right) {
            int mid = right / 2;
            if (biArray[mid] < biArray[mid + 1]) {
                left = mid;
            } else if (biArray[mid] < biArray[mid - 1]) {
                right = mid;
            }
        }
    }

    private boolean binarySearch(int[] biArray, int target) {
        int arrayLength = biArray.length;
        int mid = (arrayLength - 1) / 2;
        int left = 0;
        int right = arrayLength - 1;
        // search peak
        while (biArray[left] <= biArray[right]) {
            if (biArray 
        }
        if (biArray[mid] == target) return True;
        // search right
       
        // repeat 
    }

    public static void main(String[] args) {
        int sampleSize = StdIn.readInt();
        int target = 77; // test
        PitonicSearch test = new PitonicSearch(sampleSize, target);
        StdOut.println(test.result);
    }
}