package leetcode.P121_BestTimeToBuyAndSellStock;

public class Solution {

    /**
     * Problem 121: Best Time to Buy and Sell Stock
     * Approach: One-Pass with Min Tracking
     * 
     * Theoretical Basis:
     * - Find max(prices[j] - prices[i]) where j > i
     * - Track minimum price seen so far (optimal buy point)
     * - At each day, calculate profit if selling today
     * - Greedy: always buy at lowest, always consider selling at current
     * 
     * Time Complexity: O(N) - single pass
     * Space Complexity: O(1) - only two variables
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                // Found new minimum - potential buy point
                minPrice = price;
            } else {
                // Calculate profit if selling today
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [7,1,5,3,6,4] -> 5
        runTest(solution, new int[] { 7, 1, 5, 3, 6, 4 }, 5);

        // Test 2: [7,6,4,3,1] -> 0
        runTest(solution, new int[] { 7, 6, 4, 3, 1 }, 0);

        // Test 3: [1,2] -> 1
        runTest(solution, new int[] { 1, 2 }, 1);

        // Test 4: [2,1] -> 0
        runTest(solution, new int[] { 2, 1 }, 0);
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
