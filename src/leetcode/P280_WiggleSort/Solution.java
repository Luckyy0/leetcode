package leetcode.P280_WiggleSort;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 280: Wiggle Sort
     * Approach: Greedy Swap
     * 
     * Theoretical Basis:
     * - Ensure local wiggling property at each step.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                // Expect nums[i] <= nums[i+1]
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                // Expect nums[i] >= nums[i+1]
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,5,2,1,6,4] -> Check wiggle
        int[] nums1 = { 3, 5, 2, 1, 6, 4 };
        solution.wiggleSort(nums1);
        System.out.println("Result 1: " + Arrays.toString(nums1));
        checkWiggle(nums1);

        // [6,6,5,6,3,8]
        int[] nums2 = { 6, 6, 5, 6, 3, 8 };
        solution.wiggleSort(nums2);
        System.out.println("Result 2: " + Arrays.toString(nums2));
        checkWiggle(nums2);
    }

    private static void checkWiggle(int[] nums) {
        boolean valid = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1])
                    valid = false;
            } else {
                if (nums[i] < nums[i + 1])
                    valid = false;
            }
        }
        if (valid)
            System.out.println("PASS");
        else
            System.out.println("FAIL");
        System.out.println("-----------------");
    }
}
