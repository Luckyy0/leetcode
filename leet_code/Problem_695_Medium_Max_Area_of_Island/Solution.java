package leet_code.Problem_695_Medium_Max_Area_of_Island;

public class Solution {

    /**
     * Calculates the maximum area of an island in a grid.
     * Strategy: DFS traversal and "sinking" cells to avoid re-visiting.
     * Time: O(M * N), Space: O(M * N).
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int maxArea = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // Trigger DFS for each unvisited island part
                    maxArea = Math.max(maxArea, calculateArea(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int calculateArea(int[][] grid, int r, int c) {
        // Base cases: out of bounds or water
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        // "Sink" the island cell to mark as visited
        grid[r][c] = 0;

        // Sum the current cell + areas in all 4 directions
        int area = 1;
        area += calculateArea(grid, r + 1, c);
        area += calculateArea(grid, r - 1, c);
        area += calculateArea(grid, r, c + 1);
        area += calculateArea(grid, r, c - 1);

        return area;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };
        System.out.println("Max Area 1: " + sol.maxAreaOfIsland(grid1)); // 4

        int[][] grid2 = {
                { 0, 0, 1, 0, 0 },
                { 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 1 },
                { 0, 1, 1, 0, 0 }
        };
        System.out.println("Max Area 2: " + sol.maxAreaOfIsland(grid2)); // 5
    }
}
