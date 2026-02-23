package leet_code.Problem_719_Hard_Find_K_th_Smallest_Pair_Distance;

import java.util.Arrays;

public class Solution {

    /**
     * Finds the k-th smallest pair distance.
     * Strategy: Binary Search on the Answer space [0, MaxDist] + Two Pointers.
     * Time: O(N log N + N log D), Space: O(1).
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Count pairs with distance <= mid
            if (countPairs(nums, mid) >= k) {
                // Too many or enough pairs, try a smaller distance
                right = mid;
            } else {
                // Not enough pairs, need a larger distance
                left = mid + 1;
            }
        }

        return left;
    }

    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // Sliding window: move 'left' until distance is within 'mid'
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            // Number of pairs ending at 'right' with distance <= mid
            count += (right - left);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 3, 1 };
        System.out.println("Result (k=1): " + sol.smallestDistancePair(nums1, 1)); // 0

        int[] nums2 = { 1, 6, 1 };
        System.out.println("Result (k=3): " + sol.smallestDistancePair(nums2, 3)); // 5
    }
}
