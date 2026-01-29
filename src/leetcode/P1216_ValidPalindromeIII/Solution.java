package leetcode.P1216_ValidPalindromeIII;

class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        // dp[i][j] length of LPS in s[i...j]
        // Space optimized: 1D array? Need prev diag.

        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prev = 0; // corresponds to dp[i+1][j-1] (diag)

            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        return n - dp[n - 1] <= k;
    }
}
