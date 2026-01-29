package leetcode.P656_CoinPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(next, -1);

        dp[0] = coins[0];

        for (int i = 0; i < n; i++) {
            if (coins[i] == -1 || dp[i] == Integer.MAX_VALUE)
                continue;

            for (int j = i + 1; j <= Math.min(i + maxJump, n - 1); j++) {
                if (coins[j] == -1)
                    continue;

                int cost = dp[i] + coins[j];
                if (cost < dp[j] || (cost == dp[j] && next[i] != -1 && (next[j] == -1 || next[i] < next[j]))) {
                    dp[j] = cost;
                    next[i] = j;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dp[n - 1] == Integer.MAX_VALUE)
            return path;

        for (int i = 0; i != -1; i = next[i]) {
            path.add(i + 1);
        }

        return path;
    }
}
