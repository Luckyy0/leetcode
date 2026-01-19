package leetcode.P085_MaximalRectangle;

import java.util.Stack;

public class Solution {

    /**
     * Problem 85: Maximal Rectangle
     * Approach: Dynamic Histogram per Row
     * Time Complexity: O(N * M)
     * Space Complexity: O(M)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate max area for current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    // Helper from P084
    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] m1 = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        runTest(solution, m1, 6);

        char[][] m2 = { { '0' } };
        runTest(solution, m2, 0);

        char[][] m3 = { { '1' } };
        runTest(solution, m3, 1);
    }

    private static void runTest(Solution s, char[][] matrix, int expected) {
        System.out.println("Input size: " + matrix.length + "x" + matrix[0].length);
        int result = s.maximalRectangle(matrix);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
