package leetcode.P1246_PalindromeRemoval;

class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = 1;
                } else {
                    // Option 1: Split
                    dp[i][j] = Integer.MAX_VALUE;
                    // Standard split logic: min over k
                    // But here we can just say dp[i][j] = 1 + dp[i+1][j] as base?
                    // Actually, iterating k is safest for interval DP.
                    // But O(N^3).

                    // Optimization:
                    // dp[i][j] = 1 + dp[i+1][j] (remove i as single palindrome)
                    // Then iterate k where arr[i] == arr[k]. If equal, we can merge i and k?
                    // If arr[i] == arr[k], cost is dp[i+1][k-1] + dp[k+1][j].
                    // Logic: remove i+1...k-1, then i and k become adjacent, remove as pair.
                    // Wait, removing i and k might be part of the last step of i+1...k-1.
                    // If arr[i] == arr[k], can we consider them part of same palindrome removal?
                    // Yes. Cost is max(1, dp[i+1][k-1]) + dp[k+1][j].

                    // Let's stick to simple k split + single end match?
                    // No. The split logic covers everything?

                    // Standard Interval DP logic for clearing:
                    // 1. If arr[i] == arr[j], dp[i][j] = max(1, dp[i+1][j-1]).
                    // 2. Also consider splits: dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
                    // Actually, if we use splits, do we need the arr[i]==arr[j] case separately?
                    // Yes because split at k separates i and j. If i and j are part of SAME
                    // removal, split won't capture it directly unless one part is empty/absorbed.

                    if (arr[i] == arr[j]) {
                        dp[i][j] = (len == 2) ? 1 : dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = n; // Max possible
                    }

                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
