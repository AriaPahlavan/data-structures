import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PercolationSimulationTest {
    static PercolationSimulation ps;

    @Parameterized.Parameter(0)
    public Integer i;

    @Parameterized.Parameter(1)
    public boolean r;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {1, false},
                {6, false},
                {11, false},
                {16, false},
                {21, true},
        };
        return Arrays.asList(data);
    }


    @BeforeClass
    public static void startUp() throws Exception {
        ps = new PercolationSimulation(5);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testPercolationSimulation() {
        ps.openSiteAt(i);
        assertEquals(r, ps.isPerculated());
    }
}