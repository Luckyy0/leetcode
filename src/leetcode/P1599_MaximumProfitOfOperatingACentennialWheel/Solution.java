package leetcode.P1599_MaximumProfitOfOperatingACentennialWheel;

public class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0;
        int currentProfit = 0;
        int maxProfit = -1;
        int bestRotation = -1;

        int rotation = 0;
        int n = customers.length;

        // Loop while we have new customers arriving OR waiting customers
        while (rotation < n || waiting > 0) {
            // Add new arrivals
            if (rotation < n) {
                waiting += customers[rotation];
            }

            // Board customers
            int board = Math.min(4, waiting);
            waiting -= board;

            // Calculate profit
            currentProfit += board * boardingCost - runningCost;
            rotation++;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                bestRotation = rotation;
            }
        }

        return maxProfit > 0 ? bestRotation : -1;
    }
}
