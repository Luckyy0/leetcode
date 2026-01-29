package leetcode.P1262_GreatestSumDivisibleByThree;

import java.util.Arrays;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[] { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };

        for (int x : nums) {
            int[] nextDp = Arrays.copyOf(dp, 3);
            for (int i = 0; i < 3; i++) {
                if (dp[i] != Integer.MIN_VALUE) {
                    int sum = dp[i] + x;
                    int rem = sum % 3;
                    nextDp[rem] = Math.max(nextDp[rem], sum);
                }
            }
            dp = nextDp;
        }

        return dp[0];
    }
}
