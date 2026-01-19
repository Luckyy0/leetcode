package leetcode.P283_MoveZeroes;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 283: Move Zeroes
     * Approach: Two Pointers
     * 
     * Theoretical Basis:
     * - Partition array into [Non-Zeros] | [Zeros]
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap current non-zero to position 'lastNonZeroFoundAt'
                if (i != lastNonZeroFoundAt) {
                    int temp = nums[lastNonZeroFoundAt];
                    nums[lastNonZeroFoundAt] = nums[i];
                    nums[i] = temp;
                }
                lastNonZeroFoundAt++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [0,1,0,3,12] -> [1,3,12,0,0]
        int[] nums1 = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums1);
        System.out.println("Result 1: " + Arrays.toString(nums1));

        // [0] -> [0]
        int[] nums2 = { 0 };
        solution.moveZeroes(nums2);
        System.out.println("Result 2: " + Arrays.toString(nums2));
    }
}
