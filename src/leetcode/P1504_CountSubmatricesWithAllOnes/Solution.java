package leetcode.P1504_CountSubmatricesWithAllOnes;

import java.util.Stack;

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] height = new int[n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = (mat[i][j] == 0) ? 0 : height[j] + 1;
            }
            count += countRectangles(height);
        }

        return count;
    }

    // Count rectangles in histogram
    private int countRectangles(int[] height) {
        int n = height.length;
        int[] dp = new int[n]; // dp[i] = number of rects ending at column i
        Stack<Integer> stack = new Stack<>(); // Increasing stack of indices
        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                dp[i] = height[i] * (i + 1);
            } else {
                int prev = stack.peek();
                dp[i] = dp[prev] + height[i] * (i - prev);
            }

            stack.push(i);
            sum += dp[i];
        }

        return sum;
    }
}
