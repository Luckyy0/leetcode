package leetcode.P664_StrangePrinter;

class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                // Initialize with printing the last character separately
                // Khởi tạo bằng cách in ký tự cuối cùng một cách riêng biệt
                dp[i][j] = dp[i][j - 1] + 1;

                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        // If s[k] == s[j], we can potentially save one turn.
                        // However, we still need to consider the range between k and j.
                        // Nếu s[k] == s[j], chúng ta có khả năng tiết kiệm một lượt.
                        // Tuy nhiên, chúng ta vẫn cần xem xét phạm vi giữa k và j.
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + (k + 1 <= j - 1 ? dp[k + 1][j - 1] : 0));
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
