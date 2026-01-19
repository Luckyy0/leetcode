package leetcode.P259_3SumSmaller;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 259: 3Sum Smaller
     * Approach: Sorting + Two Pointers
     * 
     * Theoretical Basis:
     * - Fix first element. Two ptrs for remaining.
     * - If sum < target, all elements between left and right work with left.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    // Valid triplet found with (i, left, right).
                    // Also valid for (i, left, right-1), ..., (i, left, left+1).
                    // Total valid pairs for this 'left': (right - left)
                    count += (right - left);

                    // Try next left to see if we can still include it
                    left++;
                } else {
                    // Start sum too big, reduce it
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [-2,0,1,3], target=2 -> 2
        runTest(solution, new int[] { -2, 0, 1, 3 }, 2, 2);

        // [], target=0 -> 0
        runTest(solution, new int[] {}, 0, 0);

        // [1, 1, 1], target=0 -> 0
        runTest(solution, new int[] { 1, 1, 1 }, 0, 0);
    }

    private static void runTest(Solution s, int[] nums, int target, int expected) {
        int result = s.threeSumSmaller(nums, target);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
