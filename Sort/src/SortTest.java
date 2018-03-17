import org.junit.Before;

import static org.junit.Assert.*;

public class SortTest {
    Character[] a;
    Integer[] i;
    Double[] d;
    Sort sorter;

    @Before
    public void setUp() {
        a = new Character[]{'h', 'e', 'l', 'l', 'o', ',', 'w', 'o', 'r', 'd'};
        i = new Integer[]{2, -1, 20, 0, 99, -1000};
        d = new Double[]{2.9274, -1.11, 20.0001, 0.000000001, 99.0, -1000.1};
    }

    @org.junit.Test
    public void testInsertionSort() {
        sorter = new InsertionSort();

        assertTrue(Sort.isSorted(sorter.on(a)));
        assertTrue(Sort.isSorted(sorter.on(i)));
        assertTrue(Sort.isSorted(sorter.on(d)));
    }

    @org.junit.Test
    public void testSelectionSort() {
        sorter = new SelectionSort();

        assertTrue(Sort.isSorted(sorter.on(a)));
        assertTrue(Sort.isSorted(sorter.on(i)));
        assertTrue(Sort.isSorted(sorter.on(d)));
    }
}