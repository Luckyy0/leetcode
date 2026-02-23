package leet_code.Problem_714_Medium_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {

    /**
     * Finds the maximum profit with a transaction fee.
     * Strategy: DP with two states (Hold vs Free).
     * Time: O(N), Space: O(1).
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1)
            return 0;

        // Initial states for Day 0
        // hold: Profit after buying the first stock
        // free: Profit after selling (not possible on day 0, so 0)
        long hold = -prices[0];
        long free = 0;

        for (int i = 1; i < prices.length; i++) {
            long prevFree = free;

            // Transaction: Selling
            // We become 'free' if we sell what we 'hold' or stay 'free'.
            free = Math.max(free, hold + prices[i] - fee);

            // Transaction: Buying
            // We 'hold' a stock if we buy after being 'free' or stay 'hold'.
            hold = Math.max(hold, prevFree - prices[i]);
        }

        // Final profit must be the state where we don't hold any stock.
        return (int) free;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices1 = { 1, 3, 2, 8, 4, 9 };
        System.out.println("Result (fee=2): " + sol.maxProfit(prices1, 2)); // 8

        int[] prices2 = { 1, 3, 7, 5, 10, 3 };
        System.out.println("Result (fee=3): " + sol.maxProfit(prices2, 3)); // 6
    }
}
