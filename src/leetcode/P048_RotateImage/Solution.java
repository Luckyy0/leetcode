package leetcode.P048_RotateImage;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 48: Rotate Image
     * Approach: Transpose then Reverse Rows
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. Transpose: Swap matrix[i][j] with matrix[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }

    private void reverse(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] m1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] e1 = {
                { 7, 4, 1 },
                { 8, 5, 2 },
                { 9, 6, 3 }
        };
        runTest(solution, m1, e1);

        int[][] m2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        int[][] e2 = {
                { 15, 13, 2, 5 },
                { 14, 3, 4, 1 },
                { 12, 6, 8, 9 },
                { 16, 7, 10, 11 }
        };
        runTest(solution, m2, e2);
    }

    private static void runTest(Solution s, int[][] matrix, int[][] expected) {
        System.out.println("Input matrix size: " + matrix.length + "x" + matrix[0].length);
        // Print original if needed, but in-place modifies it, so maybe print copy

        s.rotate(matrix);

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
        for (int[] row : m) {
            System.out.println(Arrays.toString(row));
        }
    }
}
