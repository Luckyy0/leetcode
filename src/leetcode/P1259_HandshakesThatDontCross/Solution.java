package leetcode.P1259_HandshakesThatDontCross;

class Solution {
    public int numberOfWays(int numPeople) {
        long MOD = 1_000_000_007;
        int n = numPeople / 2;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // Catalan recurrence: C_i = sum(C_j * C_{i-1-j})
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + dp[j] * dp[i - 1 - j]) % MOD;
            }
        }

        return (int) dp[n];
    }
}
