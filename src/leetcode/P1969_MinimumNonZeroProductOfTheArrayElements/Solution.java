package leetcode.P1969_MinimumNonZeroProductOfTheArrayElements;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        if (p == 1)
            return 1;

        long max = (1L << p) - 1; // 2^p - 1
        long val = (max - 1) % MOD; // 2^p - 2
        long count = (1L << (p - 1)) - 1; // (2^p - 2) / 2

        long pow = power(val, count);
        long ans = (pow * (max % MOD)) % MOD;

        return (int) ans;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp % 2) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
