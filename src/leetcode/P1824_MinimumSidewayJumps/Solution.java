package leetcode.P1824_MinimumSidewayJumps;

import java.util.Arrays;

public class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length - 1;
        int[] dp = new int[] { 0, 1, 0, 1 }; // padding, lane 1, 2, 3
        int INF = 1_000_000;

        for (int i = 1; i <= n; i++) {
            // Move forward
            if (obstacles[i] != 0) {
                dp[obstacles[i]] = INF;
            }

            // Side jumps
            int minJumps = INF;
            for (int l = 1; l <= 3; l++) {
                if (obstacles[i] != l) {
                    minJumps = Math.min(minJumps, dp[l]);
                }
            }

            for (int l = 1; l <= 3; l++) {
                if (obstacles[i] != l) {
                    dp[l] = Math.min(dp[l], minJumps + 1);
                }
            }
        }

        return Math.min(dp[1], Math.min(dp[2], dp[3]));
    }
}
