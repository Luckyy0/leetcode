package leetcode.P1977_NumberOfWaysToSeparateNumbers;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfCombinations(String num) {
        if (num.charAt(0) == '0')
            return 0;
        int n = num.length();

        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (num.charAt(i) == num.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }

        // dp[i][len] is count of partitions of num[0...i-1] where last number has
        // length len
        // 1-based index i for convenience of prefix sum logic
        // dp[i][len] = count for prefix of length i ending with block of length len
        int[][] dp = new int[n + 1][n + 1];

        // Base case: dp[0][0] = 1? No, logic is tricky.
        // Let's use dp[i][len] = number of ways to end at index i-1 with last number
        // length len.
        // Prefix sum optimization:
        // cumulative[i][len] = sum(dp[i][1...len])
        int[][] cumulative = new int[n + 1][n + 1];

        // Init: For full string as one number (length i), it's 1 way (except leading
        // zeros handled inside).
        // Actually handle inside transitions.

        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= i; len++) {
                // Last number is num[start...i-1] where start = i - len
                int start = i - len;
                if (num.charAt(start) == '0') {
                    dp[i][len] = 0;
                } else {
                    if (start == 0) {
                        dp[i][len] = 1;
                    } else {
                        // Previous number ends at start (length 'start'). Max length allowed is 'len'.
                        // We can take any prevLen < len. That sum is cumulative[start][len-1].
                        long count = cumulative[start][len - 1];

                        // Also check prevLen == len
                        if (start >= len) {
                            int prevStart = start - len;
                            // Compare num[prevStart...start-1] vs num[start...i-1]
                            boolean lessEq = false;
                            int common = lcp[prevStart][start];
                            if (common >= len)
                                lessEq = true; // Equal
                            else if (num.charAt(prevStart + common) < num.charAt(start + common))
                                lessEq = true;

                            if (lessEq) {
                                count = (count + dp[start][len]) % MOD;
                            }
                        }
                        dp[i][len] = (int) count;
                    }
                }
                cumulative[i][len] = (cumulative[i][len - 1] + dp[i][len]) % MOD;
            }
            // Fill remaining cumulatives?
            // Since loop for len goes up to i, later when accessing cumulative[i][len]
            // where len > i, we should just use cumulative[i][i]
            // But we only access cumulative[start][len-1] where start < i.
        }

        return cumulative[n][n];
    }
}
