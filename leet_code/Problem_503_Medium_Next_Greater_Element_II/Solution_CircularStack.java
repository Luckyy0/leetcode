package leet_code.Problem_503_Medium_Next_Greater_Element_II;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_CircularStack {

    /**
     * Finds the next greater element in a circular array.
     * Strategy: Iterate 2*n times using modulo n. Use monotonic stack to store
     * indices.
     * Time: O(N), Space: O(N).
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Stack stores indices of elements for which we haven't found the next greater
        // element yet
        Deque<Integer> stack = new ArrayDeque<>();

        // Loop twice to simulate circular array
        for (int i = 0; i < 2 * n; i++) {
            int currentVal = nums[i % n];

            // While we found a greater element for indices in stack
            while (!stack.isEmpty() && nums[stack.peek()] < currentVal) {
                result[stack.pop()] = currentVal;
            }

            // Only push indices from the first pass (0 to n-1)
            // We want to find answers for these indices.
            // Indices from second pass are only used to resolve answers, not to be resolved
            // themselves.
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_CircularStack solution = new Solution_CircularStack();
        int[] nums = { 1, 2, 1 };
        int[] res = solution.nextGreaterElements(nums);
        System.out.print("Result: ");
        for (int val : res)
            System.out.print(val + " "); // 2 -1 2
    }
}
