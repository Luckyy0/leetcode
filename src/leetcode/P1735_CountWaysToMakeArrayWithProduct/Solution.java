package leetcode.P1735_CountWaysToMakeArrayWithProduct;

public class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 20000; // n + log(k)
    private long[] fact;
    private long[] invFact;

    public int[] waysToFillArray(int[][] queries) {
        initComb();
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int k = queries[i][1];
            res[i] = (int) solve(n, k);
        }

        return res;
    }

    private void initComb() {
        if (fact != null)
            return;
        fact = new long[MAX + 1];
        invFact = new long[MAX + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX] = power(fact[MAX], MOD - 2);
        for (int i = MAX - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    private long power(long base, int exp) {
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

    private long solve(int n, int k) {
        long ways = 1;
        for (int p = 2; p * p <= k; p++) {
            if (k % p == 0) {
                int count = 0;
                while (k % p == 0) {
                    count++;
                    k /= p;
                }
                // Distribute 'count' items into 'n' bins
                // C(n + count - 1, count)
                ways = (ways * nCr(n + count - 1, count)) % MOD;
            }
        }
        if (k > 1) {
            // One remaining prime factor
            ways = (ways * nCr(n + 1 - 1, 1)) % MOD;
        }
        return ways;
    }
}
