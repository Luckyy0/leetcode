package leetcode.P1563_StoneGameV;

public class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        int[] prefixSum = new int[n + 1];

        // Precompute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        // Iterate over length of subarray
        for (int len = 2; len <= n; len++) {
            // Iterate over start index i
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // Try all split points k
                // Left: [i, k], Right: [k+1, j]
                for (int k = i; k < j; k++) {
                    int leftSum = prefixSum[k + 1] - prefixSum[i];
                    int rightSum = prefixSum[j + 1] - prefixSum[k + 1];

                    int score = 0;
                    if (leftSum < rightSum) {
                        score = leftSum + dp[i][k];
                    } else if (leftSum > rightSum) {
                        score = rightSum + dp[k + 1][j];
                    } else {
                        score = leftSum + Math.max(dp[i][k], dp[k + 1][j]);
                    }

                    dp[i][j] = Math.max(dp[i][j], score);
                }
            }
        }

        return dp[0][n - 1];
    }
}
