package leet_code.Problem_568_Hard_Maximum_Vacation_Days;

import java.util.Arrays;

public class Solution_DP {

    /**
     * Finds max vacation days given flights and daily vacation days.
     * Strategy: DP on (week, city). Space optimized to O(N).
     * Time: O(K * N^2), Space: O(N).
     */
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;

        // dp[i] = max vacation days finishing at city i
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        // Initial state: week -1 at city 0
        dp[0] = 0;

        for (int w = 0; w < k; w++) {
            int[] nextDp = new int[n];
            Arrays.fill(nextDp, Integer.MIN_VALUE);

            for (int j = 0; j < n; j++) { // Current city (target)
                for (int i = 0; i < n; i++) { // Previous city (source)
                    // Check if reachable from i to j (or stay)
                    if ((i == j || flights[i][j] == 1) && dp[i] != Integer.MIN_VALUE) {
                        nextDp[j] = Math.max(nextDp[j], dp[i] + days[j][w]);
                    }
                }
            }
            dp = nextDp;
        }

        int maxDays = 0;
        for (int d : dp) {
            maxDays = Math.max(maxDays, d);
        }
        return maxDays;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        int[][] flights = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
        int[][] days = { { 1, 3, 1 }, { 6, 0, 3 }, { 3, 3, 3 } };
        System.out.println("Max Vacation: " + solution.maxVacationDays(flights, days)); // 12
    }
}
