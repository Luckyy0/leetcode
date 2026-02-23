package leet_code.Problem_85_Hard_Maximal_Rectangle;

import java.util.Stack;

public class Solution_HistogramBased {

    /**
     * Finds the largest rectangle containing only 1s in a binary matrix.
     * Converts each row into a histogram problem.
     * Tìm hình chữ nhật lớn nhất chỉ chứa các số 1 trong ma trận nhị phân.
     * Chuyển đổi mỗi hàng thành một bài toán biểu đồ cột.
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update heights based on current row
            // Cập nhật chiều cao dựa trên hàng hiện tại
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            // Calculate max area for this row's histogram
            // Tính diện tích tối đa cho biểu đồ cột của hàng này
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    /**
     * Helper method to find max area in histogram (Problem 84 logic).
     */
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution_HistogramBased solution = new Solution_HistogramBased();

        // Test Case 1
        char[][] m1 = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println("Test Case 1: " + solution.maximalRectangle(m1));
        // Expected: 6

        // Test Case 2
        char[][] m2 = { { '0' } };
        System.out.println("Test Case 2: " + solution.maximalRectangle(m2));
        // Expected: 0

        // Test Case 3
        char[][] m3 = { { '1' } };
        System.out.println("Test Case 3: " + solution.maximalRectangle(m3));
        // Expected: 1
    }
}
