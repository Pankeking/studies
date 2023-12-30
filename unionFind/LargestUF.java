import edu.princeton.cs.algs4.StdOut;

public class LargestUF {
    private int[] id;
    private int[] size;

    public LargestUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i] && id[i] >= 0) {
            // Compress path only if it hasn't reached the root(negative wrong path)
            id[i] = id[id[i]] >= 0 ? id[id[i]] : id[i];
            i = id[i];
        }
        return i;   
    }

    private int max(int i, int j) {
        // Compare absolute values
        i = i < 0 ? -i : i;
        j = j < 0 ? -j : j;
        return i < j ? -j : -i;
    }

    public int find(int i) {
        return -id[root(i)];
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            // Cycle detected, keep size
            return;
        }
        int newMax = max(id[i], id[j]);
        if (size[i] < size[j]) {
            id[i] = j;
            id[j] = newMax;
            size[j] += size[i];
        } else {
            id[j] = i;
            id[i] = newMax;
            size[i] += size[j];
        }
        return;
    }

    public static void main(String[] args) {
        LargestUF test = new LargestUF(8);
        test.union(0,1);
        test.union(0,3);
        test.union(3,4);
        test.union(0,2);
        test.union(5,7);
        test.union(5,6);
        test.union(6,7);
        // test.union(2,6);

        StdOut.println(test.find(0));
        StdOut.println(test.find(1));
        StdOut.println(test.find(2));
        StdOut.println(test.find(3));
        StdOut.println(test.find(4));
        StdOut.println(test.find(5));
        StdOut.println(test.find(6));
        StdOut.println(test.find(7));
        for (int i = 0; i < 8; i++) {
            StdOut.println("index:" + i + " / id(root):" + test.id[i] + " / size:" + test.size[i] + " / root:" + test.root(i));
            StdOut.println("");
        }
        return;
    }
}

