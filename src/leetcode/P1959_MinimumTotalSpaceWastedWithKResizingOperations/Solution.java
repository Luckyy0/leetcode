package leetcode.P1959_MinimumTotalSpaceWastedWithKResizingOperations;

import java.util.Arrays;

public class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        int[][] waste = new int[n][n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            int sum = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                waste[i][j] = max * (j - i + 1) - sum;
            }
        }

        // dp[i][j] = min waste for prefix length i (nums[0...i-1]) using j segments
        // (j-1 resizes)
        // Adjust indices: k resizes = k+1 segments.
        int segments = k + 1;
        int[][] dp = new int[n + 1][segments + 1];

        for (int[] row : dp)
            Arrays.fill(row, 2000000000); // 200 * 10^6 max
        dp[0][0] = 0;

        for (int j = 1; j <= segments; j++) {
            for (int i = 1; i <= n; i++) {
                for (int p = 0; p < i; p++) {
                    if (dp[p][j - 1] != 2000000000) {
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + waste[p][i - 1]);
                    }
                }
            }
        }

        return dp[n][segments];
    }
}
