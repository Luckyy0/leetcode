package leetcode.P1883_MinimumSkipsToArriveAtMeetingOnTime;

import java.util.Arrays;

public class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        // dp[j] = min scaled time with j skips
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2); // Avoid overflow
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            long d = dist[i];
            for (int j = n; j >= 0; j--) {
                // Option 1: Don't skip (wait).
                // Must arrive from road i-1 with j skips.
                // Wait until ceil.
                long timeWAIT = Long.MAX_VALUE / 2;
                if (dp[j] < Long.MAX_VALUE / 2) {
                    timeWAIT = ((dp[j] + speed - 1) / speed) * speed + d;
                }

                // Option 2: Skip.
                // Must arrive from road i-1 with j-1 skips.
                long timeSKIP = Long.MAX_VALUE / 2;
                if (j > 0 && dp[j - 1] < Long.MAX_VALUE / 2) {
                    timeSKIP = dp[j - 1] + d;
                }

                dp[j] = Math.min(timeWAIT, timeSKIP);
            }
        }

        for (int j = 0; j <= n; j++) {
            if (dp[j] <= (long) hoursBefore * speed) {
                return j;
            }
        }

        return -1;
    }
}
