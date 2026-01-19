package leetcode.P054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 54: Spiral Matrix
     * Approach: Boundary Simulation
     * Time Complexity: O(m * n)
     * Space Complexity: O(1) (excluding output)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse Top Row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // Traverse Right Column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Check if done
            if (top > bottom || left > right)
                break;

            // Traverse Bottom Row
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--;

            // Traverse Left Column
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        runTest(solution, m1, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));

        int[][] m2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        runTest(solution, m2, List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
    }

    private static void runTest(Solution s, int[][] matrix, List<Integer> expected) {
        System.out.println("Input size: " + matrix.length + "x" + matrix[0].length);
        List<Integer> result = s.spiralOrder(matrix);
        System.out.println("Output: " + result);

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
