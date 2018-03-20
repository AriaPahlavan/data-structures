// Aria Pahlavan on March 19 2018

public class Graph {

    /**
     * Create an empty graph with {@code V} vertices
     *
     * @param V number of vertices in the graph
     */
    public Graph(int V) {
    }

    /**
     * Create an empty graph with {@code V} vertices
     *
     * @param V number of vertices in the graph
     * @param edges list of edges in the graph
     */
    public Graph(int V, Pair<Integer, Integer>[] edges) {
    }

    /**
     * Add an edge {@code u-v}
     *
     * @param u incident from vertex {@code u}
     * @param v incident to vertex {@code v}
     */
    public void addEdge(int u, int v) {

    }

    /**
     * @param v the vertex whose adjacency list is being retrieved
     * @return vertices adjacent to {@code v}
     */
    public Iterable<Integer> adjOf(int v) {
        return null;
    }

    /**
     * @return number of vertices in the graph
     */
    public int V() {
        return 0;
    }

    /**
     * @return number of edged in the graph
     */
    public int E() {
        return 0;
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

        return count/2; //each edge is considered twice
    }

    @Override
    public String toString() {
        return "Graph{}";
    }
}
