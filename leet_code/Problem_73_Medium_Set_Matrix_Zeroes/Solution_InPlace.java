package leet_code.Problem_73_Medium_Set_Matrix_Zeroes;

import java.util.Arrays;

public class Solution_InPlace {

    /**
     * Sets rows and columns to zero if an element is zero.
     * Achieves O(1) space complexity.
     * Đặt hàng và cột thành không nếu một phần tử bằng không.
     * Đạt được độ phức tạp không gian O(1).
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1. Check if first row/column has any zeros
        // Kiểm tra xem hàng/cột đầu tiên có số không nào không
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 2. Use first row/column to store zero information
        // Sử dụng hàng/cột đầu tiên để lưu trữ thông tin về số không
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. Update inner part of the matrix
        // Cập nhật phần bên trong của ma trận
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. Update the first row and column
        // Cập nhật hàng và cột đầu tiên
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution_InPlace solution = new Solution_InPlace();

        // Test Case 1
        int[][] m1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        solution.setZeroes(m1);
        System.out.println("Test Case 1: " + Arrays.deepToString(m1));
        // Expected: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

        // Test Case 2
        int[][] m2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        solution.setZeroes(m2);
        System.out.println("Test Case 2: " + Arrays.deepToString(m2));
        // Expected: [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
    }
}
