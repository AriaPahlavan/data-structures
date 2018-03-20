// Aria Pahlavan on March 19 2018

import java.util.Stack;

public class DepthFirstPaths {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int S;

    /**
     * Find paths in {@code G} from source {@code S}
     * @param G graph
     * @param S source vertex
     */
    DepthFirstPaths(Graph G, int S) {
        this.S = S;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];

        dfs(G, S);
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

    /**
     * @return true if there's a path from {@code s} to {@code v},
     * false otherwise
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    /**
     * @return an iterable representing path from {@code s} to {@code v},
     * null if no path exists
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> path = new Stack<>();

        for (int x = v; x != S; x = edgeTo[x])
            path.push(x);

//        int x = v;
//        do path.push(x); while ((x=edgeTo[x]) != S);

        return path;
    }
}
