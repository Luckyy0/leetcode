package leetcode.P080_RemoveDuplicatesFromSortedArrayII;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 80: Remove Duplicates from Sorted Array II
     * Approach: Two Pointers
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            // Keep if first 2 elements OR n is different from the element 2 positions back
            // Since array is sorted, n > nums[i-2] guarantees it's not the 3rd duplicate
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 1, 1, 2, 2, 3 }, new int[] { 1, 1, 2, 2, 3 });
        runTest(solution, new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }, new int[] { 0, 0, 1, 1, 2, 3, 3 });
    }

    private static void runTest(Solution s, int[] nums, int[] expected) {
        System.out.println("Input: " + Arrays.toString(nums));
        int k = s.removeDuplicates(nums);

        int[] result = Arrays.copyOf(nums, k);
        System.out.println("Output main k: " + k + ", content: " + Arrays.toString(result) + " (Expected: "
                + Arrays.toString(expected) + ")");

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
