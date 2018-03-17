// Aria Pahlavan on March 16 2018

import java.util.Random;
import java.util.SortedMap;

public class KnuthShuffle {
    public static <T> T[] shuffle(Comparable<T>[] a) {
        Comparable<T>[] shuffled = a;
        Random randGen = new Random();

        for (int i = 0; i < shuffled.length; i++)
            swap(shuffled, i, randGen.nextInt(i + 1));

        return (T[]) shuffled;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
