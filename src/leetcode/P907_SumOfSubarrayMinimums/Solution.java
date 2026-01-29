package leetcode.P907_SumOfSubarrayMinimums;

import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1_000_000_007;
        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> stack = new Stack<>();

        // Next smaller to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();

        // Next smaller to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            right[i] = (stack.isEmpty() ? n : stack.peek()) - i;
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + arr[i] * left[i] * right[i]) % mod;
        }
        return (int) res;
    }
}
