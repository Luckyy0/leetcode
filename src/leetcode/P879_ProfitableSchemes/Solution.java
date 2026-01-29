package leetcode.P879_ProfitableSchemes;

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = 1_000_000_007;

        // dp[i][j] = number of schemes with i members used and j profit (capped at
        // minProfit)
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;

        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];
            for (int i = n; i >= g; i--) {
                for (int j = minProfit; j >= 0; j--) {
                    int nextProfit = Math.min(minProfit, j + p);
                    dp[i][nextProfit] = (dp[i][nextProfit] + dp[i - g][j]) % mod;
                }
            }
        }

        int total = 0;
        for (int i = 0; i <= n; i++) {
            total = (total + dp[i][minProfit]) % mod;
        }
        return total;
    }
}
