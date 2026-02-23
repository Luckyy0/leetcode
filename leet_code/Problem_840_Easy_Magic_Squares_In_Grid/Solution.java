package leet_code.Problem_840_Easy_Magic_Squares_In_Grid;

public class Solution {

    /**
     * Counts the number of 3x3 magic square subgrids.
     * Strategy: Iterate through all possible 3x3 windows and verify their magic
     * properties.
     * Time: O(R * C), Space: O(1).
     */
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows < 3 || cols < 3)
            return 0;

        int magicCount = 0;
        // Check every possible start (top-left) of a 3x3 square
        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                if (isMagic(grid, r, c)) {
                    magicCount++;
                }
            }
        }

        return magicCount;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        // Essential property: middle element of any 3x3 magic square of digits 1-9 is 5
        if (grid[r + 1][c + 1] != 5)
            return false;

        // Check if it contains digits 1-9 exactly once
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[r + i][c + j];
                if (val < 1 || val > 9 || seen[val])
                    return false;
                seen[val] = true;
            }
        }

        // Sum of digits 1-9 is 45. Each of the 3 rows/cols must sum to 15.
        // Check rows
        if (grid[r][c] + grid[r][c + 1] + grid[r][c + 2] != 15)
            return false;
        if (grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2] != 15)
            return false;
        if (grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] != 15)
            return false;

        // Check columns
        if (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] != 15)
            return false;
        if (grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] != 15)
            return false;
        if (grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] != 15)
            return false;

        // Check diagonals
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != 15)
            return false;
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != 15)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } };
        System.out.println("Result 1: " + sol.numMagicSquaresInside(g1)); // 1
    }
}
