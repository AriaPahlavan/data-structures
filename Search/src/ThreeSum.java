// Aria Pahlavan on March 16 2018

public class ThreeSum {

    /**
     * @param a the array to analyze
     * @return count of 3-element tuples whose sum equals zero
     */
    public static int is3SumExist(Integer[] a) {
        //todo: sort the array //O(nlogn)
        Integer[] sorted = new SelectionSort().on(a);

        int counter = 0;

        for (int i = 0; i < sorted.length; i++)
            for (int j = i+1; j < sorted.length; j++) {
                int k = BinarySearch.on(sorted, -(sorted[i]+sorted[j]));

                if (k != -1) { System.out.println('('+i+", "+j+", "+k+')'); counter++; }
            }

        return counter;
    }
}