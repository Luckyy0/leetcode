package leetcode.P456_132Pattern;

import java.util.Stack;

public class Solution {

    /**
     * Problem 456: 132 Pattern
     * Approach: Monotonic Stack (Scanning Right to Left)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int num3 = Integer.MIN_VALUE; // Represents the '2' in '132'

        // Scan from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Found a 132 pattern if current nums[i] < num3
            // num3 is guaranteed to be smaller than some value on its left (from stack)
            if (nums[i] < num3) {
                return true;
            }

            // Maintain monotonic stack (decreasing from bottom to top)
            // If we find a larger value, it becomes a potential '3' (nums[j])
            // and the top of the stack becomes a potential '2' (nums[k])
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                num3 = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,2,3,4] -> false
        runTest(sol, new int[] { 1, 2, 3, 4 }, false);

        // [3,1,4,2] -> true
        runTest(sol, new int[] { 3, 1, 4, 2 }, true);

        // [-1,3,2,0] -> true
        runTest(sol, new int[] { -1, 3, 2, 0 }, true);
    }

    private static void runTest(Solution sol, int[] nums, boolean expected) {
        boolean result = sol.find132pattern(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
