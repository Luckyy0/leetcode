package leetcode.P1130_MinimumCostTreeFromLeafValues;

import java.util.Stack;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE); // Sentinel
        int res = 0;

        for (int x : arr) {
            while (stack.peek() <= x) {
                int mid = stack.pop();
                // mid is multiplied with min(left_neighbor, right_neighbor)
                // Left neighbor: new stack.peek()
                // Right neighbor: x
                res += mid * Math.min(stack.peek(), x);
            }
            stack.push(x);
        }

        // Remaining elements in stack (except sentinel) must be merged
        while (stack.size() > 2) {
            int mid = stack.pop();
            res += mid * stack.peek();
        }

        return res;
    }
}
