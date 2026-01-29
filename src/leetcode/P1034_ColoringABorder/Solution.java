package leetcode.P1034_ColoringABorder;

class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int originalColor = grid[row][col];
        if (originalColor == color)
            return grid; // No change needed

        boolean[][] visited = new boolean[m][n];
        boolean[][] isBorder = new boolean[m][n];

        dfs(grid, row, col, originalColor, visited, isBorder);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBorder[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int r, int c, int originalColor, boolean[][] visited, boolean[][] isBorder) {
        visited[r][c] = true;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != originalColor) {
                isBorder[r][c] = true;
            } else if (!visited[nr][nc]) {
                dfs(grid, nr, nc, originalColor, visited, isBorder);
            }
        }
    }
}
