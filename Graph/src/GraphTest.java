// Aria Pahlavan on March 19 2018

import org.junit.*;


public class GraphTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGraph() {
        int V = 13, E = 13;

        Pair<Integer, Integer>[] edges = (Pair<Integer, Integer>[]) new Pair[]{
                Pair.of(0, 5),
                Pair.of(4, 3),
                Pair.of(0, 1),
                Pair.of(9, 12),
                Pair.of(6, 4),
                Pair.of(5, 4),
                Pair.of(0, 2),
                Pair.of(11, 12),
                Pair.of(9, 10),
                Pair.of(0, 6),
                Pair.of(7, 8),
                Pair.of(9, 11),
                Pair.of(5, 3)
        };

        Graph g = new Graph(V, edges);

        for (int v = 0; v < g.V(); v++)
            for (Integer u : g.adjOf(v))
                System.out.println(v + "-" + u);
    }
}