// Aria Pahlavan on March 15 2018

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UnionFindTest {
    static UnionFind qf;
    static UnionFind qu;
    static UnionFind wqu;


    @Parameterized.Parameter(0)
    public Integer p;

    @Parameterized.Parameter(1)
    public Integer q;

    @Parameterized.Parameter(2)
    public boolean r;

    @Parameterized.Parameter(3)
    public Integer count;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {1, 2, true, 11},
                {3, 9, true, 10},
                {10, 0, true, 9},
                {8, 6, true, 8 },
                {7, 11, true, 7},
                {4, 5, true, 6 }
        };
        return Arrays.asList(data);
    }

    @BeforeClass
    public static void startUp() throws Exception {
        int N = 12;
        qf = new QuickFind(N);
        qu = new QuickUnion(N);
        wqu = new WeightedQuickUnion(N);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @AfterClass
    public static void cleanUp() throws Exception {
    }

    private void testWith(UnionFind ds) {
        assertEquals("connected before unionOf", !r, ds.isConnected(p, q));
        ds.unionOf(p, q);
        assertEquals("not connected after unionOf", r, ds.isConnected(p, q));
    }

    @Test
    public void TestQuickFind() { testWith(qf); }

    @Test
    public void TestQuickUnion() { testWith(qu); }

    @Test
    public void TestWeightedQuickUnion() { testWith(wqu); }

    private void testCountWith(UnionFind ds) {
        assertEquals("connected component count is wrong",
                     (int)count,
                     ds.count());
    }

    @Test
    public void count() {
        testCountWith(qf);
        testCountWith(qu);
        testCountWith(wqu);
    }
}