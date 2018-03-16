// Aria Pahlavan on March 15 2018

public interface UnionFind {

    default void validate(int N, int x) {
        if(x < 0 || x >= N) {
            throw new IllegalArgumentException("INVALID ARGUMENT: " + x);
        }
    }


    /**
     * add connection between {@code p} and {@code q}
     *
     * @param p first node
     * @param q second node
     */
    void unionOf(int p, int q);


    /**
     * Check if {@code p} and {@code q} are in the same connected component
     *
     * @param p first node
     * @param q second node
     * @return whther or not {@code p} and {@code q} are connected
     */
    boolean isConnected(int p, int q);


    /**
     * @param p query node
     * @return the component identifier for p (0 to N-1)
     */
    int find(int p);


    /**
     * @return the number of connected components
     */
    int count();
}
