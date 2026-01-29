package leetcode.P1746_MaximumSubarraySumAfterOneOperation;

public class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        // dp0: max sum ending here without operation used yet
        // dp1: max sum ending here with operation used (either here or before)

        int dp0 = 0;
        int dp1 = 0;
        int max = Integer.MIN_VALUE;

        // Handle i=0 separately or initialize appropriately
        dp0 = nums[0];
        dp1 = nums[0] * nums[0];
        max = dp1;

        for (int i = 1; i < n; i++) {
            int val = nums[i];
            int prevDp0 = dp0;
            int prevDp1 = dp1;

            dp0 = Math.max(val, val + prevDp0);

            // For dp1:
            // 1. Operation at current i: val*val + max(0, prevDp0)
            // 2. Operation before: val + prevDp1
            dp1 = Math.max(val * val + Math.max(0, prevDp0), val + prevDp1);

            max = Math.max(max, dp1);
        }

        return max;
    }
}
