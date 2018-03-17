public class Sort {
    public static boolean less(Comparable p, Comparable q) {
        return p.compareTo(q) < 0;
    }

    public static <T> boolean less(Comparable p, T q) {
        return p.compareTo(q) < 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (!less(a[i-1], a[i])) return false;

        return true;
    }
}
