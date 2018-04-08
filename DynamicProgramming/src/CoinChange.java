import java.util.*;

public class CoinChange {
    /**
     * Find minimum coin change needed for {@code money}
     *
     * @param coins array of coin options
     * @param money total {@code money} to change
     * @return list of change
     * @apiNote Bottom-up Dynamic programming method
     */
    public static Integer[] of(int[] coins, int money) {
        int[] amountLog = new int[money + 1];
        int[] selectedCoin = new int[money + 1];

        Arrays.fill(amountLog, Integer.MAX_VALUE);
        Arrays.fill(selectedCoin, -1);
        amountLog[0] = 0;


        for (int coin : coins) {
            for (int i = 1; i < amountLog.length; i++) {
                if (i < coin) continue;

                int prevCount = amountLog[i - coin];
                if (prevCount == Integer.MAX_VALUE) continue;
                selectedCoin[i] = amountLog[i] <= 1 + prevCount
                        ? selectedCoin[i]
                        : coin;
                amountLog[i] = Math.min(amountLog[i], 1 + prevCount);
            }
        }

        return computeResult(selectedCoin, money);
    }

    private static Integer[] computeResult(int[] selectedCoin, int money) {
        if (selectedCoin[selectedCoin.length-1] == Integer.MAX_VALUE)
            System.err.println("FAIL");

        List<Integer> change = new ArrayList<>();
        for (int i = money; i > 0; i -= selectedCoin[i]){
            change.add(selectedCoin[i]);
        }

        return change.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        System.out.print("Change needed:");
        Arrays.stream(CoinChange.of(new int[]{7, 2, 3, 6}, 13))
              .map(i -> " " + i)
              .forEach(System.out::print);
    }
}
