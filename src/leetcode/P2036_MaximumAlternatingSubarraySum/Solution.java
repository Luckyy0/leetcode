package leetcode.P2036_MaximumAlternatingSubarraySum;

public class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long dp0 = nums[0]; // Ends with +
        long dp1 = Integer.MIN_VALUE; // Ends with -
        long max = dp0;

        for (int i = 1; i < nums.length; i++) {
            long nextDp0 = Math.max(nums[i], dp1 + nums[i]);
            long nextDp1 = dp0 - nums[i];

            dp0 = nextDp0;
            dp1 = nextDp1;

            max = Math.max(max, Math.max(dp0, dp1));
        }

        return max;
    }
}
