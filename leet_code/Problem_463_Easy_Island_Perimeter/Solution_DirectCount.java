package leet_code.Problem_463_Easy_Island_Perimeter;

public class Solution_DirectCount {

    /**
     * Calculates the perimeter of an island in a grid.
     * Strategy: Count land cells (+4) and subtract shared boundaries (-2).
     * Time: O(R*C), Space: O(1).
     */
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // Check top neighbor
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }

                    // Check left neighbor
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        Solution_DirectCount solution = new Solution_DirectCount();
        int[][] grid = {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        };
        System.out.println("Result: " + solution.islandPerimeter(grid)); // 16
    }
}
