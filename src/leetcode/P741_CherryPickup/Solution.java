package leetcode.P741_CherryPickup;

import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2 * n - 1][n][n];

        for (int[][] layer : dp) {
            for (int[] row : layer)
                Arrays.fill(row, -1);
        }

        dp[0][0][0] = grid[0][0];

        for (int t = 1; t < 2 * n - 1; t++) {
            for (int r1 = Math.max(0, t - (n - 1)); r1 <= Math.min(n - 1, t); r1++) {
                for (int r2 = Math.max(0, t - (n - 1)); r2 <= Math.min(n - 1, t); r2++) {
                    int c1 = t - r1;
                    int c2 = t - r2;

                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
                        continue;

                    int cherries = grid[r1][c1];
                    if (r1 != r2)
                        cherries += grid[r2][c2];

                    for (int pr1 = r1 - 1; pr1 <= r1; pr1++) {
                        for (int pr2 = r2 - 1; pr2 <= r2; pr2++) {
                            if (pr1 >= 0 && pr2 >= 0 && dp[t - 1][pr1][pr2] != -1) {
                                dp[t][r1][r2] = Math.max(dp[t][r1][r2], dp[t - 1][pr1][pr2] + cherries);
                            }
                        }
                    }
                }
            }
        }

        return Math.max(0, dp[2 * n - 2][n - 1][n - 1]);
    }
}
