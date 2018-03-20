public class Graph {

    /**
     * Create an empty graph with {@code V} vertices
     *
     * @param V number of vertices in the graph
     */
    public Graph(int V) {
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
    Iterable<Integer> adjOf(int v) {
        return null;
    }

    /**
     * @return number of vertices in the graph
     */
    int V() {
        return 0;
    }

    /**
     * @return number of edged in the graph
     */
    int E() {
        return 0;
    }

    @Override
    public String toString() {
        return "Graph{}";
    }
}
