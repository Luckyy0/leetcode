package leetcode.P115_DistinctSubsequences;

public class Solution {

    /**
     * Problem 115: Distinct Subsequences
     * Approach: 2D Dynamic Programming
     * 
     * Theoretical Basis:
     * - dp[i][j] = number of distinct subsequences of s[0..i-1] that equal
     * t[0..j-1]
     * - If s[i-1] == t[j-1]: dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
     * (use current char OR skip it)
     * - If s[i-1] != t[j-1]: dp[i][j] = dp[i-1][j]
     * (must skip current char of s)
     * - Base: dp[i][0] = 1 (empty t can be formed from any s prefix)
     * 
     * Time Complexity: O(m × n)
     * Space Complexity: O(m × n), can be optimized to O(n)
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j] = ways to form t[0..j-1] from s[0..i-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base case: empty t can be formed by any prefix of s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Match: use it + skip it
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // No match: must skip s[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Space-optimized version using 1D array
     */
    public int numDistinctOptimized(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty t can always be formed

        for (int i = 1; i <= m; i++) {
            // Traverse right to left to avoid overwriting needed values
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
                // If no match, dp[j] stays the same
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "rabbbit", "rabbit", 3);
        runTest(solution, "babgbag", "bag", 5);
        runTest(solution, "a", "a", 1);
        runTest(solution, "a", "b", 0);
    }

    private static void runTest(Solution sol, String s, String t, int expected) {
        int result = sol.numDistinct(s, t);
        int resultOpt = sol.numDistinctOptimized(s, t);
        System.out.println("s=\"" + s + "\", t=\"" + t + "\"");
        System.out.println("2D: " + result + ", 1D: " + resultOpt + " (Expected: " + expected + ")");

        if (result == expected && resultOpt == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
