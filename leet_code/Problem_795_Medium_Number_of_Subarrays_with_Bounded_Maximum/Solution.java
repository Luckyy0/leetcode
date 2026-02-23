package leet_code.Problem_795_Medium_Number_of_Subarrays_with_Bounded_Maximum;

public class Solution {

    /**
     * Counts subarrays with max in range [left, right].
     * Strategy: Single pass maintaining window start for elements <= right.
     * If element >= left, it resets the 'valid count' ending at current index.
     * Time: O(N), Space: O(1).
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1; // Index before the current valid window (containing elements <= right)
        int lastCount = 0; // Number of valid subarrays ending at the previous index
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                // Element breaks the condition (max > right).
                // Reset window.
                start = i;
                lastCount = 0;
            } else if (nums[i] >= left) {
                // Element is valid peak (in [left, right]).
                // All subarrays ending here and starting after 'start' are valid.
                // Count = (i - start).
                lastCount = i - start;
                total += lastCount;
            } else {
                // Element is small (< left).
                // It can only extend existing valid subarrays from the left.
                // It cannot start a new valid subarray on its own (since max would be < left).
                // So the number of valid subarrays ending here is the same as previous step.
                total += lastCount;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 2, 1, 4, 3 };
        System.out.println("Result 1: " + sol.numSubarrayBoundedMax(nums1, 2, 3)); // 3

        int[] nums2 = { 2, 9, 2, 5, 6 };
        System.out.println("Result 2: " + sol.numSubarrayBoundedMax(nums2, 2, 8)); // 7
    }
}
