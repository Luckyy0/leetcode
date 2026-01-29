package leetcode.P2144_MinimumCostOfBuyingCandiesWithDiscount;

import java.util.Arrays;

public class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int total = 0;

        // Iterate backwards. Buy i, i-1. Skip i-2.
        for (int i = n - 1; i >= 0; i--) {
            total += cost[i];
            i--;
            if (i >= 0)
                total += cost[i];
            i--; // Skip free candy
        }

        return total;
    }
}
