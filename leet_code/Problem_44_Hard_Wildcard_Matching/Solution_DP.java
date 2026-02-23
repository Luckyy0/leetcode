package leet_code.Problem_44_Hard_Wildcard_Matching;

public class Solution_DP {

    /**
     * Wildcard pattern matching.
     * Uses dynamic programming approach.
     * Khớp mẫu ký tự đại diện.
     * Sử dụng phương pháp quy hoạch động.
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case
        dp[0][0] = true;

        // Initialization for patterns starting with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.isMatch("aa", "a"));
        // Expected: false

        // Test Case 2
        System.out.println("Test Case 2: " + solution.isMatch("aa", "*"));
        // Expected: true

        // Test Case 3
        System.out.println("Test Case 3: " + solution.isMatch("cb", "?a"));
        // Expected: false
    }
}
