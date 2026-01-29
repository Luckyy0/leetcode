package leetcode.P1062_LongestRepeatingSubstring;

class Solution {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}
