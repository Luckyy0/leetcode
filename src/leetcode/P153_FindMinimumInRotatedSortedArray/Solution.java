package leetcode.P153_FindMinimumInRotatedSortedArray;

public class Solution {

    /**
     * Problem 153: Find Minimum in Rotated Sorted Array
     * Approach: Binary Search
     * 
     * Theoretical Basis:
     * - In a rotated sorted array, there's a point where nums[i] < nums[i-1].
     * - We compare nums[mid] with nums[right] to decide which half to discard.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element,
            // the min is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the min is in the left half (including mid)
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        runTest(solution, new int[] { 3, 4, 5, 1, 2 }, 1);
        runTest(solution, new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
        runTest(solution, new int[] { 11, 13, 15, 17 }, 11);
        runTest(solution, new int[] { 2, 1 }, 1);
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
