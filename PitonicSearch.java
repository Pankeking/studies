import edu.princeton.cs.algs4.StdIn;

public class PitonicSearch {
    
    private int[] pitonicArray;

    public PitonicSearch(int sampleSize) {
        for (int i = 0; i < sampleSize; i++) {
            
            int number = StdIn.readInt();
            pitonicArray[i] = number;
        }
    }

    private void binarySearch(int i, int j, int q) {
        // middle? 
        // search left
        // search right
        // repeat 
    }

    public static void main(String[] args) {
        int sampleSize = StdIn.readInt();

        PitonicSearch test = new PitonicSearch(sampleSize);
    }
}