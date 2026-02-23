package leet_code.Problem_279_Medium_Perfect_Squares;

import java.util.Arrays;

public class Solution_DP {

    /**
     * Finds the least number of perfect squares summing to n.
     * Uses Dynamic Programming.
     * Time: O(N * sqrt(N)), Space: O(N).
     * 
     * Tìm số lượng ít nhất các số chính phương có tổng bằng n.
     * Sử dụng Quy hoạch động.
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Loop through all numbers up to n
        // Duyệt qua tất cả các số đến n
        for (int i = 1; i <= n; i++) {
            // Try subtracting every square smaller than i
            // Thử trừ mọi số chính phương nhỏ hơn i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                // Transition: 1 (for the square j*j) + optimal count for (i - square)
                // Chuyển đổi: 1 (cho số chính phương j*j) + số lượng tối ưu cho (i - square)
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: 12 -> 3 (4+4+4)
        System.out.println("Squares 12: " + solution.numSquares(12));

        // Test Case 2: 13 -> 2 (4+9)
        System.out.println("Squares 13: " + solution.numSquares(13));
    }
}
