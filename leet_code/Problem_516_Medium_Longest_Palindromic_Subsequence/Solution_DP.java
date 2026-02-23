package leet_code.Problem_516_Medium_Longest_Palindromic_Subsequence;

public class Solution_DP {

    /**
     * Finds length of longest palindromic subsequence.
     * Strategy: Interval DP dp[i][j].
     * Time: O(N^2), Space: O(N^2).
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single char is palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Iterate length from 2 to n
        // Or simply iterate i backwards, j forwards
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Space optimized O(N) version
    public int longestPalindromeSubseqSpaceOpt(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] prevDp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + prevDp[j - 1];
                } else {
                    dp[j] = Math.max(prevDp[j], dp[j - 1]);
                }
            }
            // Swap arrays or copy. Just copy for logic clarity.
            // Wait, standard 1D optimization for palindrome requires 'prev' variable.
            // Here 'prevDp' represents row i+1. 'dp' represents row i.
            // After computing row i, it becomes row i+1 for next iteration (i--).
            System.arraycopy(dp, 0, prevDp, 0, n);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        System.out.println("Result: " + solution.longestPalindromeSubseq("bbbab")); // 4
    }
}
