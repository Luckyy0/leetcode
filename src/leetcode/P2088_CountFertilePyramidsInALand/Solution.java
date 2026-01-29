package leetcode.P2088_CountFertilePyramidsInALand;

public class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int total = 0;

        // Count normal pyramids (Apex Up, Base Down)
        // DP depends on i+1 (row below). So iterate i from m-2 down to 0.
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == m - 1 || j == 0 || j == n - 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    }
                    total += dp[i][j] - 1;
                }
            }
        }

        // Count inverse pyramids (Apex Down, Base Up)
        // DP depends on i-1 (row above). Iterate i from 1 to m-1.
        int[][] dp2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0 || j == n - 1) {
                        dp2[i][j] = 1;
                    } else {
                        dp2[i][j] = 1 + Math.min(dp2[i - 1][j - 1], Math.min(dp2[i - 1][j], dp2[i - 1][j + 1]));
                    }
                    total += dp2[i][j] - 1;
                }
            }
        }

        return total;
    }
}
