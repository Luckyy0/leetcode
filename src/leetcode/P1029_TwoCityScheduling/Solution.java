package leetcode.P1029_TwoCityScheduling;

import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int n = costs.length / 2;
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0]; // First n go to A
        }
        for (int i = n; i < 2 * n; i++) {
            totalCost += costs[i][1]; // Rest go to B
        }

        return totalCost;
    }
}
