// Aria Pahlavan on March 16 2018

public class SelectionSort implements Sort {
    @Override
    public <T> T[] on(Comparable<T>[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;

            swap(a, i, min);
        }

        return (T[]) a;
    }
}
