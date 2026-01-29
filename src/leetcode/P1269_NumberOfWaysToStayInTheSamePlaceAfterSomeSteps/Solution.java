package leetcode.P1269_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps;

class Solution {
    public int numWays(int steps, int arrLen) {
        int maxIndex = Math.min(arrLen - 1, steps); // Optimization
        long[] dp = new long[maxIndex + 1];
        dp[0] = 1;
        long MOD = 1_000_000_007;

        for (int i = 0; i < steps; i++) {
            long[] nextDp = new long[maxIndex + 1];
            for (int j = 0; j <= maxIndex; j++) {
                // Stay
                nextDp[j] = dp[j];
                // Right from j-1
                if (j > 0)
                    nextDp[j] = (nextDp[j] + dp[j - 1]) % MOD;
                // Left from j+1
                if (j < maxIndex)
                    nextDp[j] = (nextDp[j] + dp[j + 1]) % MOD;
            }
            dp = nextDp;
        }

        return (int) dp[0];
    }
}
