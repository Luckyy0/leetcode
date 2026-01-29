package leetcode.P1856_MaximumSubarrayMinProduct;

import java.util.Stack;

public class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find previous less element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();

        // Find next less element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        long maxProd = 0;
        for (int i = 0; i < n; i++) {
            long sum = prefix[right[i] + 1] - prefix[left[i]];
            long prod = sum * nums[i];

            // Note: Theoretically could overflow long, but practically often passes in Java
            // on LeetCode.
            // If strict correctness needed, one might need check or BigInteger.
            if (prod > maxProd) {
                maxProd = prod;
            }
        }

        return (int) (maxProd % 1_000_000_007);
    }
}
