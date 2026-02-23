package leet_code.Problem_694_Medium_Number_of_Distinct_Islands;

import java.util.*;

public class Solution {

    /**
     * Counts the number of distinct islands by shape.
     * Strategy: DFS with path-encoding (recording directions and backtracking).
     * Time: O(M * N), Space: O(M * N).
     */
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;

        Set<String> distinctIslands = new HashSet<>();
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    StringBuilder path = new StringBuilder();
                    // Start DFS from a new island segment
                    // Use 'o' as origin
                    dfs(grid, r, c, visited, path, 'o');
                    distinctIslands.add(path.toString());
                }
            }
        }

        return distinctIslands.size();
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited, StringBuilder path, char dir) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
            return;
        }

        visited[r][c] = true;
        path.append(dir);

        // Directions: Right, Left, Down, Up
        dfs(grid, r, c + 1, visited, path, 'r');
        dfs(grid, r, c - 1, visited, path, 'l');
        dfs(grid, r + 1, c, visited, path, 'd');
        dfs(grid, r - 1, c, visited, path, 'u');

        // Append 'b' for backtracking to distinguish topological structures
        path.append('b');
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };
        System.out.println("Result 1: " + sol.numDistinctIslands(grid1)); // 1

        int[][] grid2 = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 }
        };
        System.out.println("Result 2: " + sol.numDistinctIslands(grid2)); // 3
    }
}
