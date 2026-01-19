package leetcode.P123_BestTimeToBuyAndSellStockIII;

public class Solution {

    /**
     * Problem 123: Best Time to Buy and Sell Stock III
     * Approach: State Machine DP
     * 
     * Theoretical Basis:
     * - At most 2 transactions allowed
     * - Track 4 states: buy1, sell1, buy2, sell2
     * - buy1 = max profit after first buy (negative, spent money)
     * - sell1 = max profit after first sell
     * - buy2 = max profit after second buy (build on sell1)
     * - sell2 = max profit after second sell (final answer)
     * 
     * Time Complexity: O(N) - single pass
     * Space Complexity: O(1) - only 4 variables
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize: impossible states start at -infinity
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            // Order matters: use previous day's values
            // First transaction
            buy1 = Math.max(buy1, -price); // Buy first stock
            sell1 = Math.max(sell1, buy1 + price); // Sell first stock

            // Second transaction (builds on first)
            buy2 = Math.max(buy2, sell1 - price); // Buy second stock
            sell2 = Math.max(sell2, buy2 + price); // Sell second stock
        }

        return sell2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [3,3,5,0,0,3,1,4] -> 6
        runTest(solution, new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }, 6);

        // Test 2: [1,2,3,4,5] -> 4
        runTest(solution, new int[] { 1, 2, 3, 4, 5 }, 4);

        // Test 3: [7,6,4,3,1] -> 0
        runTest(solution, new int[] { 7, 6, 4, 3, 1 }, 0);

        // Test 4: [1,2,4,2,5,7,2,4,9,0] -> 13 (buy@1,sell@7=6 + buy@2,sell@9=7)
        runTest(solution, new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }, 13);
    }

    private static void runTest(Solution s, int[] prices, int expected) {
        int result = s.maxProfit(prices);
        System.out.println("Prices length: " + prices.length);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
