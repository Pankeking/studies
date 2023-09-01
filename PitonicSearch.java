import edu.princeton.cs.algs4.StdIn;

public class PitonicSearch {
    
    private int[] pitonicArray;
    private boolean result;

    public PitonicSearch(int sampleSize, int target) {
        for (int i = 0; i < sampleSize; i++) {
            
            int number = StdIn.readInt();
            pitonicArray[i] = number;
        }
        result = binarySearch(pitonicArray, target);
    }

    private boolean binarySearch(int[] pitonicArray, int target) {
        int mid = (pitonicArray.length - 1) / 2;
        int left = 0;
        int right = pitonicArray.length - 1;
        // search left
        if (pitonicArray[mid] == target) return True;
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