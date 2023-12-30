import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] trialResults;
    private double confidenceInterval = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Arguments must be above 0");
        trialResults = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                perc.open(row, col);
            }
            double numberOfOpenSites = perc.numberOfOpenSites();
            trialResults[i] = numberOfOpenSites / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(trialResults);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(trialResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((confidenceInterval * stddev()) / Math.sqrt(trialResults.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((confidenceInterval * stddev()) / Math.sqrt(trialResults.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);           // n-by-n percolation system
        int trials = Integer.parseInt(args[1]);    // number of trials
        PercolationStats test = new PercolationStats(n, trials);
        StdOut.println("mean                     =   " + test.mean());
        StdOut.println("stddev                   =   " + test.stddev());
        StdOut.println("95% confidence interval  =   [" + test.confidenceLo() + ", " + test.confidenceHi() + "]");
        
    }


}