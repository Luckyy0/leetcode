package leet_code.Problem_59_Medium_Spiral_Matrix_II;

import java.util.Arrays;

public class Solution_Boundary {

    /**
     * Generates an n x n spiral matrix.
     * Uses boundary traversal simulation.
     * Tạo một ma trận xoắn ốc n x n.
     * Sử dụng mô phỏng duyệt ranh giới.
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0)
            return matrix;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;

        while (num <= n * n) {
            // Fill Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Fill Down
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Fill Left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            // Fill Up
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution_Boundary solution = new Solution_Boundary();

        // Test Case 1
        int n1 = 3;
        int[][] r1 = solution.generateMatrix(n1);
        System.out.println("Test Case 1 (n=3):");
        for (int[] row : r1)
            System.out.println(Arrays.toString(row));
        // Expected: [[1, 2, 3], [8, 9, 4], [7, 6, 5]]

        // Test Case 2
        int n2 = 1;
        int[][] r2 = solution.generateMatrix(n2);
        System.out.println("\nTest Case 2 (n=1):");
        for (int[] row : r2)
            System.out.println(Arrays.toString(row));
        // Expected: [[1]]
    }
}
