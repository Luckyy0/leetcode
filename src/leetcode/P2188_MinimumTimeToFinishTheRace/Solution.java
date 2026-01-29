package leetcode.P2188_MinimumTimeToFinishTheRace;

import java.util.Arrays;

public class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int MAX_LAPS = 20; // Enough since r >= 2, 2^18 is large
        long[] minCost = new long[MAX_LAPS + 1];
        Arrays.fill(minCost, Long.MAX_VALUE);

        for (int[] tire : tires) {
            long f = tire[0];
            long r = tire[1];
            long currentLapTime = f;
            long totalTime = 0;

            for (int i = 1; i <= MAX_LAPS; i++) {
                totalTime += currentLapTime;
                if (totalTime >= Integer.MAX_VALUE)
                    break; // Overflow guard, though changeTime is int so we can stop earlier

                minCost[i] = Math.min(minCost[i], totalTime);

                currentLapTime *= r;
                // Optimization pruning
                if (currentLapTime > changeTime + f && i > 1) {
                    // If one lap takes longer than changing + 1 lap on new tire, stop
                    // Actually logic is roughly 2e5?
                    // Let's rely on MAX_LAPS constant.
                }
                if (currentLapTime > 200000 && r >= 2)
                    break; // 10^5 changeTime + 10^5 f
            }
        }

        long[] dp = new long[numLaps + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= numLaps; i++) {
            // Try last stint of length j
            for (int j = 1; j <= MAX_LAPS && i - j >= 0; j++) {
                if (minCost[j] == Long.MAX_VALUE)
                    continue;

                long prevTime = dp[i - j];
                long transition = (i == j) ? 0 : changeTime;
                // If i==j, we started with this stint, no change time.
                // If i > j, we changed tires before this stint.

                dp[i] = Math.min(dp[i], prevTime + transition + minCost[j]);
            }
        }

        return (int) dp[numLaps];
    }
}
