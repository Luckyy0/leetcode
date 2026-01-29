package leetcode.P1219_PathWithMaximumGold;

class Solution {
    int maxGold = 0;

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return maxGold;
    }

    private void dfs(int[][] grid, int r, int c, int currentGold) {
        int val = grid[r][c];
        currentGold += val;
        maxGold = Math.max(maxGold, currentGold);

        grid[r][c] = 0; // Mark visited

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] != 0) {
                dfs(grid, nr, nc, currentGold);
            }
        }

        grid[r][c] = val; // Backtrack
    }
}
