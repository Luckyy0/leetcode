package leet_code.Problem_807_Medium_Max_Increase_to_Keep_City_Skyline;

public class Solution {

    /**
     * Calculates the maximum total height increase possible while keeping skylines
     * unchanged.
     * Strategy: Precalculate row and column maximums. Each building (i,j) can grow
     * up to min(maxRow[i], maxCol[j]).
     * Time: O(N^2), Space: O(N).
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // Step 1: Find maxima for each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int totalIncrease = 0;

        // Step 2: Calculate allowed increase for each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Building can grow to the smaller of the two maxima it contributes to
                int limit = Math.min(rowMax[i], colMax[j]);
                totalIncrease += (limit - grid[i][j]);
            }
        }

        return totalIncrease;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
        System.out.println("Result 1: " + sol.maxIncreaseKeepingSkyline(g1)); // 35
    }
}
