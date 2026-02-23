package leet_code.Problem_883_Easy_Projection_Area_of_3D_Shapes;

/**
 * Problem 883: Projection Area of 3D Shapes
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 */
public class Solution {

    /**
     * Calculates the total projection area.
     * Strategy: Calculate area for each axis (XY, XZ, YZ).
     * 
     * @param grid Grid of tower heights.
     * @return Total area.
     * 
     *         Tóm tắt chiến lược:
     *         1. Hình chiếu XY (nhìn từ trên): Diện tích là số lượng ô có chiều cao
     *         > 0.
     *         2. Hình chiếu XZ (nhìn từ trước): Diện tích là tổng chiều cao lớn
     *         nhất của mỗi hàng.
     *         3. Hình chiếu YZ (nhìn từ bên): Diện tích là tổng chiều cao lớn nhất
     *         của mỗi cột.
     *         4. Duyệt qua từng hàng 'i':
     *         - Tính max của hàng 'i' (cho XZ).
     *         - Tính max của cột 'i' (bằng cách truy cập ngược grid[j][i], cho YZ).
     *         - Cộng dồn kết quả.
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int bestRow = 0;
            int bestCol = 0;

            for (int j = 0; j < n; j++) {
                // Top View: Each non-zero cell contributes 1
                if (grid[i][j] > 0)
                    ans++;

                // Max height in current row (Front View)
                bestRow = Math.max(bestRow, grid[i][j]);

                // Max height in current column (Side View)
                // Note: accessing grid[j][i] effectively iterates down column i
                bestCol = Math.max(bestCol, grid[j][i]);
            }

            ans += bestRow + bestCol;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = { { 1, 2 }, { 3, 4 } };
        System.out.println("Result: " + sol.projectionArea(g1)); // 17

        int[][] g2 = { { 2 } };
        System.out.println("Result: " + sol.projectionArea(g2)); // 5

        int[][] g3 = { { 1, 0 }, { 0, 2 } };
        System.out.println("Result: " + sol.projectionArea(g3)); // 8
    }
}
