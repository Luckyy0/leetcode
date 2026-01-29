package leetcode.P471_EncodeStringWithShortestLength;

public class Solution {

    /**
     * Problem 471: Encode String with Shortest Length
     * Approach: Dynamic Programming (Interval DP)
     * 
     * Time Complexity: O(N^4)
     * Space Complexity: O(N^3)
     */
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                String sub = s.substring(i, j + 1);
                dp[i][j] = sub;

                if (len < 5)
                    continue;

                // Case 1: Split
                for (int k = i; k < j; k++) {
                    if (dp[i][k].length() + dp[k + 1][j].length() <= dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }

                // Case 2: Repeat
                // Use the doubled string trick to find repeating pattern
                String doubled = sub + sub;
                int firstMatch = doubled.indexOf(sub, 1);
                if (firstMatch < sub.length()) {
                    String pattern = sub.substring(0, firstMatch);
                    int count = sub.length() / firstMatch;
                    String encoded = count + "[" + dp[i][i + firstMatch - 1] + "]";
                    if (encoded.length() <= dp[i][j].length()) {
                        dp[i][j] = encoded;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "aaaaaaaaaa" -> "10[a]"
        runTest(sol, "aaaaaaaaaa", "10[a]");

        // "aabcaabcd" -> "2[aabc]d"
        runTest(sol, "aabcaabcd", "2[aabc]d");

        // "abbbabbbcabbbabbbc" -> "2[2[abbb]c]"
        runTest(sol, "abbbabbbcabbbabbbc", "2[2[abbb]c]");
    }

    private static void runTest(Solution sol, String s, String expected) {
        String result = sol.encode(s);
        System.out.println("Input: " + s + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
