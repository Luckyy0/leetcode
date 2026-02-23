package leet_code.Problem_724_Easy_Find_Pivot_Index;

public class Solution {

    /**
     * Finds the leftmost pivot index where left sum equals right sum.
     * Strategy: Single pass with Total Sum and Running Prefix Sum.
     * Time: O(N), Space: O(1).
     */
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Right sum = total - left - current_element
            if (leftSum == (totalSum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 7, 3, 6, 5, 6 };
        System.out.println("Result 1: " + sol.pivotIndex(nums1)); // 3

        int[] nums2 = { 1, 2, 3 };
        System.out.println("Result 2: " + sol.pivotIndex(nums2)); // -1
    }
}
