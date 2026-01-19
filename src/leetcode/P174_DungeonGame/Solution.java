package leetcode.P174_DungeonGame;

public class Solution {

    /**
     * Problem 174: Dungeon Game
     * Approach: Bottom-up Dynamic Programming (Working backward)
     * 
     * Theoretical Basis:
     * - We need to know how much health is needed at (i, j) to complete the
     * mission.
     * - dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];

        // Initialize with high value
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: To survive after the princess, you need 1 HP
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minNeeded = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                // Health cannot drop below 1
                dp[i][j] = Math.max(1, minNeeded);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[-2,-3,3],[-5,-10,1],[10,30,-5]] -> 7
        int[][] d1 = {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 }
        };
        runTest(solution, d1, 7);

        // [[0]] -> 1
        int[][] d2 = { { 0 } };
        runTest(solution, d2, 1);

        // [[-20]] -> 21
        int[][] d3 = { { -20 } };
        runTest(solution, d3, 21);
    }

    private static void runTest(Solution s, int[][] dungeon, int expected) {
        int result = s.calculateMinimumHP(dungeon);
        System.out.println("Min Health: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
