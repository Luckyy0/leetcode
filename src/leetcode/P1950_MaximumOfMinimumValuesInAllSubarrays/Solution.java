package leetcode.P1950_MaximumOfMinimumValuesInAllSubarrays;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] findMaximums(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Prev Smaller
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int[] ans = new int[n];
        // Note: Default min value? Since nums >= 0, 0 is fine.

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            // len is 1-based length. index is len-1.
            if (len > 0) {
                ans[len - 1] = Math.max(ans[len - 1], nums[i]);
            }
        }

        // Propagate suffix max
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        return ans;
    }
}
