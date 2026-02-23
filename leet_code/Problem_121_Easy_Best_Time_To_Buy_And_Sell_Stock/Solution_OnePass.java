package leet_code.Problem_121_Easy_Best_Time_To_Buy_And_Sell_Stock;

public class Solution_OnePass {

    /**
     * Calculates the maximum profit from buying and selling a stock once.
     * Uses a greedy one-pass approach with O(N) time and O(1) space.
     * 
     * Tính toán lợi nhuận tối đa từ việc mua và bán một cổ phiếu một lần.
     * Sử dụng phương pháp tham lam một lần duyệt với thời gian O(N) và không gian
     * O(1).
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // If we found a new lowest price, update minPrice
            // Nếu chúng ta tìm thấy một mức giá thấp nhất mới, hãy cập nhật minPrice
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Otherwise, calculate the profit if sold today and update maxProfit
            // Nếu không, hãy tính lợi nhuận nếu bán hôm nay và cập nhật maxProfit
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution_OnePass solution = new Solution_OnePass();

        // Test Case 1: [7,1,5,3,6,4]
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Test Case 1 Profit: " + solution.maxProfit(prices1));
        // Expected: 5

        // Test Case 2: [7,6,4,3,1]
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("Test Case 2 Profit: " + solution.maxProfit(prices2));
        // Expected: 0
    }
}
