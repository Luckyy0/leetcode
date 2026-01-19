package leetcode.P073_SetMatrixZeroes;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 73: Set Matrix Zeroes
     * Approach: In-place Marker (First Row & Col)
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1. Determine if first row or first col need to be zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // 2. Use first row and col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. Set matrix elements to zero based on markers
        // Iterate start from 1 to avoid messing up the marker row/col too early
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. Handle first row and col
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] m1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] e1 = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        runTest(solution, m1, e1);

        int[][] m2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int[][] e2 = { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } };
        runTest(solution, m2, e2);
    }

    private static void runTest(Solution s, int[][] matrix, int[][] expected) {
        System.out.println("Input size: " + matrix.length + "x" + matrix[0].length);
        s.setZeroes(matrix);

        boolean pass = Arrays.deepEquals(matrix, expected);
        if (pass) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            printMatrix(matrix);
        }
        System.out.println("-----------------");
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m)
            System.out.println(Arrays.toString(row));
    }
}
