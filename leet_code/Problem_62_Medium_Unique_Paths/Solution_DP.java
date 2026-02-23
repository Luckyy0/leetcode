package leet_code.Problem_62_Medium_Unique_Paths;

import java.util.Arrays;

public class Solution_DP {

    /**
     * Finds the number of unique paths in an m x n grid.
     * Uses optimized Dynamic Programming with O(n) space.
     * Tìm số lượng đường đi duy nhất trong lưới m x n.
     * Sử dụng Quy hoạch động tối ưu với không gian O(n).
     */
    public int uniquePaths(int m, int n) {
        // Use an array to store the current row's results
        // Sử dụng một mảng để lưu kết quả của hàng hiện tại
        int[] dp = new int[n];

        // Base case: There is only 1 way to reach any cell in the first row (stay
        // right)
        // Trường hợp cơ sở: Chỉ có 1 cách để đạt tới bất kỳ ô nào ở hàng đầu tiên
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j] is the ways to reach (i-1, j) (from above)
                // dp[j-1] is the ways to reach (i, j-1) (from left)
                // dp[j] = dp[j] (above) + dp[j-1] (left)
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        System.out.println("Test Case 1 (3x7): " + solution.uniquePaths(3, 7));
        // Expected: 28

        // Test Case 2
        System.out.println("Test Case 2 (3x2): " + solution.uniquePaths(3, 2));
        // Expected: 3
    }
}
