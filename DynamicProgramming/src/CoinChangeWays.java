import java.util.HashMap;
import java.util.Map;

public class CoinChangeWays {

    /**
     * Find number of ways to money to coin change
     *
     * @param coins array of coin options
     * @param money total money to change
     * @return number of ways change can be made
     * @apiNote recursive memoized dynamic programming method
     */
    public static long of(long[] coins, long money) {
        return of(coins, money, 0, new HashMap<>());
    }

    public static long of(long[] coins, long money, int index, Map<String, Long> memo) {
        if (money == 0) return 1;
        if (coins.length <= index) return 0;

        String key =  "" + money + '-' + index;

        if (memo.containsKey(key)) return memo.get(key);

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            long remaining = money - amountWithCoin;
            ways += of(coins, remaining, index+1, memo);
            amountWithCoin += coins[index];
        }

        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(CoinChangeWays.of(new long[]{50, 25, 10}, 50));
    }
}
