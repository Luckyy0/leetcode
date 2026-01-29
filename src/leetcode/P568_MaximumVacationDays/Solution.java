package leetcode.P568_MaximumVacationDays;

import java.util.Arrays;

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length; // number of weeks

        // dp[j] stores max vacation days ending in city j for current week
        // dp[j] lưu trữ số ngày nghỉ tối đa kết thúc tại thành phố j cho tuần hiện tại
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        // Initial state: start at city 0
        // Trạng thái ban đầu: bắt đầu tại thành phố 0
        dp[0] = 0;

        // Iterate over each week
        // Lặp qua từng tuần
        for (int w = 0; w < k; w++) {
            int[] temp = new int[n];
            Arrays.fill(temp, Integer.MIN_VALUE);

            // For each city i (destination)
            // Với mỗi thành phố i (đích đến)
            for (int i = 0; i < n; i++) {
                // Try to come from every city j (source)
                // Cố gắng đến từ mọi thành phố j (nguồn)
                for (int j = 0; j < n; j++) {
                    // Check if city j was reachable last week AND (flight exists OR stay in same
                    // city)
                    // Kiểm tra xem thành phố j có thể đến được vào tuần trước KHÔNG VÀ (chuyến bay
                    // tồn tại HOẶC ở lại cùng thành phố)
                    if (dp[j] != Integer.MIN_VALUE && (flights[j][i] == 1 || i == j)) {
                        temp[i] = Math.max(temp[i], dp[j] + days[i][w]);
                    }
                }
            }
            dp = temp;
        }

        int maxDays = 0;
        for (int val : dp) {
            maxDays = Math.max(maxDays, val);
        }

        return maxDays;
    }
}
