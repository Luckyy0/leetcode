package leetcode.P1547_MinimumCostToCutAStick;

import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] sortedCuts = new int[m + 2];
        for (int i = 0; i < m; i++)
            sortedCuts[i + 1] = cuts[i];
        sortedCuts[0] = 0;
        sortedCuts[m + 1] = n;
        Arrays.sort(sortedCuts);

        int numPoints = sortedCuts.length;
        int[][] dp = new int[numPoints][numPoints];

        for (int len = 2; len < numPoints; len++) {
            for (int i = 0; i < numPoints - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (sortedCuts[j] - sortedCuts[i]));
                }
            }
        }

        return dp[0][numPoints - 1];
    }
}
