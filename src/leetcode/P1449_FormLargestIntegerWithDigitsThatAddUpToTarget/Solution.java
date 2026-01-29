package leetcode.P1449_FormLargestIntegerWithDigitsThatAddUpToTarget;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int d = 1; d <= 9; d++) {
                int c = cost[d - 1];
                if (i >= c && dp[i - c] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - c] + 1);
                }
            }
        }

        if (dp[target] < 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        int curr = target;
        while (curr > 0) {
            for (int d = 9; d >= 1; d--) {
                int c = cost[d - 1];
                if (curr >= c && dp[curr] == dp[curr - c] + 1) {
                    sb.append(d);
                    curr -= c;
                    break;
                }
            }
        }

        return sb.toString();
    }
}
