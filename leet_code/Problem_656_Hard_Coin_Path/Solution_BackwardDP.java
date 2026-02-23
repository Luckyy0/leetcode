package leet_code.Problem_656_Hard_Coin_Path;

import java.util.*;

public class Solution_BackwardDP {

    /**
     * Finds the lexicographically smallest path with minimum cost.
     * Strategy: Backward DP to naturally satisfy lexicographical requirements.
     * Time: O(N * maxJump), Space: O(N).
     */
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        List<Integer> res = new ArrayList<>();

        // n-th cell must be reachable
        if (coins[n - 1] == -1)
            return res;

        long[] dp = new long[n + 1];
        int[] next = new int[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        Arrays.fill(next, -1);

        // Base case: end to end cost
        dp[n] = coins[n - 1];

        // Iterate backward
        for (int i = n - 1; i >= 1; i--) {
            if (coins[i - 1] == -1)
                continue;

            // Try all possible forward jumps from i
            for (int j = i + 1; j <= Math.min(i + maxJump, n); j++) {
                if (dp[j] == Long.MAX_VALUE / 2)
                    continue;

                // If smaller cost found, or equal cost with smaller j (due to loop order i+1 to
                // ...)
                // Actually, if we use backward DP, for a fixed i, the first j that gives min
                // cost
                // is the one we want. Since we loop j from i+1 upwards, we already prioritize
                // smaller j.
                if (coins[i - 1] + dp[j] < dp[i]) {
                    dp[i] = coins[i - 1] + dp[j];
                    next[i] = j;
                }
            }
        }

        // If start is not reachable
        if (dp[1] == Long.MAX_VALUE / 2)
            return res;

        // Path reconstruction
        int curr = 1;
        while (curr != -1) {
            res.add(curr);
            curr = next[curr];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_BackwardDP sol = new Solution_BackwardDP();
        int[] coins = { 1, 2, 4, -1, 2 };
        int B = 2;
        System.out.println("Path: " + sol.cheapestJump(coins, B)); // [1, 3, 5]
    }
}
