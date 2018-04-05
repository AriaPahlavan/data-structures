import java.util.HashMap;
import java.util.Map;

public class Fib {
    private static Map<Long, Long> memo = new HashMap<>();

    public static long of(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return memo.compute(n,
                            (k, v) -> v == null
                                    ? of(n - 1) + of(n - 2)
                                    : v);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
            System.out.println(of(i));
    }
}
