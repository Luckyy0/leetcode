package leetcode.P375_GuessNumberHigherOrLowerII;

public class Solution {

    /**
     * Problem 375: Guess Number Higher or Lower II
     * Approach: Interval DP
     * 
     * Time Complexity: O(N^3)
     * Space Complexity: O(N^2)
     */
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2]; // Padding to avoid bounds check for k-1 and k+1

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try pivit k
                for (int k = i; k <= j; k++) {
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 10 -> 16
        runTest(solution, 10, 16);

        // 1 -> 0
        runTest(solution, 1, 0);

        // 2 -> 1 (Guess 1 ($1). If wrong (2), done. Cost 1. OR Guess 2 ($2). Cost 2.
        // Optimal 1.)
        // Wait. Range [1, 2]. Guess 1.
        // If correct (1), cost 0.
        // If wrong (higher -> 2), cost 1. Game ends (only 2 left). Max cost 1.
        runTest(solution, 2, 1);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.getMoneyAmount(n);
        System.out.println("n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
