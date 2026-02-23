package leet_code.Problem_84_Hard_Largest_Rectangle_In_Histogram;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Finds the largest rectangle area in a histogram.
     * Uses a monotonic stack for O(n) time complexity.
     * Tìm diện tích hình chữ nhật lớn nhất trong biểu đồ cột.
     * Sử dụng ngăn xếp đơn điệu với độ phức tạp thời gian O(n).
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 as the height for the end boundary
            // Sử dụng 0 làm chiều cao cho ranh giới cuối cùng
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // The popped height is the height of the rectangle
                // Chiều cao vừa mới được lấy ra là chiều cao của hình chữ nhật
                int h = heights[stack.pop()];

                // Calculate width
                // Tính chiều rộng
                // If stack is empty, it means the popped height was the smallest so far
                // Nếu ngăn xếp trống, có nghĩa là chiều cao vừa lấy ra là nhỏ nhất cho đến nay
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: [2,1,5,6,2,3]
        int[] h1 = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Test Case 1: " + solution.largestRectangleArea(h1));
        // Expected: 10

        // Test Case 2: [2,4]
        int[] h2 = { 2, 4 };
        System.out.println("Test Case 2: " + solution.largestRectangleArea(h2));
        // Expected: 4
    }
}
