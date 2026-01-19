package leetcode.P035_SearchInsertPosition;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 35: Search Insert Position
     * Approach: Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // If not found, lo is the insertion point
        return lo;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 3, 5, 6 }, 5, 2);
        runTest(solution, new int[] { 1, 3, 5, 6 }, 2, 1);
        runTest(solution, new int[] { 1, 3, 5, 6 }, 7, 4);
        runTest(solution, new int[] { 1, 3, 5, 6 }, 0, 0);
        runTest(solution, new int[] { 1 }, 0, 0);
    }

    private static void runTest(Solution s, int[] nums, int target, int expected) {
        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        int result = s.searchInsert(nums, target);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
