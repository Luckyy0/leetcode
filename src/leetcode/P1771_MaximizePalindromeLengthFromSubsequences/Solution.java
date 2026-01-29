package leetcode.P1771_MaximizePalindromeLengthFromSubsequences;

public class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = word1.length();
        int len = s.length();

        // dp[i][j] stores LPS length of s[i...j]
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int maxLen = 0;

        // Fill DP
        for (int length = 2; length <= len; length++) {
            for (int i = 0; i <= len - length; i++) {
                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];

                    // Check condition: i in word1, j in word2
                    if (i < n && j >= n) {
                        maxLen = Math.max(maxLen, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return maxLen;
    }
}
