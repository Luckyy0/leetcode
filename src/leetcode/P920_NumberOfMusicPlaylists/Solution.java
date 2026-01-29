package leetcode.P920_NumberOfMusicPlaylists;

class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = 1_000_000_007;
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                // Case 1: New song
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                // Case 2: Repeating an old song
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % mod;
                }
            }
        }

        return (int) dp[goal][n];
    }
}
