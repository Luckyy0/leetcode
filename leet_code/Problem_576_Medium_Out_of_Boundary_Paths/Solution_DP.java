package leet_code.Problem_576_Medium_Out_of_Boundary_Paths;

public class Solution_DP {

    /**
     * Finds the number of paths to move the ball out of boundary.
     * Strategy: Iterative DP with space compression.
     * Time: O(maxMove * m * n), Space: O(m * n).
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0)
            return 0;

        final int MOD = 1000000007;

        // dp[i][j] = number of ways to reach cell (i, j)
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;

        int totalPaths = 0;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int k = 1; k <= maxMove; k++) {
            int[][] nextDp = new int[m][n];

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                                // Out of boundary found
                                totalPaths = (totalPaths + dp[r][c]) % MOD;
                            } else {
                                // Still inside boundary
                                nextDp[nr][nc] = (nextDp[nr][nc] + dp[r][c]) % MOD;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        return totalPaths;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        System.out.println("Paths (2x2, 2 moves): " + solution.findPaths(2, 2, 2, 0, 0)); // 6
        System.out.println("Paths (1x3, 3 moves): " + solution.findPaths(1, 3, 3, 0, 1)); // 12
    }
}
