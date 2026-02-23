package leet_code.Problem_931_Medium_Minimum_Falling_Path_Sum;

/**
 * Problem 931: Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class Solution {

    /**
     * Calculates the minimum falling path sum.
     * Strategy: Dynamic Programming (In-place).
     * 
     * @param matrix n x n matrix.
     * @return Minimum path sum.
     * 
     *         Tóm tắt chiến lược:
     *         1. Đây là bài toán Quy hoạch Động (DP).
     *         2. Để đến được ô (r, c), ta phải đi từ một trong ba ô ở hàng trên:
     *         - (r-1, c-1): chéo trên trái.
     *         - (r-1, c): ngay phía trên.
     *         - (r-1, c+1): chéo trên phải.
     *         3. Công thức truy hồi:
     *         dp[r][c] = matrix[r][c] + min(dp[r-1][c-1], dp[r-1][c], dp[r-1][c+1])
     *         4. Ta có thể thực hiện trực tiếp trên ma trận đầu vào (in-place) để
     *         tiết kiệm bộ nhớ không gian O(1) phụ trợ.
     *         5. Duyệt từ hàng thứ 2 (index 1) đến hàng cuối cùng.
     *         6. Tại mỗi ô, cộng thêm giá trị nhỏ nhất của 3 ô hợp lệ ở hàng liền
     *         trước.
     *         7. Kết quả cuối cùng là giá trị nhỏ nhất trong hàng cuối cùng của ma
     *         trận đã biến đổi.
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from the second row
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // Initialize minPrev with the value directly above
                int minPrev = matrix[r - 1][c];

                // Check upper left
                if (c > 0) {
                    minPrev = Math.min(minPrev, matrix[r - 1][c - 1]);
                }

                // Check upper right
                if (c < n - 1) {
                    minPrev = Math.min(minPrev, matrix[r - 1][c + 1]);
                }

                // Update current cell with the minimum path sum reaching it
                matrix[r][c] += minPrev;
            }
        }

        // The answer is the minimum value in the last row
        int result = Integer.MAX_VALUE;
        for (int val : matrix[n - 1]) {
            result = Math.min(result, val);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] m1 = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println("Result: " + sol.minFallingPathSum(m1)); // 13

        int[][] m2 = { { -19, 57 }, { -40, -5 } };
        System.out.println("Result: " + sol.minFallingPathSum(m2)); // -59
    }
}
