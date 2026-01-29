package leetcode.P503_NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    /**
     * Problem 503: Next Greater Element II
     * Approach: Monotonic Stack with 2x array traversal
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>(); // Store indices

        // Traverse twice to handle circularity
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                res[stack.pop()] = nums[idx];
            }
            if (i < n) {
                stack.push(idx);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,2,1] -> [2,-1,2]
        System.out.println("Result 1: " + Arrays.toString(sol.nextGreaterElements(new int[] { 1, 2, 1 })));

        // [1,2,3,4,3] -> [2,3,4,-1,4]
        System.out.println("Result 2: " + Arrays.toString(sol.nextGreaterElements(new int[] { 1, 2, 3, 4, 3 })));
    }
}
