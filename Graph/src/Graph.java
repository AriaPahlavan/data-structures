// Aria Pahlavan on March 19 2018

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {
    private final int V;
    private final LinkedList<Integer>[] adj;
    private int E;

    /**
     * Create an empty graph with {@code V} vertices
     *
     * @param V number of vertices in the graph
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (LinkedList<Integer>[]) new LinkedList[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    /**
     * Create an empty graph with {@code V} vertices
     *
     * @param V     number of vertices in the graph
     * @param edges list of edges in the graph
     */
    public Graph(int V, Pair<Integer, Integer>[] edges) {
        this(V);

        for (Pair<Integer, Integer> edge : edges) {
            adj[edge.first()].add(edge.second());
            adj[edge.second()].add(edge.first());
            E++;
        }
    }

    /**
     * Add an edge {@code u-v}
     *
     * @param u incident from vertex {@code u}
     * @param v incident to vertex {@code v}
     * @apiNote parallel edges are allowed
     */
    public void addEdge(int u, int v) {
        //todo disallow parallel edges
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    /**
     * @param v the vertex whose adjacency list is being retrieved
     * @return vertices adjacent to {@code v}
     */
    public Iterable<Integer> adjOf(int v) {
        return adj[v];
    }

    /**
     * @return number of vertices in the graph
     */
    public int V() {
        return V;
    }

    /**
     * @return number of edged in the graph
     */
    public int E() {
        return E;
    }

    /**
     * @return the degree of vertex {@code v}
     */
    public int degreeOf(int v) {
        int degree = 0;
        for (Integer ignored : adjOf(v)) degree++;

        return degree;
    }

    /**
     * @return maximum degree
     */
    public int maxDegree() {
        int max = 0, curDegree;

        for (int v = 0; v < this.V(); v++)
            if ((curDegree = degreeOf(v)) > max)
                max = curDegree;

        return max;
    }

    /**
     * @return average degree
     */
    public double averageDegree() {
        return 2.0 * this.E() / this.V();
    }

    public int numberOfSelfLoop() {
        int count = 0;

        for (int v = 0; v < this.V(); v++)
            for (Integer u : adjOf(v))
                if (v == u) count++;

        return count / 2; //each edge is considered twice
    }

    @Override
    public String toString() {
        String adjListStr = IntStream.range(0, V)
                 .mapToObj(i -> "\t\t(" + i + ')'
                                + adj[i].stream()
                                        .map(v -> "->"+v)
                                        .reduce(String::concat).orElse("") + '\n')
                 .reduce(String::concat).orElse("[NO ADJACENCY LIST]");

        return "Graph{" +
               "\n\tV=" + V +
               ", \n\tE=" + E +
               ", \n\tadj=\n" + adjListStr +
               '}';
    }
}
