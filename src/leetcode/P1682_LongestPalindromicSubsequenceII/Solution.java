package leetcode.P1682_LongestPalindromicSubsequenceII;

public class Solution {
    private int[][][] memo;
    private String s;

    public int longestPalindromeSubseq(String s) {
        this.s = s;
        int n = s.length();
        memo = new int[n][n][27];

        // Fill -1
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                java.util.Arrays.fill(memo[i][j], -1);

        return dfs(0, n - 1, 0);
    }

    private int dfs(int i, int j, int last) {
        if (i >= j) {
            return 0; // Must be even length, so i==j is 0
        }

        if (memo[i][j][last] != -1) {
            return memo[i][j][last];
        }

        int res = 0;

        // Option 1: Try to match s[i] and s[j]
        if (s.charAt(i) == s.charAt(j)) {
            int charIdx = s.charAt(i) - 'a' + 1;
            if (charIdx != last) {
                res = Math.max(res, 2 + dfs(i + 1, j - 1, charIdx));
            } else {
                // If s[i] == last, we can't use both as the next layer.
                // We MUST skip one of them to make progress?
                // Actually, if s[i] == last, this outer pair is invalid extension.
                // We must proceed to solve subproblem by skipping.
                res = Math.max(res, dfs(i + 1, j, last));
                res = Math.max(res, dfs(i, j - 1, last));
            }
        } else {
            // s[i] != s[j], skip one
            res = Math.max(res, dfs(i + 1, j, last));
            res = Math.max(res, dfs(i, j - 1, last));
        }

        return memo[i][j][last] = res;
    }
}
