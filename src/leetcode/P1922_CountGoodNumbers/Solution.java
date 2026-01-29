package leetcode.P1922_CountGoodNumbers;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evens = power(5, evenPos);
        long odds = power(4, oddPos);

        return (int) ((evens * odds) % MOD);
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
