package leet_code.Problem_712_Medium_Minimum_ASCII_Delete_Sum_for_Two_Strings;

public class Solution {

    /**
     * Calculates the minimum ASCII delete sum to make two strings equal.
     * Strategy: 2D Dynamic Programming (Variation of weighted LCS).
     * Time: O(M * N), Space: O(M * N).
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base case: s2 is empty
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // Base case: s1 is empty
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Match: no deletion cost
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Mismatch: delete from s1 or s2
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + s1.charAt(i - 1),
                            dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (sea, eat): " + sol.minimumDeleteSum("sea", "eat")); // 231
        System.out.println("Result (delete, leet): " + sol.minimumDeleteSum("delete", "leet")); // 403
    }
}
