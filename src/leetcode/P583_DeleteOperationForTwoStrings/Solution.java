package leetcode.P583_DeleteOperationForTwoStrings;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] stores length of LCS of word1[0...i-1] and word2[0...j-1]
        // dp[i][j] lưu trữ độ dài của LCS của word1[0...i-1] và word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];

        // Result is total characters minus 2 * LCS length
        // Kết quả là tổng số ký tự trừ đi 2 * độ dài LCS
        return (m - lcs) + (n - lcs);
    }
}
