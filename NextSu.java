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
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public int find(int i) {
        return id[next(i)];
    }

    public void remove(int i) {
        if(find(i) == i) {
            return;
        }
        int j = next(i+1);
        
    }
}