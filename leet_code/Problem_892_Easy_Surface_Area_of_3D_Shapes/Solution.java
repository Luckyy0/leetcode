package leet_code.Problem_892_Easy_Surface_Area_of_3D_Shapes;

/**
 * Problem 892: Surface Area of 3D Shapes
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 */
public class Solution {

    /**
     * Calculates the total surface area.
     * Strategy: Additive and Subtractive.
     * 
     * @param grid Grid of tower heights.
     * @return Total surface area.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mỗi cột tháp có chiều cao v > 0 sẽ đóng góp:
     *         - 2 mặt đáy (trên và dưới).
     *         - 4 * v mặt xung quanh.
     *         -> Tổng: 4*v + 2.
     *         2. Tuy nhiên, các cột liền kề sẽ che khuất nhau.
     *         - Giữa cột (i, j) và cột (i+1, j) (bên dưới), số mặt bị che là:
     *         2 * min(grid[i][j], grid[i+1][j]).
     *         - Giữa cột (i, j) và cột (i, j+1) (bên phải), số mặt bị che là:
     *         2 * min(grid[i][j], grid[i][j+1]).
     *         3. Duyệt qua từng ô, cộng tổng diện tích và trừ đi phần bị che.
     */
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    area += grid[i][j] * 4 + 2;
                }

                // Subtract overlap with the cell below
                if (i < n - 1) {
                    area -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                }

                // Subtract overlap with the cell to the right
                if (j < n - 1) {
                    area -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] g1 = { { 1, 2 }, { 3, 4 } };
        System.out.println("Result: " + sol.surfaceArea(g1)); // 34

        int[][] g2 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println("Result: " + sol.surfaceArea(g2)); // 32

        int[][] g3 = { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 } };
        System.out.println("Result: " + sol.surfaceArea(g3)); // 46
    }
}
