package leetcode.P072_EditDistance;

public class Solution {

    /**
     * Problem 72: Edit Distance
     * Approach: Dynamic Programming
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] represents the edit distance between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        // Converting word1[0..i] to empty string requires i deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // Converting empty string to word2[0..j] requires j insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Min of:
                    // 1. Delete char from word1: dp[i-1][j] + 1
                    // 2. Insert char into word1 (match word2's char): dp[i][j-1] + 1
                    // 3. Replace char in word1: dp[i-1][j-1] + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "horse", "ros", 3);
        runTest(solution, "intention", "execution", 5);
        runTest(solution, "", "abc", 3);
        runTest(solution, "abc", "abc", 0);
    }

    private static void runTest(Solution s, String word1, String word2, int expected) {
        System.out.println("Input: word1=\"" + word1 + "\", word2=\"" + word2 + "\"");
        int result = s.minDistance(word1, word2);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
