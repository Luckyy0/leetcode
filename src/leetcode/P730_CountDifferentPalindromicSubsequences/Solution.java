package leetcode.P730_CountDifferentPalindromicSubsequences;

class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        long[][] dp = new long[n][n];
        long mod = 1_000_000_007;

        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    int l = i + 1, r = j - 1;
                    while (l <= r && s.charAt(l) != s.charAt(i))
                        l++;
                    while (l <= r && s.charAt(r) != s.charAt(i))
                        r--;

                    if (l > r) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (l == r) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[l + 1][r - 1];
                    }
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return (int) dp[0][n - 1];
    }
}
