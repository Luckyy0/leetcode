package leetcode.P044_WildcardMatching;

public class Solution {

    /**
     * Problem 44: Wildcard Matching
     * Approach: Dynamic Programming
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string matches empty pattern
        dp[0][0] = true;

        // Handle pattern with * usually matching empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);
                char sChar = s.charAt(i - 1);

                if (pChar == '*') {
                    // Two choices:
                    // 1. '*' matches empty sequence: dp[i][j-1]
                    // 2. '*' matches one or more current chars from s: dp[i-1][j]
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pChar == '?' || pChar == sChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Approach: Greedy with Backtracking
     * Time Complexity: Average O(m + n)
     */
    public boolean isMatchGreedy(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int sIdx = 0;
        int pIdx = 0;
        int starIdx = -1;
        int sTmpIdx = -1;

        while (sIdx < sLen) {
            // Case 1: Match directly or '?'
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            }
            // Case 2: Found '*'
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            }
            // Case 3: Mismatch, backtrack to last '*'
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx;
            }
            // Case 4: Mismatch and no '*'
            else {
                return false;
            }
        }

        // Check remaining pattern
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == pLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "aa", "a", false);
        runTest(solution, "aa", "*", true);
        runTest(solution, "cb", "?a", false);
        runTest(solution, "adceb", "*a*b", true);
        runTest(solution, "acdcb", "a*c?b", false);
        runTest(solution, "", "******", true);
    }

    private static void runTest(Solution s, String str, String pat, boolean expected) {
        System.out.println("Input: s=\"" + str + "\", p=\"" + pat + "\"");
        boolean resDP = s.isMatch(str, pat);
        boolean resGreedy = s.isMatchGreedy(str, pat);

        System.out.println("DP:     " + resDP);
        System.out.println("Greedy: " + resGreedy + " (Expected: " + expected + ")");

        if (resDP == expected && resGreedy == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
