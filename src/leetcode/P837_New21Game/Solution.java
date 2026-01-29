package leetcode.P837_New21Game;

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts)
            return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0;
        double res = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;
            if (i < k) {
                windowSum += dp[i];
            } else {
                res += dp[i];
            }

            if (i >= maxPts) {
                windowSum -= dp[i - maxPts];
            }
        }

        return res;
    }
}
