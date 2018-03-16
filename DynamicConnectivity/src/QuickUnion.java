// Aria Pahlavan on March 15 2018

public class QuickUnion implements UnionFind {
    private final int id[];
    private int connectedComponents;


    /**
     * @param n init quick-find with n objects
     */
    public QuickUnion(int n){
        connectedComponents = n;
        id = new int[n];

        for (int i = 0; i < id.length; i++) id[i] = i;
    }


    /**
     * Chase parent pointers until reach root
     * (depth of {@code i} array accesses)
     *
     * @param i id of a an element
     * @return the root id for element with id {@code i}
     */
    public int rootOf(int i) {
        while (i != id[i]) i = id[i];

        return i;
    }


    @Override
    public void unionOf(int p, int q) {
        id[rootOf(p)] = id[rootOf(q)];
        connectedComponents--;
    }


    @Override
    public boolean isConnected(int p, int q) {
        validate(id.length, p);
        validate(id.length, q);

        return rootOf(p) == rootOf(q) ;
    }


    @Override
    public int find(int p) {
        return rootOf(p);
    }


    @Override
    public int count() {
        return connectedComponents;
    }
}
