package leet_code.Problem_64_Medium_Minimum_Path_Sum;

public class Solution_DP {

    /**
     * Finds the minimum path sum from top-left to bottom-right.
     * Uses in-place Dynamic Programming to save space.
     * Tìm tổng đường đi nhỏ nhất từ trên cùng bên trái đến dưới cùng bên phải.
     * Sử dụng Quy hoạch động tại chỗ để tiết kiệm không gian.
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        // Initialize the prefix sums for the first row and first column
        // Khởi tạo tổng tiền tố cho hàng đầu tiên và cột đầu tiên
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Fill the rest of the grid
        // Điền vào phần còn lại của lưới
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        int[][] g1 = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };
        System.out.println("Test Case 1: " + solution.minPathSum(g1));
        // Expected: 7

        // Test Case 2
        int[][] g2 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        System.out.println("Test Case 2: " + solution.minPathSum(g2));
        // Expected: 12
    }
}
