package leetcode.P1808_MaximizeNumberOfNiceDivisors;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3)
            return primeFactors;

        long q = primeFactors / 3;
        long r = primeFactors % 3;

        if (r == 0) {
            return (int) power(3, q);
        } else if (r == 1) {
            return (int) ((power(3, q - 1) * 4) % MOD);
        } else {
            return (int) ((power(3, q) * 2) % MOD);
        }
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
