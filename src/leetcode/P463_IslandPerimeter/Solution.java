package leetcode.P463_IslandPerimeter;

public class Solution {

    /**
     * Problem 463: Island Perimeter
     * Approach: Shared Edge Counting
     * 
     * Time Complexity: O(R * C)
     * Space Complexity: O(1)
     */
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbors = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islands++;

                    // Check down
                    if (i < rows - 1 && grid[i + 1][j] == 1)
                        neighbors++;
                    // Check right
                    if (j < cols - 1 && grid[i][j + 1] == 1)
                        neighbors++;
                }
            }
        }

        return islands * 4 - neighbors * 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]] -> 16
        int[][] g1 = {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        };
        runTest(sol, g1, 16);

        // [[1]] -> 4
        int[][] g2 = { { 1 } };
        runTest(sol, g2, 4);

        // [[1,0]] -> 4
        int[][] g3 = { { 1, 0 } };
        runTest(sol, g3, 4);
    }

    private static void runTest(Solution sol, int[][] grid, int expected) {
        int result = sol.islandPerimeter(grid);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
