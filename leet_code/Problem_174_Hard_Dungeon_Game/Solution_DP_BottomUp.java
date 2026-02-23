package leet_code.Problem_174_Hard_Dungeon_Game;

import java.util.Arrays;

public class Solution_DP_BottomUp {

    /**
     * Calculates the minimum initial health needed for the knight.
     * Uses Bottom-Up DP starting from the destination (m-1, n-1).
     * Time: O(M*N), Space: O(M*N).
     * 
     * Tính toán sức khỏe ban đầu tối thiểu cần thiết cho hiệp sĩ.
     * Sử dụng DP từ dưới lên bắt đầu từ đích (m-1, n-1).
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i][j] represents the minimum health needed before entering room (i, j)
        // dp[i][j] đại diện cho sức khỏe tối thiểu cần thiết trước khi vào phòng (i, j)
        int[][] dp = new int[m][n];

        // Fill the DP table backwards
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    // Base Case: Princess's room
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else {
                    // Choose the minimum health required from right or bottom neighbor
                    int nextHealth = Integer.MAX_VALUE;

                    if (i + 1 < m) {
                        nextHealth = Math.min(nextHealth, dp[i + 1][j]);
                    }
                    if (j + 1 < n) {
                        nextHealth = Math.min(nextHealth, dp[i][j + 1]);
                    }

                    // Health required at entry of current room
                    dp[i][j] = Math.max(1, nextHealth - dungeon[i][j]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution_DP_BottomUp solution = new Solution_DP_BottomUp();

        // Test Case 1: Example from problem
        int[][] dungeon1 = {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 }
        };
        System.out.println("Min initial health 1: " + solution.calculateMinimumHP(dungeon1));

        // Test Case 2: [[0]]
        int[][] dungeon2 = { { 0 } };
        System.out.println("Min initial health 2: " + solution.calculateMinimumHP(dungeon2));
    }
}
