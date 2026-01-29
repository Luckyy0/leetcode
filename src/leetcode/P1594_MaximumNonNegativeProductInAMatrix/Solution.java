package leetcode.P1594_MaximumNonNegativeProductInAMatrix;

public class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];

        maxDP[0][0] = grid[0][0];
        minDP[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxDP[i][0] = maxDP[i - 1][0] * grid[i][0];
            minDP[i][0] = minDP[i - 1][0] * grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            maxDP[0][j] = maxDP[0][j - 1] * grid[0][j];
            minDP[0][j] = minDP[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int val = grid[i][j];
                long maxTop = maxDP[i - 1][j];
                long minTop = minDP[i - 1][j];
                long maxLeft = maxDP[i][j - 1];
                long minLeft = minDP[i][j - 1];

                if (val > 0) {
                    maxDP[i][j] = Math.max(maxTop, maxLeft) * val;
                    minDP[i][j] = Math.min(minTop, minLeft) * val;
                } else {
                    maxDP[i][j] = Math.min(minTop, minLeft) * val;
                    minDP[i][j] = Math.max(maxTop, maxLeft) * val;
                }
            }
        }

        long res = maxDP[m - 1][n - 1];
        if (res < 0)
            return -1;
        return (int) (res % 1_000_000_007);
    }
}
