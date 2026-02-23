package leet_code.Problem_122_Medium_Best_Time_To_Buy_And_Sell_Stock_II;

public class Solution_Greedy {

    /**
     * Calculates the maximum profit with unlimited transactions.
     * We capture every positive price difference.
     * 
     * Tính toán lợi nhuận tối đa với số lượng giao dịch không giới hạn.
     * Chúng ta nắm bắt mọi sự chênh lệch giá dương.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Start from the second day
        // Bắt đầu từ ngày thứ hai
        for (int i = 1; i < prices.length; i++) {
            // If the price increased compared to yesterday, add to profit
            // Nếu giá tăng so với ngày hôm qua, hãy cộng vào lợi nhuận
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1: [7,1,5,3,6,4]
        int[] p1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Test Case 1 Profit: " + solution.maxProfit(p1));
        // Expected: 7 (4 from [1,5] and 3 from [3,6])

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
