import edu.princeton.cs.algs4.StdOut;

public class NextSu {
    private int[] id;
    private int[] size;

    public NextSu(int N) {
        id = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int next(int i) {
        while(i != id[i] && id[i] >= 0) {
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
        i = id[next(i)];
        return i < 0 ? -i : i;
    }

    public void remove(int i) {
        int p = next(i);
        int q = next(i+1);
        if (p == q) return;

        int newMax = max(id[p], id[q]);
        if(size[p] < size[q]) {
            id[p] = q;
            id[q] = newMax;
            size[q] += size[p];
        } else {
            id[q] = p;
            id[p] = newMax;
            size[q] += size[p];
        }
        return;
    }

    public static void main(String[] args) {
        NextSu test = new NextSu(3000);
        StdOut.println(test.find(1));
        StdOut.println(test.find(5));
        test.remove(1);
        StdOut.println("Removed 1");
        StdOut.println("find 1: " + test.find(1));
        test.remove(5);
        StdOut.println(test.find(5));
        test.remove(4);
        test.remove(3);
        test.remove(2);
        StdOut.println(test.find(1));
        StdOut.println(test.find(8));
        for(int i = 50; i < 1700; i++) {
            if(i == 1500) continue;
            test.remove(i);
        }
        StdOut.println(test.find(200));
        StdOut.println(test.find(1510));
        StdOut.println(test.find(4));
        
    }
}