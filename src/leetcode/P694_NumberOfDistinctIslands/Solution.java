package leetcode.P694_NumberOfDistinctIslands;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> distinct = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, i, j, i, j, shape);
                    distinct.add(shape.toString());
                }
            }
        }
        return distinct.size();
    }

    private void dfs(int[][] grid, int r, int c, int r0, int c0, StringBuilder shape) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return;

        grid[r][c] = 0; // Mark visited
        shape.append((r - r0) + ":" + (c - c0) + ","); // Serialize relative coordinate

        dfs(grid, r + 1, c, r0, c0, shape);
        dfs(grid, r - 1, c, r0, c0, shape);
        dfs(grid, r, c + 1, r0, c0, shape);
        dfs(grid, r, c - 1, r0, c0, shape);
    }
}
