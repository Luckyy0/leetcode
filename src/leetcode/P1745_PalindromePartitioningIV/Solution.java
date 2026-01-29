package leetcode.P1745_PalindromePartitioningIV;

public class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        // Compute Palindrome Table
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }
            }
        }

        // Check splits
        for (int i = 0; i < n - 2; i++) {
            if (isPal[0][i]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (isPal[i + 1][j] && isPal[j + 1][n - 1]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
