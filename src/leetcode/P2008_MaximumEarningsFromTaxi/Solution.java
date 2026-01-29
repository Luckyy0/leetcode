package leetcode.P2008_MaximumEarningsFromTaxi;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] ridesByEnd = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            ridesByEnd[i] = new ArrayList<>();

        for (int[] r : rides) {
            ridesByEnd[r[1]].add(r);
        }

        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Option to do nothing at i

            for (int[] ride : ridesByEnd[i]) {
                int start = ride[0];
                int end = ride[1];
                int tip = ride[2];
                long profit = (end - start + tip);

                dp[i] = Math.max(dp[i], dp[start] + profit);
            }
        }

        return dp[n];
    }
}
