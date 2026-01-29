package leetcode.P1648_SellDiminishingValuedColoredBalls;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int MOD = 1_000_000_007;
        Arrays.sort(inventory);
        int n = inventory.length;
        long totalValue = 0;

        // Process from largest to smallest
        // Conceptually reverse: inventory[n-1] is max

        for (int i = n - 1; i >= 0; i--) {
            long currentVal = inventory[i];
            long nextVal = (i > 0) ? inventory[i - 1] : 0;
            long width = n - 1 - i + 1;

            long count = (currentVal - nextVal) * width;

            if (orders >= count) {
                // Sell everything down to nextVal
                long sum = (currentVal + nextVal + 1) * (currentVal - nextVal) / 2;
                totalValue = (totalValue + sum * width) % MOD;
                orders -= count;
            } else {
                // Partial sell
                long fullRows = orders / width;
                long remainder = orders % width;

                long valStop = currentVal - fullRows;
                long sum = (currentVal + valStop + 1) * fullRows / 2;
                totalValue = (totalValue + sum * width) % MOD;

                totalValue = (totalValue + remainder * valStop) % MOD;
                orders = 0;
            }

            if (orders == 0)
                break;
        }

        return (int) totalValue;
    }
}
