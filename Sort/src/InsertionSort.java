// Aria Pahlavan on March 16 2018

public class InsertionSort implements Sort{
    @Override
    public <T> T[] on(Comparable<T>[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j-1])) swap(a, j, j-1);
                else                    break;

        return (T[]) a;
    }
}
