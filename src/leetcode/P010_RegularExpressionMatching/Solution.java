package leetcode.P010_RegularExpressionMatching;

public class Solution {

    /**
     * Problem 10: Regular Expression Matching
     * Approach 1: Recursion (Slow)
     */
    public boolean isMatchRecursive(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        boolean firstMatch = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Option 1: Ignore * (match 0 times) -> isMatch(s, p.substring(2))
            // Option 2: Use * (match 1+ times) -> firstMatch && isMatch(s.substring(1), p)
            return (isMatchRecursive(s, p.substring(2)) ||
                    (firstMatch && isMatchRecursive(s.substring(1), p)));
        } else {
            return firstMatch && isMatchRecursive(s.substring(1), p.substring(1));
        }
    }

    /**
     * Approach 3: Dynamic Programming (Bottom-Up)
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty matches empty
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, .* matching empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == sChar || pChar == '.') {
                    // Characters match directly
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    char pPrev = p.charAt(j - 2);
                    // Two cases for *:
                    // 1. Ignore the star and preceding char (match 0 times): dp[i][j-2]
                    // 2. Use the star (match 1+ times): if sChar matches pPrev, take dp[i-1][j]

                    boolean matchZero = dp[i][j - 2];
                    boolean matchMany = false;

                    if (sChar == pPrev || pPrev == '.') {
                        matchMany = dp[i - 1][j];
                    }

                    dp[i][j] = matchZero || matchMany;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "aa", "a", false);
        runTest(solution, "aa", "a*", true);
        runTest(solution, "ab", ".*", true);
        runTest(solution, "aab", "c*a*b", true);
        runTest(solution, "mississippi", "mis*is*p*.", false);
        runTest(solution, "ab", ".*c", false);
    }

    private static void runTest(Solution s, String str, String pat, boolean expected) {
        System.out.println("Input: s=\"" + str + "\", p=\"" + pat + "\"");
        boolean res = s.isMatch(str, pat);
        System.out.println("Output: " + res + " (Expected: " + expected + ")");

        if (res == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
