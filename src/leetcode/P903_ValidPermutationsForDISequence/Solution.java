package leetcode.P903_ValidPermutationsForDISequence;

class Solution {
    public int numPermsDISequence(String s) {
        int n = s.length();
        int mod = 1_000_000_007;
        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i - 1) == 'D') {
                    for (int k = j; k < i; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                } else {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= n; j++)
            res = (res + dp[n][j]) % mod;
        return res;
    }
}
