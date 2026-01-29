package leetcode.P1278_PalindromePartitioningIII;

class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Precompute cost to make s[i...j] palindrome
        // Iterate length to fill DP
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                cost[i][j] = (s.charAt(i) != s.charAt(j) ? 1 : 0) + cost[i + 1][j - 1];
            }
        }

        // dp[p][i] min cost for p parts ending at i (exclusive i.e. s[0...i-1])
        // Or i inclusive. Let's use i as length/index.
        // Use dp[p][len].
        int[][] dp = new int[k + 1][n + 1];

        // Init with infinity
        for (int p = 0; p <= k; p++) {
            for (int i = 0; i <= n; i++)
                dp[p][i] = Integer.MAX_VALUE / 2;
        }
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = p; i <= n; i++) { // Need at least p chars for p parts
                // Try split at j (last part is s[j...i-1])
                // j goes from p-1 to i-1
                for (int j = p - 1; j < i; j++) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + cost[j][i - 1]);
                }
            }
        }

        return dp[k][n];
    }
}
