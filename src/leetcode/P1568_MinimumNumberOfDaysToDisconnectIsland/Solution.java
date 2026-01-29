package leetcode.P1568_MinimumNumberOfDaysToDisconnectIsland;

public class Solution {
    private int m, n;
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int minDays(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        // Check if already disconnected
        if (countIslands(grid) != 1)
            return 0;

        // Check if removing 1 land works
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1)
                        return 1;
                    grid[i][j] = 1; // Backtrack
                }
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(grid, visited, nr, nc);
            }
        }
    }
}
