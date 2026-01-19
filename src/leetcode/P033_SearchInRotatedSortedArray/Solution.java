package leetcode.P033_SearchInRotatedSortedArray;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 33: Search in Rotated Sorted Array
     * Approach: Modified Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            // Kiểm tra xem nửa bên trái có được sắp xếp không
            if (nums[lo] <= nums[mid]) {
                // Target is in the left sorted half
                // Target nằm trong nửa trái đã sắp xếp
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // Otherwise, the right half is sorted
            // Ngược lại, nửa bên phải được sắp xếp
            else {
                // Target is in the right sorted half
                // Target nằm trong nửa phải đã sắp xếp
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0, 4);
        runTest(solution, new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3, -1);
        runTest(solution, new int[] { 1 }, 0, -1);
        runTest(solution, new int[] { 3, 1 }, 1, 1);
        runTest(solution, new int[] { 5, 1, 3 }, 5, 0);
    }

    private static void runTest(Solution s, int[] nums, int target, int expected) {
        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        int result = s.search(nums, target);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
