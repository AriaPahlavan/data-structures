// Aria Pahlavan on March 15 2018

public class WeightedQuickUnion implements UnionFind {
    private final int id[];
    private final int sizes[];
    private int connectedComponents;


    /**
     * @param n init quick-find with n objects
     */
    public WeightedQuickUnion(int n) {
        connectedComponents = n;
        id = new int[n];
        sizes = new int[n];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sizes[i] = 1;
        }
    }


    /**
     * Chase parent pointers until reach root
     * (depth of {@code i} array accesses)
     *
     * @param i id of a an element
     * @return the root id for element with id {@code i}
     */
    public int rootOf(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }


    /**
     * Chase parent pointers until reach root
     * (depth of {@code i} array accesses)
     *
     * @param i id of a an element
     * @return the root id for element with id {@code i}
     * @apiNote This also performs path compression,
     * thereby keeping the tree flat
     */
    public int rootWithPathCompression(int i) {
        if (i == id[i]) return i;

        final int rootOfI = rootWithPathCompression(id[i]);
        id[i] = rootOfI;

        return rootOfI;
    }


    @Override
    public void unionOf(int p, int q) {
        final int i = rootWithPathCompression(p);
        final int j = rootWithPathCompression(q);

        if (i == j) return;

        final int biggerTreeId = (sizes[i] > sizes[j]) ? i : j;
        final int smallerTreeId = (biggerTreeId == i) ? j : i;

        id[smallerTreeId] = biggerTreeId;
        sizes[biggerTreeId] += sizes[smallerTreeId];

        connectedComponents--;
    }


    @Override
    public boolean isConnected(int p, int q) {
        validate(id.length, p);
        validate(id.length, q);

        return rootWithPathCompression(p) == rootWithPathCompression(q);
    }


    @Override
    public int find(int p) {
        return rootWithPathCompression(p);
    }


    @Override
    public int count() {
        return connectedComponents;
    }
}
