package leetcode.P132_PalindromePartitioningII;

public class Solution {

    /**
     * Problem 132: Palindrome Partitioning II
     * Approach: Dynamic Programming
     * 
     * Theoretical Basis:
     * - dp[i] represents the minimum cuts for substring s[0...i].
     * - We precompute a 2D boolean array 'isPal' where isPal[j][i] is true if
     * s[j...i] is a palindrome.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2) for the palindrome table.
     */
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1)
            return 0;

        // 1. Precompute palindromes
        boolean[][] isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        // 2. DP for min cuts
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i; // Max possible cuts
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println("Test 'aab': " + solution.minCut("aab")); // Expected: 1
        System.out.println("Test 'a': " + solution.minCut("a")); // Expected: 0
        System.out.println("Test 'ab': " + solution.minCut("ab")); // Expected: 1
    }
}
