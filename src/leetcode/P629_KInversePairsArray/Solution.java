package leetcode.P629_KInversePairsArray;

class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;

        // dp[i][j] = number of permutations of length i with j inverese pairs
        // dp[i][j] = số lượng hoán vị có độ dài i với j cặp nghịch đảo
        // Optimization: Use 1D array or 2 rows

        int[][] dp = new int[n + 1][k + 1];

        // Base case: length 0 has 0 inverse pairs? Actually length 1 has 0.
        // n=0 -> 0 pairs -> count 0? Or 1 (empty set)?
        // Problem says n>=1.
        // For i=1, only j=0 is possible (count 1).

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-i]
                int val = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
                if (j >= i) {
                    val = (val - dp[i - 1][j - i] + MOD) % MOD;
                }
                dp[i][j] = val;
            }
        }

        return dp[n][k];
    }
}
