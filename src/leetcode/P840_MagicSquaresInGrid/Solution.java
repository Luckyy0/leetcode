package leetcode.P840_MagicSquaresInGrid;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int r = 0; r <= grid.length - 3; r++) {
            for (int c = 0; c <= grid[0].length - 3; c++) {
                if (isMagic(grid, r, c))
                    count++;
            }
        }
        return count;
    }

    private boolean isMagic(int[][] g, int r, int c) {
        if (g[r + 1][c + 1] != 5)
            return false;

        // Distinct numbers 1-9
        int[] counts = new int[16];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = g[r + i][c + j];
                if (val < 1 || val > 9 || counts[val] > 0)
                    return false;
                counts[val]++;
            }
        }

        // Rows, Columns, Diagonals
        if (g[r][c] + g[r][c + 1] + g[r][c + 2] != 15)
            return false;
        if (g[r + 1][c] + g[r + 1][c + 1] + g[r + 1][c + 2] != 15)
            return false;
        if (g[r + 2][c] + g[r + 2][c + 1] + g[r + 2][c + 2] != 15)
            return false;
        if (g[r][c] + g[r + 1][c] + g[r + 2][c] != 15)
            return false;
        if (g[r][c + 1] + g[r + 1][c + 1] + g[r + 2][c + 1] != 15)
            return false;
        if (g[r][c + 2] + g[r + 1][c + 2] + g[r + 2][c + 2] != 15)
            return false;
        if (g[r][c] + g[r + 1][c + 1] + g[r + 2][c + 2] != 15)
            return false;
        if (g[r][c + 2] + g[r + 1][c + 1] + g[r + 2][c] != 15)
            return false;

        return true;
    }
}
