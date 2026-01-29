package leetcode.P1066_CampusBikesII;

import java.util.Arrays;

class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[] dp = new int[1 << m];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        int minSum = Integer.MAX_VALUE;

        // Iterate through all masks
        // Optimization: iterate masks by number of set bits? Or just loop 0 to 2^m.
        // Worker determined by number of set bits.
        for (int mask = 0; mask < (1 << m); mask++) {
            if (dp[mask] >= Integer.MAX_VALUE / 2)
                continue;

            int workerIdx = Integer.bitCount(mask);
            if (workerIdx >= n) {
                minSum = Math.min(minSum, dp[mask]);
                continue;
            }

            for (int j = 0; j < m; j++) {
                if ((mask & (1 << j)) == 0) {
                    int nextMask = mask | (1 << j);
                    int dist = Math.abs(workers[workerIdx][0] - bikes[j][0])
                            + Math.abs(workers[workerIdx][1] - bikes[j][1]);
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + dist);
                }
            }
        }

        return minSum;
    }
}
