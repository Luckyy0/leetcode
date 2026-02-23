package leet_code.Problem_188_Hard_Best_Time_To_Buy_And_Sell_Stock_IV;

import java.util.Arrays;

public class Solution_DP {

    /**
     * Calculates the maximum profit with at most k transactions.
     * Uses optimized DP with O(K) space.
     * 
     * Tính toán lợi nhuận tối đa với tối đa k giao dịch.
     * Sử dụng DP tối ưu hóa với không gian O(K).
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0)
            return 0;

        // Optimization: If k >= n/2, it's effectively unlimited transactions (Problem
        // 122)
        // Tối ưu hóa: Nếu k >= n/2, coi như không giới hạn giao dịch (Bài 122)
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }

        // dp[i][0] -> cost to buy i-th stock (stored as negative value or handled
        // logic)
        // Strictly:
        // buy[i] = max profit after buying i-th stock
        // sell[i] = max profit after selling i-th stock

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        // Initialize buy states to very small number
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                // To buy the i-th stock, we use profit from (i-1)-th sell minus current price
                // Để mua cổ phiếu thứ i, dùng lợi nhuận từ lần bán thứ (i-1) trừ đi giá hiện
                // tại
                buy[i] = Math.max(buy[i], sell[i - 1] - price);

                // To sell the i-th stock, we use profit from i-th buy plus current price
                // Để bán cổ phiếu thứ i, dùng lợi nhuận từ lần mua thứ i cộng với giá hiện tại
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k];
    }

    // Helper for unlimited transactions case
    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: k=2, prices=[2,4,1] -> 2
        int[] p1 = { 2, 4, 1 };
        System.out.println("Max Profit 1: " + solution.maxProfit(2, p1));

        // Test Case 2: k=2, prices=[3,2,6,5,0,3] -> 7
        int[] p2 = { 3, 2, 6, 5, 0, 3 };
        System.out.println("Max Profit 2: " + solution.maxProfit(2, p2));
    }
}
