package leetcode.P1692_CountWaysToDistributeCandies;

public class Solution {
    public int waysToDistribute(int n, int k) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][k + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Can have at most i bags for i items, and at most k bags total
            int limit = Math.min(i, k);
            for (int j = 1; j <= limit; j++) {
                // S(i, j) = S(i-1, j-1) + j * S(i-1, j)
                dp[i][j] = (dp[i - 1][j - 1] + j * dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[n][k];
    }
}
