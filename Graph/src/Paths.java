// Aria Pahlavan on March 19 2018
import java.util.Stack;

public abstract class Paths {
    final boolean[] marked;
    final int[] edgeTo;
    private final int S;

    /**
     * Find paths in {@code G} from source {@code S}
     * @param G graph
     * @param S source vertex
     */
    Paths(Graph G, int S) {
        this.S = S;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];

        search(G, S);
    }

    /**
     * search for connected vertices to {@code v}
     * @param G graph
     * @param v a vertex
     */
    abstract void search(Graph G, int v);

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

        return path;
    }
}
