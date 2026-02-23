package leet_code.Problem_562_Medium_Longest_Line_of_Consecutive_One_in_Matrix;

public class Solution_DP {

    /**
     * Finds the longest line of consecutive ones in four directions.
     * Strategy: DP with 4 directions tracked at each cell.
     * Time: O(M*N), Space: O(M*N).
     */
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;

        int m = mat.length;
        int n = mat[0].length;
        int maxLine = 0;

        // dp[i][j][0...3]: horizontal, vertical, diagonal, anti-diagonal
        int[][][] dp = new int[m][n][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    continue;

                // Initialize current as 1
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = 1;

                // 1. Horizontal (j-1)
                if (j > 0)
                    dp[i][j][0] += dp[i][j - 1][0];

                // 2. Vertical (i-1)
                if (i > 0)
                    dp[i][j][1] += dp[i - 1][j][1];

                // 3. Diagonal (i-1, j-1)
                if (i > 0 && j > 0)
                    dp[i][j][2] += dp[i - 1][j - 1][2];

                // 4. Anti-diagonal (i-1, j+1)
                if (i > 0 && j < n - 1)
                    dp[i][j][3] += dp[i - 1][j + 1][3];

                // Update max
                for (int k = 0; k < 4; k++)
                    maxLine = Math.max(maxLine, dp[i][j][k]);
            }
        }

        return maxLine;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        int[][] mat = {
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 1 }
        };
        System.out.println("Max Line: " + solution.longestLine(mat)); // 3
    }
}
