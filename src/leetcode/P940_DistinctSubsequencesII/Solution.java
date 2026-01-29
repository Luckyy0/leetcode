package leetcode.P940_DistinctSubsequencesII;

import java.util.Arrays;

class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        long mod = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1; // Empty subsequence count

        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);

        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            dp[i] = (dp[i - 1] * 2) % mod;
            if (lastIdx[c] != -1) {
                dp[i] = (dp[i] - dp[lastIdx[c]] + mod) % mod;
            }
            lastIdx[c] = i - 1;
        }

        return (int) (dp[n] - 1 + mod) % (int) mod; // Subtract empty subsequence
    }
}
