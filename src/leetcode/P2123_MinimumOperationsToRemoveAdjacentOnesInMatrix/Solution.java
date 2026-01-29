package leetcode.P2123_MinimumOperationsToRemoveAdjacentOnesInMatrix;

import java.util.Arrays;

public class Solution {
    int m, n;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int[][] match;
    boolean[][] vis;

    public int minimumOperations(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        match = new int[m][n];
        for (int[] row : match)
            Arrays.fill(row, -1);

        int result = 0;

        // Iterate only 'Black' cells (r+c)%2 == 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (i + j) % 2 == 0) {
                    vis = new boolean[m][n];
                    if (dfs(i, j, grid)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private boolean dfs(int r, int c, int[][] grid) {
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]) {
                vis[nr][nc] = true;
                int val = match[nr][nc];
                // If unmatched or can find augmenting path
                if (val == -1 || dfs(val / n, val % n, grid)) {
                    match[nr][nc] = r * n + c;
                    return true;
                }
            }
        }
        return false;
    }
}
