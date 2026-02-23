package leet_code.Problem_664_Hard_Strange_Printer;

public class Solution {

    /**
     * Calculates the minimum number of turns to print string s.
     * Strategy: Interval DP. dp[i][j] is the min turns for s[i...j].
     * Time: O(N^3), Space: O(N^2).
     */
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;

        // Remove consecutive duplicate characters to optimize
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() == 0 || c != sb.charAt(sb.length() - 1)) {
                sb.append(c);
            }
        }
        String ns = sb.toString();
        int n = ns.length();

        int[][] dp = new int[n][n];

        // Fill DP table for intervals of increasing length
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // Base case: single character
            for (int j = i + 1; j < n; j++) {
                if (ns.charAt(i) == ns.charAt(j)) {
                    // Optimization: if ends are same, we can print them in the same turn
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // Default: Split interval at all possible points k
                    int minTurns = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minTurns = Math.min(minTurns, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minTurns;
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Turns for aaabbb: " + sol.strangePrinter("aaabbb")); // 2
        System.out.println("Turns for aba: " + sol.strangePrinter("aba")); // 2
    }
}
