package leetcode.P279_PerfectSquares;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 279: Perfect Squares
     * Approach: Dynamic Programming
     * 
     * Theoretical Basis:
     * - dp[i] = min(dp[i - j*j] + 1)
     * 
     * Time Complexity: O(N * sqrt(N))
     * Space Complexity: O(N)
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 12 -> 3 (4+4+4)
        runTest(solution, 12, 3);

        // 13 -> 2 (4+9)
        runTest(solution, 13, 2);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.numSquares(n);
        System.out.println("n=" + n + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
