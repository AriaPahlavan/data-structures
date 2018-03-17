// Aria Pahlavan on March 16 2018

public class BinarySearch {
    /**
     * Perform binary search to find the index corresponding to key
     *
     * @param a array of elements
     * @param key key to find in the array
     * @return the index of {@code key} in the array of elements
     * @apiNote {@code a} must be sorted
     */
    public static <T> int on(Comparable<T>[] a, T key) {
        int lo = 0, hi = a.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (a[mid].equals(key))         return mid;
            if (a[mid].compareTo(key) > 0)  hi = mid - 1;
            else                            lo = mid + 1;
        }

        //NOT REACHED
        return -1;
    }

    /**
     * Perform binary search recursively to find the index corresponding to key
     *
     * @param a array of elements
     * @param key key to find in the array
     * @return the index of {@code key} in the array of elements
     * @apiNote {@code a} must be sorted
     */
    public static <T> int recursivelyOn(Comparable<T>[] a, T key)  {
        return recSearch(a, key, 0, a.length - 1);
    }

    private static <T> int recSearch(Comparable<T>[] a, T key, int lo, int hi) {
        if (lo > hi) return -1;


        int mid = (hi + lo) / 2;

        if (a[mid].equals(key))         return mid;
        if (a[mid].compareTo(key) > 0)  return recSearch(a, key, lo, mid - 1);
        else                            return recSearch(a, key, mid + 1, hi);
    }
}
