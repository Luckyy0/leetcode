package leetcode.P1063_NumberOfValidSubarrays;

import java.util.Stack;

class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Find next smaller element for elements in stack
            // If current element < stack.peek(), then stack.peek()'s range ends here.
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                count += i - stack.pop();
            }
            stack.push(i);
        }

        // Remaining elements extend to end of array
        while (!stack.isEmpty()) {
            count += n - stack.pop();
        }

        return count;
    }
}
