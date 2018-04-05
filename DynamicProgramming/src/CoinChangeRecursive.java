import java.util.HashMap;
import java.util.Map;

public class CoinChangeRecursive {
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
        System.out.println(CoinChangeRecursive.of(new long[]{50, 25, 10}, 50));
    }
}
