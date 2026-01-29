package leetcode.P887_SuperEggDrop;

class Solution {
    public int superEggDrop(int k, int n) {
        // dp[m][k] = max number of floors we can test with m moves and k eggs
        // We only need dp[k] because we only refer back to m-1
        int[] dp = new int[k + 1];
        int m = 0;
        while (dp[k] < n) {
            m++;
            for (int i = k; i > 0; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
        }
        return m;
    }
}
