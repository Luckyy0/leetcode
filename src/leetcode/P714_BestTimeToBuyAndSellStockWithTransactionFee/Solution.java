package leetcode.P714_BestTimeToBuyAndSellStockWithTransactionFee;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2)
            return 0;

        // cash: maximum profit if we don't hold stock
        // hold: maximum profit if we hold stock
        long cash = 0;
        long hold = -prices[0];

        for (int i = 1; i < n; i++) {
            long prevCash = cash;
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, prevCash - prices[i]);
        }

        return (int) cash;
    }
}
