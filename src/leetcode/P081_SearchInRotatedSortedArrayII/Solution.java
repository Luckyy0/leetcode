package leetcode.P081_SearchInRotatedSortedArrayII;

public class Solution {

    /**
     * Problem 81: Search in Rotated Sorted Array II
     * Approach: Modified Binary Search (Handle Duplicates)
     * Time Complexity: Average O(log N), Worst O(N)
     * Space Complexity: O(1)
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: if lo, mid, and hi are equal, we can't determine sorted
            // half
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                lo++;
                hi--;
                continue;
            }

            // Check if left half is sorted
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // Right half must be sorted
            else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0, true);
        runTest(solution, new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3, false);
        runTest(solution, new int[] { 1, 0, 1, 1, 1 }, 0, true);
        runTest(solution, new int[] { 1, 1, 1, 0, 1 }, 0, true);
    }

    private static void runTest(Solution s, int[] nums, int target, boolean expected) {
        System.out.println("Input array length: " + nums.length + ", Target: " + target);
        boolean result = s.search(nums, target);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
