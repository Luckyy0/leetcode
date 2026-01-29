package leetcode.P1155_NumberOfDiceRollsWithTargetSum;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                // dp[i][s] = sum(dp[i-1][s-f]) for f in 1..k
                for (int f = 1; f <= k; f++) {
                    if (s - f >= 0) {
                        dp[i][s] = (dp[i][s] + dp[i - 1][s - f]) % MOD;
                    } else {
                        break; // s-f < 0, larger f also < 0
                    }
                }
            }
        }

        return dp[n][target];
    }
}
