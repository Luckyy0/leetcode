package leetcode.P1230_TossStrangeCoins;

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target + 1];
        dp[0] = 1.0;

        for (double p : prob) {
            for (int k = target; k >= 0; k--) {
                // dp[k] currently holds prob of k heads with PREVIOUS coins
                // If curr coin is TAIL (prob 1-p), we keep k heads
                double way1 = dp[k] * (1 - p);

                // If curr coin is HEAD (prob p), we need k-1 heads previously
                double way2 = (k > 0) ? dp[k - 1] * p : 0;

                dp[k] = way1 + way2;
            }
        }

        return dp[target];
    }
}
