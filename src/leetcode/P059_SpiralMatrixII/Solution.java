package leetcode.P059_SpiralMatrixII;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 59: Spiral Matrix II
     * Approach: Boundary Simulation
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int val = 1;
        int maxVal = n * n;

        while (val <= maxVal) {
            // Fill Top Row
            for (int j = left; j <= right && val <= maxVal; j++) {
                matrix[top][j] = val++;
            }
            top++;

            // Fill Right Column
            for (int i = top; i <= bottom && val <= maxVal; i++) {
                matrix[i][right] = val++;
            }
            right--;

            // Fill Bottom Row
            for (int j = right; j >= left && val <= maxVal; j--) {
                matrix[bottom][j] = val++;
            }
            bottom--;

            // Fill Left Column
            for (int i = bottom; i >= top && val <= maxVal; i--) {
                matrix[i][left] = val++;
            }
            left++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] e1 = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        runTest(solution, 3, e1);

        int[][] e2 = { { 1 } };
        runTest(solution, 1, e2);
    }

    private static void runTest(Solution s, int n, int[][] expected) {
        System.out.println("Input n: " + n);
        int[][] result = s.generateMatrix(n);

        boolean pass = Arrays.deepEquals(result, expected);
        if (pass) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            printMatrix(result);
        }
        System.out.println("-----------------");
    }

    private static void printMatrix(int[][] m) {
        for (int[] row : m)
            System.out.println(Arrays.toString(row));
    }
}
