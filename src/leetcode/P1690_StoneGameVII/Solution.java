package leetcode.P1690_StoneGameVII;

public class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + stones[i];

        int[][] dp = new int[n][n];

        // len is length of subarray
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                int sumLeft = prefixSum[j + 1] - prefixSum[i + 1]; // removed i (sum range i+1..j)
                int sumRight = prefixSum[j] - prefixSum[i]; // removed j (sum range i..j-1)

                dp[i][j] = Math.max(sumLeft - dp[i + 1][j], sumRight - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }
}
