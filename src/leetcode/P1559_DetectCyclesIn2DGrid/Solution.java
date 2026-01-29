package leetcode.P1559_DetectCyclesIn2DGrid;

public class Solution {
    private int m, n;
    private char[][] grid;
    private boolean[][] visited;
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int pr, int pc) {
        visited[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            // Check bounds
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                // Check value matches
                if (grid[nr][nc] == grid[r][c]) {
                    // Start of cycle detection logic
                    if (!visited[nr][nc]) {
                        if (dfs(nr, nc, r, c)) {
                            return true;
                        }
                    } else {
                        // If visited and NOT the parent, it's a cycle
                        if (nr != pr || nc != pc) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
