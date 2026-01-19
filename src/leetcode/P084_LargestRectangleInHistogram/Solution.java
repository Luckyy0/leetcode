package leetcode.P084_LargestRectangleInHistogram;

import java.util.Stack;

public class Solution {

    /**
     * Problem 84: Largest Rectangle in Histogram
     * Approach: Monotonic Increasing Stack
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 as height for the hypothetical bar at index n (end)
            // This forces all remaining bars in stack to be popped and processed
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // Pop the top bar, it is the one we calculate area for
                int height = heights[stack.pop()];

                // Determine width
                // If stack is empty, it means 'height' was the smallest so far, width stretches
                // from 0 to i
                // Else, left boundary is the new top of stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 2, 1, 5, 6, 2, 3 }, 10);
        runTest(solution, new int[] { 2, 4 }, 4);
        runTest(solution, new int[] { 1, 1 }, 2); // 1*2
    }

    private static void runTest(Solution s, int[] heights, int expected) {
        System.out.println("Input size: " + heights.length);
        int result = s.largestRectangleArea(heights);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
