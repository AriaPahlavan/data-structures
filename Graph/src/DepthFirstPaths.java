// Aria Pahlavan on March 19 2018

import java.util.Stack;

public class DepthFirstPaths extends Paths{

    /**
     * Find paths in {@code G} from source {@code S}
     * @param G graph
     * @param S source vertex
     */
    DepthFirstPaths(Graph G, int S) {
        super(G, S);
    }

    @Override
    void search(Graph G, int v) {
        dfs(G, v);
    }

    /**
     * Depth first search
     * @param G graph
     * @param v a vertex
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;

        for (Integer u : G.adjOf(v))
            if (!marked[u]) {
                dfs(G, u);
                edgeTo[u] = v;
            }
    }
}
