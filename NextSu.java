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
        while(i != id[i]) {
            id[i] = id[id[i]] >= 0 ? id[id[i]] : id[i];
            i = id[i];
        }
        return i < 0 ? -i : i;
    }


    public int find(int i) {
        return id[next(i)];
    }

    public void remove(int i) {
        int p = next(i);
        int q = next(i+1);
        if (p == q) return;

        if(size[i] < size[q]) {
            id[i] = q;
            size[q] += size[i];
        } else {
            id[q] = i;
            size[i] += size[q];
        }
        return;
    }

    public static void main(String[] args) {
        NextSu test = new NextSu(10);
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
        
    }
}