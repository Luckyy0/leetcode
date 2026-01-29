package leetcode.P935_KnightDialer;

import java.util.Arrays;

class Solution {
    public int knightDialer(int n) {
        if (n == 1)
            return 10;
        long mod = 1_000_000_007;
        int[][] moves = {
                { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 }, { 2, 4 }
        };

        long[] dp = new long[10];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            long[] next = new long[10];
            for (int j = 0; j < 10; j++) {
                for (int nextPos : moves[j]) {
                    next[nextPos] = (next[nextPos] + dp[j]) % mod;
                }
            }
            dp = next;
        }

        long sum = 0;
        for (long x : dp)
            sum = (sum + x) % mod;
        return (int) sum;
    }
}
