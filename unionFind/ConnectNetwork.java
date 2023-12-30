import edu.princeton.cs.algs4.StdOut;

public class ConnectNetwork {
    private int[] id;
    private int[] size;

    public ConnectNetwork(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int union(int p, int q, int time) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            // Cycle detected, keep size
            return -1;
        }
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        int totalMembers = id.length;
        if (size[i] == totalMembers || size[j] == totalMembers) {
            StdOut.println("\nAll Connected at: " + time + "\n");
            return time;
        }
        return 0;
    }

    public static void main(String[] args) {
        ConnectNetwork network = new ConnectNetwork(8);
        network.union(0,2, 1234);
        network.union(1,3, 1234);
        network.union(0,1, 1234);
        network.union(1,5, 1234);
        network.union(7,6, 1234);
        network.union(4,6, 1234);
        network.union(3,2, 1234);
        network.union(0,4, 555);
        for (int i = 0; i < 8; i++) {
            StdOut.println("index:" + i + " / id(root):" + network.id[i] + " / size:" + network.size[i] + " / root:" + network.root(i));
            StdOut.println("");
        }
    }
}

