package leetcode.P1595_MinimumCostToConnectTwoGroupsOfPoints;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int size1 = cost.size();
        int size2 = cost.get(0).size();

        // min costs for each column in group 2
        int[] minColCost = new int[size2];
        Arrays.fill(minColCost, Integer.MAX_VALUE);
        for (int j = 0; j < size2; j++) {
            for (int i = 0; i < size1; i++) {
                minColCost[j] = Math.min(minColCost[j], cost.get(i).get(j));
            }
        }

        int limit = 1 << size2;
        int[] dp = new int[limit];
        Arrays.fill(dp, Integer.MAX_VALUE / 2); // Avoid overflow
        dp[0] = 0;

        for (int i = 0; i < size1; i++) {
            int[] nextDP = new int[limit];
            Arrays.fill(nextDP, Integer.MAX_VALUE / 2);

            for (int mask = 0; mask < limit; mask++) {
                // If the previous state is unreachable, skip
                if (dp[mask] >= Integer.MAX_VALUE / 2)
                    continue;

                // Try connecting point i to each point j in group 2
                for (int j = 0; j < size2; j++) {
                    int nextMask = mask | (1 << j);
                    nextDP[nextMask] = Math.min(nextDP[nextMask], dp[mask] + cost.get(i).get(j));
                }
            }
            dp = nextDP;
        }

        int result = Integer.MAX_VALUE;
        for (int mask = 0; mask < limit; mask++) {
            if (dp[mask] >= Integer.MAX_VALUE / 2)
                continue;

            int currentCost = dp[mask];
            // Add costs for uncovered nodes in group 2
            for (int j = 0; j < size2; j++) {
                if ((mask & (1 << j)) == 0) {
                    currentCost += minColCost[j];
                }
            }
            result = Math.min(result, currentCost);
        }

        return result;
    }
}
