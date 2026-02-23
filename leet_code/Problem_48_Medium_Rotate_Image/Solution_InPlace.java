package leet_code.Problem_48_Medium_Rotate_Image;

import java.util.Arrays;

public class Solution_InPlace {

    /**
     * Rotates the matrix 90 degrees clockwise in-place.
     * Uses Transpose then Reverse approach.
     * Xoay mảng 90 độ theo chiều kim đồng hồ tại chỗ.
     * Sử dụng phương pháp Hoán vị rồi Đảo ngược.
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        // Bước 1: Hoán vị mảng
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // Bước 2: Đảo ngược từng hàng
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    /**
     * Helper to print matrix.
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Solution_InPlace solution = new Solution_InPlace();

        // Test Case 1
        int[][] m1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Original 1:");
        printMatrix(m1);
        solution.rotate(m1);
        System.out.println("Rotated 1:");
        printMatrix(m1);

        // Test Case 2
        int[][] m2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        System.out.println("\nOriginal 2:");
        printMatrix(m2);
        solution.rotate(m2);
        System.out.println("Rotated 2:");
        printMatrix(m2);
    }
}
