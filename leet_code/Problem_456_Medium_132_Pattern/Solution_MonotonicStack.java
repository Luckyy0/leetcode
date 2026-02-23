package leet_code.Problem_456_Medium_132_Pattern;

import java.util.Stack;

public class Solution_MonotonicStack {

    /**
     * Finds if there is a 132 pattern in the array.
     * Strategy: Traverse backward using a monotonic stack to find the largest
     * potential "2" value.
     * Time: O(N), Space: O(N).
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int secondLargest = Integer.MIN_VALUE; // This is our "ak" or the "2" in "132"

        // Scan from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If we found a value smaller than our "2", and we already know there's a "3"
            // to its right
            // then we've found the "1" in "132".
            if (nums[i] < secondLargest)
                return true;

            // Maintain monotonic stack (decreasing from bottom to top)
            // If current element is larger than top, the top becomes our potential "2",
            // and the current element is our potential "3".
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                secondLargest = stack.pop();
            }

            // Push potential "3" or "2" candidates onto stack
            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_MonotonicStack solution = new Solution_MonotonicStack();
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 3, 1, 4, 2 };
        System.out.println("Result 1: " + solution.find132pattern(nums1)); // false
        System.out.println("Result 2: " + solution.find132pattern(nums2)); // true
    }
}
