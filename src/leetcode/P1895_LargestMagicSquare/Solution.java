package leetcode.P1895_LargestMagicSquare;

public class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] rowPrefix = new int[m][n + 1];
        int[][] colPrefix = new int[m + 1][n];
        int[][] diagPrefix = new int[m + 1][n + 1]; // Main diagonal
        int[][] antiPrefix = new int[m + 1][n + 1]; // Anti diagonal

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];

                diagPrefix[i + 1][j + 1] = diagPrefix[i][j] + grid[i][j];
                // Anti: grid[i][j]. prev is grid[i-1][j+1]
                // Careful with indices.
                // Let's store based on i.
                // Anti[i+1][j] stores sum ending at i,j?
                // The logical index for anti-diag is tricky because cols increase.
                // Easier to simplify: just iterate diags in check logic if needed. K is <= 50.
                // 50*50*50 = 125,000. Fast enough to check row/col by prefix, scan diags.
                // Let's optimize row/col. Brute force diagonals.
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (isMagic(grid, rowPrefix, colPrefix, i, j, k)) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isMagic(int[][] grid, int[][] rowP, int[][] colP, int r, int c, int k) {
        int target = rowP[r][c + k] - rowP[r][c];

        // Check Rows
        for (int i = 0; i < k; i++) {
            if (rowP[r + i][c + k] - rowP[r + i][c] != target)
                return false;
        }

        // Check Cols
        for (int j = 0; j < k; j++) {
            if (colP[r + k][c + j] - colP[r][c + j] != target)
                return false;
        }

        // Check Diagonals
        int d1 = 0, d2 = 0;
        for (int idx = 0; idx < k; idx++) {
            d1 += grid[r + idx][c + idx];
            d2 += grid[r + idx][c + k - 1 - idx];
        }

        return d1 == target && d2 == target;
    }
}
