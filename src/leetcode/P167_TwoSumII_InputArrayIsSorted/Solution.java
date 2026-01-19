package leetcode.P167_TwoSumII_InputArrayIsSorted;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 167: Two Sum II - Input Array Is Sorted
     * Approach: Two Pointers
     * 
     * Theoretical Basis:
     * - Use left and right pointers at the ends of the sorted array.
     * - Adjust pointers based on current sum vs target.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // Returns 1-indexed results
                return new int[] { left + 1, right + 1 };
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Exact solution guaranteed, so this path is technically unreachable.
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [2,7,11,15], target 9 -> [1, 2]
        runTest(solution, new int[] { 2, 7, 11, 15 }, 9, new int[] { 1, 2 });

        // [2,3,4], target 6 -> [1, 3]
        runTest(solution, new int[] { 2, 3, 4 }, 6, new int[] { 1, 3 });

        // [-1,0], target -1 -> [1, 2]
        runTest(solution, new int[] { -1, 0 }, -1, new int[] { 1, 2 });
    }

    private static void runTest(Solution s, int[] nums, int target, int[] expected) {
        int[] result = s.twoSum(nums, target);
        System.out.println("Input: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Output: " + Arrays.toString(result) + " (Expected: " + Arrays.toString(expected) + ")");

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
