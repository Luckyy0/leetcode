package leet_code.Problem_123_Hard_Best_Time_To_Buy_And_Sell_Stock_III;

public class Solution_DP {

    /**
     * Calculates the maximum profit with at most two transactions.
     * Uses state-based dynamic programming with O(N) time and O(1) space.
     * 
     * Tính toán lợi nhuận tối đa với tối đa hai giao dịch.
     * Sử dụng quy hoạch động dựa trên trạng thái với thời gian O(N) và không gian
     * O(1).
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // buy1: max balance after buying the first stock
        // sell1: max balance after selling the first stock
        // buy2: max balance after buying the second stock
        // sell2: max balance after selling the second stock
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            // Level 1: First transaction
            // Giai đoạn 1: Giao dịch đầu tiên
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            // Level 2: Second transaction (reinvesting profit from sell1)
            // Giai đoạn 2: Giao dịch thứ hai (tái đầu tư lợi nhuận từ sell1)
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [3,3,5,0,0,3,1,4]
        int[] p1 = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println("Test Case 1 Profit: " + solution.maxProfit(p1));
        // Expected: 6

        // Test Case 2: [1,2,3,4,5]
        int[] p2 = { 1, 2, 3, 4, 5 };
        System.out.println("Test Case 2 Profit: " + solution.maxProfit(p2));
        // Expected: 4

        // Test Case 3: [7,6,4,3,1]
        int[] p3 = { 7, 6, 4, 3, 1 };
        System.out.println("Test Case 3 Profit: " + solution.maxProfit(p3));
        // Expected: 0
    }
}
