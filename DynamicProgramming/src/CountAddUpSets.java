import java.util.HashMap;
import java.util.Map;

public class CountAddUpSets {
    public static long of(long[] possibilities, long total) {
        return rec(possibilities, total, possibilities.length-1, new HashMap<>());
    }

    private static long rec(long[] possibilities, long total, int i, Map<String, Long> memo) {
        String key = total + "-" + i;
        if (memo.containsKey(key)) return memo.get(key);

        if (total == 0) return 1;
        if (total < 0)  return 0;
        if (i < 0)      return 0;

        long result = rec(possibilities, total, i-1, memo)
                      + rec(possibilities, total - possibilities[i], i-1, memo);

        memo.put(key, result);
        return result;
     }

     private static long dp(long[] possibilities, long total) {
        Map<String, Long> memo = new HashMap<>();

        if (total == 0) return 1;
        if (total < 0)  return 0;

        //TODO: finish implementation of iterative algorithm
        return 0;
     }

    public static void main(String[] args) {
        if (of(new long[]{1, 2, 4, 6, 10, 5, 16}, 16) != 5)
            System.err.println("FAIL");
        else
            System.out.println("PASS");
    }
}
