import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBinarySearch() {
        Integer[] l = {1,2,3,9,12,20,31};
        Character[] s = {'a','b','b','d','i','x','y'};

        assertEquals(4, BinarySearch.on(l, 12));
        assertEquals(5, BinarySearch.on(s, 'x'));

        assertEquals(4, BinarySearch.recursivelyOn(l, 12));
        assertEquals(5, BinarySearch.recursivelyOn(s, 'x'));

    }
}