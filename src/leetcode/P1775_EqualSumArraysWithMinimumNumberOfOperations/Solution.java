package leetcode.P1775_EqualSumArraysWithMinimumNumberOfOperations;

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        for (int n : nums1)
            sum1 += n;
        int sum2 = 0;
        for (int n : nums2)
            sum2 += n;

        if (sum1 == sum2)
            return 0;
        if (sum1 > sum2)
            return minOperations(nums2, nums1); // Ensure sum1 < sum2

        int diff = sum2 - sum1;
        int[] gains = new int[6]; // Gains 0 to 5. 6 not possible (1->7 impossible). 1->6 is gain 5.

        // Increase nums1 (val -> 6 gains 6-val)
        for (int n : nums1) {
            gains[6 - n]++;
        }

        // Decrease nums2 (val -> 1 gains val-1)
        for (int n : nums2) {
            gains[n - 1]++;
        }

        int ops = 0;
        for (int g = 5; g >= 1; g--) {
            int count = gains[g];
            int take = Math.min(count, (diff + g - 1) / g); // Ceiling div diff/g
            ops += take;
            diff -= take * g;
            if (diff <= 0)
                return ops;
        }

        return -1;
    }
}
