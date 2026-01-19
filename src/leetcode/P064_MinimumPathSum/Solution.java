package leetcode.P064_MinimumPathSum;

public class Solution {

    /**
     * Problem 64: Minimum Path Sum
     * Approach: Dynamic Programming (1D Array)
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    // First row: can only come from left
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    // First col: can only come from top
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    // Min of top or left
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] g1 = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        runTest(solution, g1, 7);

        int[][] g2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        runTest(solution, g2, 12);
    }

    private static void runTest(Solution s, int[][] grid, int expected) {
        System.out.println("Input grid size: " + grid.length + "x" + grid[0].length);
        int result = s.minPathSum(grid);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
