package leetcode.P188_BestTimeToBuyAndSellStockIV;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 188: Best Time to Buy and Sell Stock IV
     * Approach: Dynamic Programming with state optimization
     * 
     * Theoretical Basis:
     * - We track the maximum money we have when 'buying' (holding) or 'selling'
     * (not holding)
     * for each transaction count 1..k.
     * - If k is large (k >= n/2), we can perform as many transactions as we want.
     * 
     * Time Complexity: O(N * k)
     * Space Complexity: O(k)
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2 || k <= 0) {
            return 0;
        }

        // Optimization: If k is large, treat as unlimited transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // dp arrays
        // buy[j] is the max money we have after buying the j-th stock
        // sell[j] is the max money we have after selling the j-th stock
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                // Buy j-th stock: either we stayed "bought" from before, or we just bought
                // after selling (j-1)-th
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                // Sell j-th stock: either we stayed "sold" from before, or we just sold the
                // j-th stock we were holding
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }

        return sell[k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int k1 = 2;
        int[] p1 = { 2, 4, 1 };
        System.out.println("Test 1: " + solution.maxProfit(k1, p1)); // Expected: 2 (Buy 2, Sell 4)

        // Example 2
        int k2 = 2;
        int[] p2 = { 3, 2, 6, 5, 0, 3 };
        System.out.println("Test 2: " + solution.maxProfit(k2, p2)); // Expected: 7 (2->6 and 0->3)
    }
}
