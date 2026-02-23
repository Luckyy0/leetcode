package leet_code.Problem_312_Hard_Burst_Balloons;

public class Solution_IntervalDP {

    /**
     * Calculates max coins.
     * Uses Interval DP (Bursting k last).
     * Time: O(N^3), Space: O(N^2).
     * 
     * Tính số xu tối đa.
     * Sử dụng DP Khoảng (Nổ k cuối cùng).
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Create padded array
        // Tạo mảng đệm
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        // dp[i][j] stores max coins for range (i, j) exclusive
        // dp[i][j] lưu số xu tối đa cho phạm vi (i, j) không bao gồm biên
        int[][] dp = new int[n + 2][n + 2];

        // Iterate over length of range (distance between left and right)
        // starts from 2 (minimum gap for at least 1 balloon)
        // Lặp qua độ dài của phạm vi (khoảng cách giữa left và right)
        for (int len = 2; len <= n + 1; len++) {
            // Iterate left boundary
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;

                // Iterate k (the last balloon to burst in this range)
                // Lặp k (quả bong bóng cuối cùng nổ trong phạm vi này)
                for (int k = left + 1; k < right; k++) {
                    int coins = dp[left][k] + dp[k][right]
                            + newNums[left] * newNums[k] * newNums[right];

                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        Solution_IntervalDP solution = new Solution_IntervalDP();

        // Test Case 1: [3,1,5,8] -> 167
        int[] n1 = { 3, 1, 5, 8 };
        System.out.println("Max Coins 1: " + solution.maxCoins(n1));

        // Test Case 2: [1,5] -> 10
        int[] n2 = { 1, 5 };
        System.out.println("Max Coins 2: " + solution.maxCoins(n2));
    }
}
