package leet_code.Problem_730_Hard_Count_Different_Palindromic_Subsequences;

public class Solution {

    /**
     * Counts distinct palindromic subsequences using Interval DP.
     * Time: O(N^2), Space: O(N^2).
     */
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = 1_000_000_007;
        long[][] dp = new long[n][n];

        // Base case: singular characters
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill table by length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    // Match Case
                    int left = i + 1;
                    int right = j - 1;

                    while (left <= right && s.charAt(left) != s.charAt(i))
                        left++;
                    while (left <= right && s.charAt(right) != s.charAt(j))
                        right--;

                    if (left > right) {
                        // Scenario A: No duplicate boundary chars in between
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (left == right) {
                        // Scenario B: One duplicate boundary char in between
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        // Scenario C: Two or more duplicate boundary chars
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }
                } else {
                    // Mismatch Case: Inclusion-Exclusion
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }

                // Keep it positive and within mod
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }

        return (int) dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (bccb): " + sol.countPalindromicSubsequences("bccb")); // 6
        System.out.println(
                "Result (abcdabcd...): " + sol.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcba")); // 104860361
    }
}
