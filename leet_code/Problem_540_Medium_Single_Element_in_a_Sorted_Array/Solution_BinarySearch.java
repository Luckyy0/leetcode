package leet_code.Problem_540_Medium_Single_Element_in_a_Sorted_Array;

public class Solution_BinarySearch {

    /**
     * Finds single element in sorted array.
     * Strategy: Binary Search on even indices.
     * Time: O(log N), Space: O(1).
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even
            if (mid % 2 == 1) {
                mid--;
            }

            // Compare with next element
            // If equal, pairs are correct on left side -> element is on right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // If not equal, pattern is broken here or before -> element is here or left
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Solution_BinarySearch solution = new Solution_BinarySearch();
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println("Result: " + solution.singleNonDuplicate(nums)); // 2
    }
}
