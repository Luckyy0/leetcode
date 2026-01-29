package leetcode.P1473_PaintHouseIII;

import java.util.Arrays;

class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n + 1][target + 1];
        for (int[][] row : dp) {
            for (int[] r : row) {
                Arrays.fill(r, -1);
            }
        }

        int res = dfs(0, 0, 0, houses, cost, m, n, target, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // prevColor: 0 if none. target: remaining neighborhoods to form
    // Actually simpler to track current count, but target countdown is fine too?
    // Let's track formed neighborhoods.
    // dfs(idx, prevColor, formedGroups)

    private int dfs(int idx, int prevColor, int formedGroups, int[] houses, int[][] cost, int m, int n, int target,
            int[][][] dp) {
        if (formedGroups > target)
            return Integer.MAX_VALUE;
        if (idx == m) {
            return formedGroups == target ? 0 : Integer.MAX_VALUE;
        }

        if (dp[idx][prevColor][formedGroups] != -1) {
            return dp[idx][prevColor][formedGroups];
        }

        int minCost = Integer.MAX_VALUE;

        if (houses[idx] != 0) {
            // Already painted
            int currentColor = houses[idx];
            int newGroups = formedGroups + (currentColor != prevColor ? 1 : 0);
            minCost = dfs(idx + 1, currentColor, newGroups, houses, cost, m, n, target, dp);
        } else {
            // Try painting
            for (int c = 1; c <= n; c++) {
                int newGroups = formedGroups + (c != prevColor ? 1 : 0);
                int res = dfs(idx + 1, c, newGroups, houses, cost, m, n, target, dp);
                if (res != Integer.MAX_VALUE) {
                    minCost = Math.min(minCost, res + cost[idx][c - 1]);
                }
            }
        }

        return dp[idx][prevColor][formedGroups] = minCost;
    }
}
