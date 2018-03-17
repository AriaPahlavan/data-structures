// Aria Pahlavan on March 16 2018

public interface Sort {
    public <T> T[] on(Comparable<T>[] a);


    public default boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }


    public default <T> boolean less(Comparable p, T q) {
        return p.compareTo(q) < 0;
    }


    public default void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;

        return true;
    }
}
