package leet_code.Problem_764_Medium_Largest_Plus_Sign;

import java.util.Arrays;

public class Solution {

    /**
     * Finds the order of the largest plus sign.
     * Strategy: 4-pass Dynamic Programming.
     * Time: O(N^2), Space: O(N^2).
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // Grid to store the minimum arm length for each cell
        int[][] dp = new int[n][n];

        // Initialize with N (max possible value)
        for (int[] row : dp) {
            Arrays.fill(row, n);
        }

        // Mark mines. For convenience, we can use a separate set or modify dp.
        // Let's modify dp: if it's a mine, it effectively breaks the continuity.
        // However, standard logic is 'count' resets to 0.
        // To avoid lookup cost O(M) inside loop, let's just use a 'mined' grid.
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(grid[i], 1);
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        // Compute min continuous 1s for each direction

        for (int i = 0; i < n; i++) {
            // Left -> Right
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = (grid[i][j] == 0) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }

            // Right -> Left
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                count = (grid[i][j] == 0) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for (int j = 0; j < n; j++) {
            // Up -> Down
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = (grid[i][j] == 0) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }

            // Down -> Up
            count = 0;
            for (int i = n - 1; i >= 0; i--) {
                count = (grid[i][j] == 0) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        // Find max order
        int maxOrder = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxOrder = Math.max(maxOrder, dp[i][j]);
            }
        }

        return maxOrder;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mines1 = { { 4, 2 } };
        System.out.println("Result 1: " + sol.orderOfLargestPlusSign(5, mines1)); // 2

        int[][] mines2 = { { 0, 0 } };
        System.out.println("Result 2: " + sol.orderOfLargestPlusSign(1, mines2)); // 0
    }
}
