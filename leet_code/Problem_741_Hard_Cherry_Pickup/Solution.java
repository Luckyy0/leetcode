package leet_code.Problem_741_Hard_Cherry_Pickup;

import java.util.Arrays;

public class Solution {

    /**
     * Calculates maximum cherries collected in a round trip.
     * Strategy: 3D Dynamic Programming (Simulating two people picking
     * simultaneously).
     * Time: O(N^3), Space: O(N^2) (using row caching) or O(N^3). Using N^3 here for
     * N=50 is fine.
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // memo[r1][c1][c2]
        // r2 is derived: r1 + c1 = r2 + c2 => r2 = r1 + c1 - c2
        Integer[][][] memo = new Integer[n][n][n];

        int result = dp(grid, n, 0, 0, 0, memo);
        return Math.max(0, result);
    }

    private int dp(int[][] grid, int n, int r1, int c1, int c2, Integer[][][] memo) {
        int r2 = r1 + c1 - c2;

        // Boundary checks and thorn/obstacle checks
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        // If one person reached the end (both reach at the same step count)
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (memo[r1][c1][c2] != null) {
            return memo[r1][c1][c2];
        }

        // Current cell cherry count
        int cherries = grid[r1][c1];
        // If they are not at the same cell, add cherry from P2's cell
        if (c1 != c2) {
            cherries += grid[r2][c2];
        }

        // Try all 4 simultaneous moves
        // 1. Both down: r1+1, r2+1 -> c1, c2 unchanged
        // 2. P1 down, P2 right: r1+1, c2+1
        // 3. P1 right, P2 down: c1+1, r2+1 -> c1+1, c2 unchanged
        // 4. Both right: c1+1, c2+1

        int res1 = dp(grid, n, r1 + 1, c1, c2, memo); // Down, Down
        int res2 = dp(grid, n, r1 + 1, c1, c2 + 1, memo); // Down, Right (P2 moves right => increasing c2)
        int res3 = dp(grid, n, r1, c1 + 1, c2, memo); // Right, Down (P2 moves down => c2 stays same)
        int res4 = dp(grid, n, r1, c1 + 1, c2 + 1, memo); // Right, Right

        int maxNext = Math.max(Math.max(res1, res2), Math.max(res3, res4));

        if (maxNext == Integer.MIN_VALUE) {
            memo[r1][c1][c2] = Integer.MIN_VALUE; // No valid path from here
        } else {
            memo[r1][c1][c2] = cherries + maxNext;
        }

        return memo[r1][c1][c2];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
        System.out.println("Result 1: " + sol.cherryPickup(grid1)); // 5

        int[][] grid2 = { { 1, 1, -1 }, { 1, -1, 1 }, { -1, 1, 1 } };
        System.out.println("Result 2: " + sol.cherryPickup(grid2)); // 0
    }
}
