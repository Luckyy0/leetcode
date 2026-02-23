package leet_code.Problem_704_Easy_Binary_Search;

public class Solution {

    /**
     * Searches for target in a sorted array using Binary Search.
     * Time: O(log N), Space: O(1).
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevention of integer overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        System.out.println("Result (target=9): " + sol.search(nums1, 9)); // 4
        System.out.println("Result (target=2): " + sol.search(nums1, 2)); // -1
    }
}
