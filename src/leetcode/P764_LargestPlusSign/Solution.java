package leetcode.P764_LargestPlusSign;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> mineSet = new HashSet<>();
        for (int[] m : mines)
            mineSet.add(m[0] * n + m[1]);

        int[][] dp = new int[n][n];
        int res = 0;

        for (int r = 0; r < n; r++) {
            int count = 0;
            // Left to right
            for (int c = 0; c < n; c++) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            // Right to left
            count = 0;
            for (int c = n - 1; c >= 0; c--) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < n; c++) {
            int count = 0;
            // Top to bottom
            for (int r = 0; r < n; r++) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            // Bottom to top
            count = 0;
            for (int r = n - 1; r >= 0; r--) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                res = Math.max(res, dp[r][c]);
            }
        }

        return res;
    }
}
