// Aria Pahlavan on March 20 2018

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends Paths {
    public BreadthFirstPaths(Graph G, int S) {
        super(G, S);
    }

    @Override
    void search(Graph G, int v) {
        bfs(G, v);
    }

    /**
     * Breadth first search
     * @param G graph
     * @param s a vertex
     */
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (Integer u : G.adjOf(v))
                if (!marked[u]) {
                    queue.add(u);
                    marked[u] = true;
                    edgeTo[u] = v;
                }
        }
    }
}
