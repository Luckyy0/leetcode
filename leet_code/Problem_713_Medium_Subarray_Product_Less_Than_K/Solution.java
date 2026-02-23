package leet_code.Problem_713_Medium_Subarray_Product_Less_Than_K;

public class Solution {

    /**
     * Counts subarrays with product strictly less than k.
     * Strategy: Sliding Window (Two Pointers).
     * Time: O(N), Space: O(1).
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Since elements are >= 1, product cannot be < 1.
        if (k <= 1)
            return 0;

        int count = 0;
        int prod = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand the window
            prod *= nums[right];

            // Shrink the window if product exceeds or equals k
            while (prod >= k && left <= right) {
                prod /= nums[left];
                left++;
            }

            // All subarrays ending at 'right' and starting at or after 'left' are valid.
            // The number of such subarrays is exactly the current window size.
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 10, 5, 2, 6 };
        System.out.println("Result (100): " + sol.numSubarrayProductLessThanK(nums1, 100)); // 8

        int[] nums2 = { 1, 2, 3 };
        System.out.println("Result (0): " + sol.numSubarrayProductLessThanK(nums2, 0)); // 0
    }
}
