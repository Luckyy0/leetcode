package leetcode.P1463_CherryPickupII;

import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);
        dp[0][n - 1] = grid[0][0] + grid[0][n - 1];

        for (int r = 1; r < m; r++) {
            int[][] nextDp = new int[n][n];
            for (int[] row : nextDp)
                Arrays.fill(row, -1);

            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {
                    int prevMax = -1;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int p1 = c1 + d1;
                            int p2 = c2 + d2;
                            if (p1 >= 0 && p1 < n && p2 >= 0 && p2 < n && dp[p1][p2] != -1) {
                                prevMax = Math.max(prevMax, dp[p1][p2]);
                            }
                        }
                    }

                    if (prevMax != -1) {
                        int currentCherries = grid[r][c1];
                        if (c1 != c2)
                            currentCherries += grid[r][c2];
                        nextDp[c1][c2] = prevMax + currentCherries;
                    }
                }
            }
            dp = nextDp;
        }

        int result = 0;
        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = 0; c2 < n; c2++) {
                result = Math.max(result, dp[c1][c2]);
            }
        }
        return result;
    }
}
