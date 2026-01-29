package leetcode.P1994_TheNumberOfGoodSubsets;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfGoodSubsets(int[] nums) {
        int[] counts = new int[31];
        for (int x : nums)
            counts[x]++;

        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        long[] dp = new long[1024];
        dp[0] = 1;

        for (int x = 2; x <= 30; x++) {
            if (counts[x] == 0)
                continue;

            // Check square free and get mask
            int mask = 0;
            boolean ok = true;
            int temp = x;

            for (int i = 0; i < 10; i++) {
                int p = primes[i];
                if (temp % p == 0) {
                    if (temp % (p * p) == 0) {
                        ok = false;
                        break;
                    }
                    mask |= (1 << i);
                    temp /= p;
                }
            }
            if (!ok)
                continue; // Not square free

            // Update DP
            // Iterate backwards to avoid using same x multiple times for one subset
            for (int m = 1023; m >= 0; m--) {
                if ((m & mask) == 0) {
                    int nextM = m | mask;
                    long additions = (dp[m] * counts[x]) % MOD;
                    dp[nextM] = (dp[nextM] + additions) % MOD;
                }
            }
        }

        long sum = 0;
        for (long val : dp)
            sum = (sum + val) % MOD;

        // Handle ones. 2^ones
        long onesMultiplier = power(2, counts[1]);

        long ans = (sum * onesMultiplier) % MOD;
        ans = (ans - 1 + MOD) % MOD; // Remove empty set

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
