package leetcode.P576_OutOfBoundaryPaths;

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0)
            return 0;

        final int MOD = 1000000007;

        // dp[i][j] stores number of ways to reach cell (i,j) in current step count
        long[][] dp = new long[m][n];
        dp[startRow][startColumn] = 1;

        long count = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int step = 0; step < maxMove; step++) {
            long[][] nextDp = new long[m][n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            // Check boundary
                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                // Moved out
                                count = (count + dp[r][c]) % MOD;
                            } else {
                                // Moved to neighbor
                                nextDp[nr][nc] = (nextDp[nr][nc] + dp[r][c]) % MOD;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        return (int) count;
    }
}
