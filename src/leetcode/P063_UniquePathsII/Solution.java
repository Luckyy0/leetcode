package leetcode.P063_UniquePathsII;

public class Solution {

    /**
     * Problem 63: Unique Paths II
     * Approach: Dynamic Programming (1D Array)
     * Time Complexity: O(m * n)
     * Space Complexity: O(n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start cell has obstacle, no solution
        if (obstacleGrid[0][0] == 1)
            return 0;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0; // Obstacle, no path through here
                } else {
                    if (j > 0) {
                        dp[j] += dp[j - 1]; // Current (from top) + Left
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] g1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        runTest(solution, g1, 2);

        int[][] g2 = { { 0, 1 }, { 0, 0 } };
        runTest(solution, g2, 1);

        int[][] g3 = { { 1 } };
        runTest(solution, g3, 0);
    }

    private static void runTest(Solution s, int[][] grid, int expected) {
        System.out.println("Input grid size: " + grid.length + "x" + grid[0].length);
        int result = s.uniquePathsWithObstacles(grid);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
