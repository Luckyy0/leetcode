package leetcode.P2087_MinimumCostHomecomingOfARobotInAGrid;

public class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int r1 = startPos[0];
        int c1 = startPos[1];
        int r2 = homePos[0];
        int c2 = homePos[1];

        int cost = 0;

        // Sum row costs
        if (r1 < r2) {
            for (int r = r1 + 1; r <= r2; r++)
                cost += rowCosts[r];
        } else {
            for (int r = r1 - 1; r >= r2; r--)
                cost += rowCosts[r];
        }

        // Sum col costs
        if (c1 < c2) {
            for (int c = c1 + 1; c <= c2; c++)
                cost += colCosts[c];
        } else {
            for (int c = c1 - 1; c >= c2; c--)
                cost += colCosts[c];
        }

        return cost;
    }
}
