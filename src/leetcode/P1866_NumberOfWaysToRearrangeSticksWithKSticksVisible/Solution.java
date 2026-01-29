package leetcode.P1866_NumberOfWaysToRearrangeSticksWithKSticksVisible;

public class Solution {
    public int rearrangeSticks(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        int MOD = 1_000_000_007;

        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            // Optimization: we only care about j up to k. And visible j <= i.
            // j starts from 1.
            for (int j = 1; j <= k; j++) {
                // dp[i-1][j-1] + (i-1) * dp[i-1][j]
                long term1 = dp[i - 1][j - 1];
                long term2 = ((i - 1) * dp[i - 1][j]) % MOD;
                dp[i][j] = (term1 + term2) % MOD;
            }
        }

        return (int) dp[n][k];
    }
}
