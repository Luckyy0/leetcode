package leetcode.P075_SortColors;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 75: Sort Colors
     * Approach: Dutch National Flag (One Pass, O(1) space)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                // nums[mid] == 2
                swap(nums, mid, high);
                high--;
                // Do not increment mid, check the swapped value again
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

        int[] a1 = { 2, 0, 2, 1, 1, 0 };
        runTest(solution, a1, new int[] { 0, 0, 1, 1, 2, 2 });

        int[] a2 = { 2, 0, 1 };
        runTest(solution, a2, new int[] { 0, 1, 2 });

        int[] a3 = { 0 };
        runTest(solution, a3, new int[] { 0 });

        int[] a4 = { 1 };
        runTest(solution, a4, new int[] { 1 });
    }

    private static void runTest(Solution s, int[] nums, int[] expected) {
        System.out.println("Input: " + Arrays.toString(nums));
        s.sortColors(nums);
        System.out.println("Output: " + Arrays.toString(nums) + " (Expected: " + Arrays.toString(expected) + ")");

        if (Arrays.equals(nums, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
