package leet_code.Problem_583_Medium_Delete_Operation_for_Two_Strings;

public class Solution_DP {

    /**
     * Finds the minimum deletions to make two strings identical.
     * Strategy: Total Length - 2 * Longest Common Subsequence (LCS).
     * Time: O(M * N), Space: O(M * N).
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Find length of Longest Common Subsequence
        int lcsLength = lcs(word1, word2, m, n);

        // Result is characters not in LCS for both strings
        return m + n - 2 * lcsLength;
    }

    private int lcs(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Current characters match
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Mismatch, take the best from skipping one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        System.out.println("Min deletions for 'sea' and 'eat': " + solution.minDistance("sea", "eat")); // 2
    }
}
