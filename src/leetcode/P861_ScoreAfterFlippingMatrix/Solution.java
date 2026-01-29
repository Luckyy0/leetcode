package leetcode.P861_ScoreAfterFlippingMatrix;

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Step 1: Flip rows to make first column all 1s
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++)
                    grid[i][j] ^= 1;
            }
        }

        // Step 2: Flip columns to maximize 1s
        int res = (1 << (n - 1)) * m;
        for (int j = 1; j < n; j++) {
            int count1 = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1)
                    count1++;
            }
            int actual1s = Math.max(count1, m - count1);
            res += (1 << (n - 1 - j)) * actual1s;
        }

        return res;
    }
}
