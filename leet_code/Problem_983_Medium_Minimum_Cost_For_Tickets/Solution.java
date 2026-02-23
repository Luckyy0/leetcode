package leet_code.Problem_983_Medium_Minimum_Cost_For_Tickets;

/**
 * Problem 983: Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class Solution {

    /**
     * Finds the minimum cost to travel.
     * Strategy: DP on days.
     * 
     * @param days  Array of travel days.
     * @param costs Array of costs [1-day, 7-day, 30-day].
     * @return Minimum cost.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng quy hoạch động. `dp[i]` là chi phí tối thiểu để đi du lịch
     *         đến hết ngày thứ `i`.
     *         2. Duyệt `i` từ 1 đến ngày cuối cùng trong danh sách chuyến đi
     *         (`lastDay`).
     *         3. Nếu ngày `i` KHÔNG phải là ngày đi du lịch:
     *         Ta không cần mua vé cho ngày này. Chi phí bằng chi phí của ngày
     *         `i-1`.
     *         `dp[i] = dp[i-1]`.
     *         4. Nếu ngày `i` LÀ ngày đi du lịch:
     *         Ta có 3 lựa chọn mua vé kêt thúc hoặc bao trùm ngày `i`:
     *         - Mua vé 1 ngày vào chính ngày `i`: Chi phí = `dp[i-1] + costs[0]`.
     *         - Mua vé 7 ngày sao cho nó bao trùm ngày `i` (mua vào ngày `i-6` hoặc
     *         trễ hơn):
     *         Chi phí tối ưu nhất là coi như ta mua vé để phủ từ `i-6` đến `i`.
     *         Chi phí = `dp[max(0, i-7)] + costs[1]`. (Lấy `dp` tại thời điểm trước
     *         khi mua vé 7 ngày).
     *         - Mua vé 30 ngày: Tương tự, `dp[max(0, i-30)] + costs[2]`.
     *         Lấy min của 3 lựa chọn này.
     *         5. Kết quả là `dp[lastDay]`.
     */
    public int mincostTickets(int[] days, int[] costs) {
        // The last day we need to cover
        int lastDay = days[days.length - 1];

        // dp[i] stores min cost to cover travel up to day i
        int[] dp = new int[lastDay + 1];

        // Boolean array to quickly check if a day is a travel day
        boolean[] isTravelDay = new boolean[lastDay + 1];
        for (int day : days) {
            isTravelDay[day] = true;
        }

        for (int i = 1; i <= lastDay; i++) {
            if (!isTravelDay[i]) {
                // If not traveling today, cost is same as yesterday
                dp[i] = dp[i - 1];
                continue;
            }

            // Option 1: Buy 1-day pass today
            // Cost is cost up to yesterday + cost of 1-day pass
            int oneDay = dp[i - 1] + costs[0];

            // Option 2: Buy 7-day pass
            // Valid for days [i-6, i]. We need to cover up to i-7 previously.
            int sevenDay = dp[Math.max(0, i - 7)] + costs[1];

            // Option 3: Buy 30-day pass
            // Valid for days [i-29, i]. We need to cover up to i-30 previously.
            int thirtyDay = dp[Math.max(0, i - 30)] + costs[2];

            dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }

        return dp[lastDay];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] d1 = { 1, 4, 6, 7, 8, 20 };
        int[] c1 = { 2, 7, 15 };
        System.out.println("Result: " + sol.mincostTickets(d1, c1)); // 11

        int[] d2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
        int[] c2 = { 2, 7, 15 };
        System.out.println("Result: " + sol.mincostTickets(d2, c2)); // 17
    }
}
