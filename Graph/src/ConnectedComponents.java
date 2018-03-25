// Aria Pahlavan on March 22 2018

public class ConnectedComponents{
    private final boolean[] marked;
    private final int[] id;
    private int count;

    /**
     * find connected components in G
     * @param G graph
     */
    public ConnectedComponents(Graph G) {
        int V = G.V();
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;

        for (int v = 0; v < V; v++)
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
    }

    /**
     * all vertices found in the same call to dfs and the same id
     * @param G graph
     * @param v vertex
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;

        for (Integer u : G.adjOf(v))
            if (!marked[u])
                dfs(G, u);
    }

    /**
     * @param u starting vertex
     * @param v ending vertex
     * @return true if {@code u} and {@code v} are connected,
     * false otherwise
     */
    public boolean isConnected(int u, int v) {
        return id[u] == id[v];
    }

    /**
     * @return number of connected components
     */
    public int count() {
        return count;
    }

    /**
     * @param v a vertex
     * @return component identifier for {@code v}
     */
    public int id(int v) {
        return id[v];
    }
}
