package leetcode.P651_4KeysKeyboard;

class Solution {
    public int maxA(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Option 1: Just press 'A'
            // Tùy chọn 1: Chỉ nhấn 'A'
            dp[i] = dp[i - 1] + 1;

            // Option 2: Use Ctrl-A, Ctrl-C, Ctrl-V sequence
            // Tùy chọn 2: Sử dụng chuỗi Ctrl-A, Ctrl-C, Ctrl-V
            // j represents the number of steps used for the multiplication
            // j đại diện cho số bước được sử dụng cho phép nhân
            for (int j = 3; j <= i; j++) {
                // dp[i-j] * (j-1) means:
                // - Use i-j steps to get some amount
                // - Use j steps: 1 for Ctrl-A, 1 for Ctrl-C, (j-2) for Ctrl-V
                // - This multiplies by (j-1): original + (j-2) pastes
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }

        return dp[n];
    }
}
