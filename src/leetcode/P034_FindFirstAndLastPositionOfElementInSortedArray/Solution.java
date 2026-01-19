package leetcode.P034_FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 34: Find First and Last Position of Element in Sorted Array
     * Approach: Two Binary Searches
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if (nums == null || nums.length == 0)
            return result;

        result[0] = findBound(nums, target, true);
        if (result[0] == -1) {
            // If starting position not found, ending position won't exist either
            return result;
        }

        result[1] = findBound(nums, target, false);
        return result;
    }

    /**
     * Helper to find the boundary index
     * 
     * @param isFirst: true to find first occurrence, false to find last
     */
    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;
        int index = -1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            if (nums[mid] == target) {
                index = mid;
                // If finding first, continue to left
                // Nếu tìm vị trí đầu, tiếp tục sang trái
                if (isFirst) {
                    end = mid - 1;
                } else {
                    // If finding last, continue to right
                    // Nếu tìm vị trí cuối, tiếp tục sang phải
                    begin = mid + 1;
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 5, 7, 7, 8, 8, 10 }, 8, new int[] { 3, 4 });
        runTest(solution, new int[] { 5, 7, 7, 8, 8, 10 }, 6, new int[] { -1, -1 });
        runTest(solution, new int[] {}, 0, new int[] { -1, -1 });
        runTest(solution, new int[] { 1 }, 1, new int[] { 0, 0 });
        runTest(solution, new int[] { 2, 2 }, 2, new int[] { 0, 1 });
    }

    private static void runTest(Solution s, int[] nums, int target, int[] expected) {
        System.out.println("Input: " + Arrays.toString(nums) + ", target = " + target);
        int[] result = s.searchRange(nums, target);
        System.out.println("Output: " + Arrays.toString(result) + " (Expected: " + Arrays.toString(expected) + ")");

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
