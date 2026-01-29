package leetcode.P562_LongestLineOfConsecutiveOneInMatrix;

class Solution {
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;

        int m = mat.length;
        int n = mat[0].length;
        // dp[j][k] stores length for column j, direction k
        // 0: hori, 1: vert, 2: diag, 3: anti-diag
        // Optimized to 2 rows to save space? Or just 1 row with temps?
        // Let's use full 3D array for clarity first, space constraint usually allows
        // O(MN).
        // Constraints not specified but typically M,N <= 500 would mean 1M ints, 4MB.
        // Fine.

        int[][][] dp = new int[m][n][4];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    // Horizontal: depends on (i, j-1)
                    dp[i][j][0] = (j > 0 ? dp[i][j - 1][0] : 0) + 1;

                    // Vertical: depends on (i-1, j)
                    dp[i][j][1] = (i > 0 ? dp[i - 1][j][1] : 0) + 1;

                    // Diagonal: depends on (i-1, j-1)
                    dp[i][j][2] = (i > 0 && j > 0 ? dp[i - 1][j - 1][2] : 0) + 1;

                    // Anti-diagonal: depends on (i-1, j+1)
                    dp[i][j][3] = (i > 0 && j < n - 1 ? dp[i - 1][j + 1][3] : 0) + 1;

                    maxLen = Math.max(maxLen,
                            Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
                }
            }
        }

        return maxLen;
    }
}
