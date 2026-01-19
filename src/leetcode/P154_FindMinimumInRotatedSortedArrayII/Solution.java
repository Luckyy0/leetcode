package leetcode.P154_FindMinimumInRotatedSortedArrayII;

public class Solution {

    /**
     * Problem 154: Find Minimum in Rotated Sorted Array II
     * Approach: Binary Search with duplicate handling
     * 
     * Theoretical Basis:
     * - Same logic as P153, but with duplicates.
     * - If nums[mid] == nums[right], we can't decide, so we decrement right.
     * 
     * Time Complexity: O(log N) average, O(N) worst case.
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // When they are equal, we don't know the side,
                // but we know it's safe to ignore the current right.
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        runTest(solution, new int[] { 1, 3, 5 }, 1);
        runTest(solution, new int[] { 2, 2, 2, 0, 1 }, 0);
        runTest(solution, new int[] { 3, 3, 1, 3 }, 1);
        runTest(solution, new int[] { 10, 1, 10, 10, 10 }, 1);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.findMin(nums);
        System.out.print("Input: [");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + (i == nums.length - 1 ? "" : ","));
        System.out.println("]");
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
