package leetcode.P712_MinimumASCIIDeleteSumForTwoStrings;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Fill base cases for end of strings
        // Điền các trường hợp cơ bản cho phần kết thúc của chuỗi
        for (int i = n1 - 1; i >= 0; i--) {
            dp[i][n2] = dp[i + 1][n2] + s1.charAt(i);
        }
        for (int j = n2 - 1; j >= 0; j--) {
            dp[n1][j] = dp[n1][j + 1] + s2.charAt(j);
        }

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j],
                            s2.charAt(j) + dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
