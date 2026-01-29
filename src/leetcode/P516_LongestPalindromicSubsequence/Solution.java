package leetcode.P516_LongestPalindromicSubsequence;

public class Solution {

    /**
     * Problem 516: Longest Palindromic Subsequence
     * Approach: Dynamic Programming (Interval DP)
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (len > 2 ? dp[i + 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "bbbab" -> 4 ("bbbb")
        System.out.println("Result 1: " + sol.longestPalindromeSubseq("bbbab") + " (Expected: 4)");

        // "cbbd" -> 2 ("bb")
        System.out.println("Result 2: " + sol.longestPalindromeSubseq("cbbd") + " (Expected: 2)");
    }
}
