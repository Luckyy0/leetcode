package leetcode.P122_BestTimeToBuyAndSellStockII;

public class Solution {

    /**
     * Problem 122: Best Time to Buy and Sell Stock II
     * Approach: Greedy - Sum of Positive Differences
     * 
     * Theoretical Basis:
     * - Unlimited transactions allowed (no transaction fee)
     * - Optimal strategy: collect every positive difference between consecutive
     * days
     * - Any upward trend can be decomposed into daily gains
     * - sell(j) - buy(i) = sum of (prices[k] - prices[k-1]) for k = i+1 to j
     * 
     * Time Complexity: O(N) - single pass
     * Space Complexity: O(1) - only one variable
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If today's price is higher than yesterday's, collect the gain
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [7,1,5,3,6,4] -> 7
        runTest(solution, new int[] { 7, 1, 5, 3, 6, 4 }, 7);

        // Test 2: [1,2,3,4,5] -> 4
        runTest(solution, new int[] { 1, 2, 3, 4, 5 }, 4);

        // Test 3: [7,6,4,3,1] -> 0
        runTest(solution, new int[] { 7, 6, 4, 3, 1 }, 0);
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
