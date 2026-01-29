package leetcode.P1905_CountSubIslands;

public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        int m = grid2.length;
        int n = grid2[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid2[r][c] == 0) {
            return true;
        }

        grid2[r][c] = 0; // Mark visited

        boolean isSub = (grid1[r][c] == 1);

        // Traverse all 4 directions even if false, to mark entire island
        boolean down = dfs(grid1, grid2, r + 1, c);
        boolean up = dfs(grid1, grid2, r - 1, c);
        boolean right = dfs(grid1, grid2, r, c + 1);
        boolean left = dfs(grid1, grid2, r, c - 1);

        return isSub && down && up && right && left;
    }
}
