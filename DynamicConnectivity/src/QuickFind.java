// Aria Pahlavan on March 15 2018

import java.util.Arrays;

public class QuickFind implements UnionFind{
    private final int id[];
    private int connectedComponents;

    /**
     * @param n init quick-find with n objects
     */
    public QuickFind(int n){
        connectedComponents = n;
        id = new int[n];

        for (int i = 0; i < id.length; i++) id[i] = i;
    }


    @Override
    public void unionOf(int p, int q) {
        if (isConnected(p, q)) {
            return;
        }

        int pid = id[p], qid = id[q];

        for (int i = 0; i < id.length; i++)
            if (id[i] == qid)
                id[i] = pid ;

        connectedComponents--;
    }

    @Override
    public boolean isConnected(int p, int q) {
        validate(id.length, p);
        validate(id.length, q);

        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return connectedComponents;
    }

    @Override
    public String toString() {
        return "QuickFind{" +
               "id=" + Arrays.toString(id) +
               ", count=" + connectedComponents +
               '}';
    }
}
