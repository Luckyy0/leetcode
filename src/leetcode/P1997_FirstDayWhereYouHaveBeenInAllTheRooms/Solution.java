package leetcode.P1997_FirstDayWhereYouHaveBeenInAllTheRooms;

public class Solution {
    public int firstDayBeenInAllRooms(int[] nextRoom) {
        int n = nextRoom.length;
        int MOD = 1_000_000_007;

        long[] dp = new long[n];
        // dp[i] is the day we first arrive at room i.
        // dp[0] = 0.

        for (int i = 0; i < n - 1; i++) {
            // To get to i+1:
            // 1. Arrive at i (at time dp[i]).
            // 2. Go to nextRoom[i] (takes 1 day). Time: dp[i] + 1.
            // 3. Travel from nextRoom[i] back to i. Steps = dp[i] - dp[nextRoom[i]].
            // Time when back at i: (dp[i] + 1) + (dp[i] - dp[nextRoom[i]]).
            // 4. Move to i+1 (takes 1 day).
            // Total: dp[i+1] = 2*dp[i] - dp[nextRoom[i]] + 2.

            long steps = (2 * dp[i] - dp[nextRoom[i]] + 2) % MOD;
            if (steps < 0)
                steps += MOD;
            dp[i + 1] = steps;
        }

        return (int) dp[n - 1];
    }
}
