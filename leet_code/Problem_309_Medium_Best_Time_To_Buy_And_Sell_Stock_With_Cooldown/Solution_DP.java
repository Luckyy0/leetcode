package leet_code.Problem_309_Medium_Best_Time_To_Buy_And_Sell_Stock_With_Cooldown;

public class Solution_DP {

    /**
     * Calculates max profit with cooldown.
     * Uses State Machine DP.
     * Time: O(N), Space: O(1).
     * 
     * Tính lợi nhuận tối đa với thời gian nghỉ.
     * Sử dụng DP Máy trạng thái.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // Initial states
        // Trạng thái ban đầu
        int held = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevRest = rest;

            // Rest state: From either Rest or Sold (yesterday)
            // Trạng thái Nghỉ: Từ Nghỉ hoặc Đã bán (hôm qua)
            rest = Math.max(rest, sold);

            // Sold state: Must come from Held (sell today)
            // Trạng thái Đã bán: Phải đến từ Đang giữ (bán hôm nay)
            sold = held + prices[i];

            // Held state: From Held or Rest (buy today)
            // Note: If we buy, we must come from Rest (cooldown rule)
            // Trạng thái Đang giữ: Từ Đang giữ hoặc Nghỉ (mua hôm nay)
            // Lưu ý: Nếu mua, phải đến từ Nghỉ (quy tắc nghỉ)
            held = Math.max(held, prevRest - prices[i]);
        }

        // Final result is max of Sold or Rest (holding is meaningless at end)
        // Kết quả cuối cùng là max của Đã bán hoặc Nghỉ (đang giữ là vô nghĩa khi kết
        // thúc)
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1,2,3,0,2] -> 3
        int[] p1 = { 1, 2, 3, 0, 2 };
        System.out.println("Max Profit 1: " + solution.maxProfit(p1));

        // Test Case 2: [1] -> 0
        int[] p2 = { 1 };
        System.out.println("Max Profit 2: " + solution.maxProfit(p2));
    }
}
