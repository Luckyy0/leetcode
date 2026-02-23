package leet_code.Problem_750_Medium_Number_Of_Corner_Rectangles;

public class Solution {

    /**
     * Counts the number of corner rectangles.
     * Strategy: Iterate through all pairs of rows and count common '1' columns.
     * Time: O(M^2 * N), Space: O(1).
     */
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int sharedOnes = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        sharedOnes++;
                    }
                }

                // If sharedOnes is k, number of rectangles is k * (k - 1) / 2
                count += sharedOnes * (sharedOnes - 1) / 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {
                { 1, 0, 0, 1 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 1, 0, 0, 1 }
        };
        System.out.println("Result 1: " + sol.countCornerRectangles(grid1)); // 1

        int[][] grid2 = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        System.out.println("Result 2: " + sol.countCornerRectangles(grid2)); // 9
    }
}
