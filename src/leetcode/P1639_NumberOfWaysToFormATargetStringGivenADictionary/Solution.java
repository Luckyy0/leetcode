package leetcode.P1639_NumberOfWaysToFormATargetStringGivenADictionary;

public class Solution {
    public int numWays(String[] words, String target) {
        int mod = 1_000_000_007;
        int m = target.length();
        int k = words[0].length();

        // Precompute frequency of characters in each column
        long[][] freq = new long[k][26];
        for (String word : words) {
            for (int j = 0; j < k; j++) {
                freq[j][word.charAt(j) - 'a']++;
            }
        }

        // dp[i] = ways to form prefix of target of length i
        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int j = 0; j < k; j++) {
            // Iterate backwards to update dp
            // We want to form target[i-1] using column j
            // target char index is i-1
            for (int i = m; i >= 1; i--) {
                int charIdx = target.charAt(i - 1) - 'a';
                long ways = freq[j][charIdx];
                if (ways > 0) {
                    dp[i] = (dp[i] + dp[i - 1] * ways) % mod;
                }
            }
        }

        return (int) dp[m];
    }
}
