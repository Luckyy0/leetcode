package leetcode.P309_BestTimeToBuyAndSellStockWithCooldown;

public class Solution {

    /**
     * Problem 309: Best Time to Buy and Sell Stock with Cooldown
     * Approach: Dynamic Programming (State Machine)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        // Initial states
        // held: max profit if holding stock (implies we bought)
        // sold: max profit if just sold stock
        // rest: max profit if doing nothing (cooldown or idling)

        int held = -prices[0];
        int sold = Integer.MIN_VALUE;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHeld = held;
            int prevSold = sold;
            int prevRest = rest;

            // Updates
            held = Math.max(prevHeld, prevRest - prices[i]);
            sold = prevHeld + prices[i];
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,0,2] -> 3
        runTest(solution, new int[] { 1, 2, 3, 0, 2 }, 3);

        // [1] -> 0
        runTest(solution, new int[] { 1 }, 0);
    }

    private static void runTest(Solution s, int[] prices, int expected) {
        int result = s.maxProfit(prices);
        java.util.Arrays.toString(prices);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
