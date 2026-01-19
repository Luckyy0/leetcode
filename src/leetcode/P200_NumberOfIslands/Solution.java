package leetcode.P200_NumberOfIslands;

public class Solution {

    /**
     * Problem 200: Number of Islands
     * Approach: DFS to sink connected components
     * 
     * Theoretical Basis:
     * - Every time we find a '1', it belongs to an island.
     * - We use DFS to visit and mark (sink) all parts of that island.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N) for recursion stack
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: Out of bounds or water
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark as visited (sink the land)
        grid[r][c] = '0';

        // Visit neighbors
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        char[][] g1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println("Test 1: " + solution.numIslands(g1)); // 1

        // Example 2
        char[][] g2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println("Test 2: " + solution.numIslands(g2)); // 3
    }
}
