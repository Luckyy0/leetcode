package leetcode.P740_DeleteAndEarn;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int n : nums)
            maxVal = Math.max(maxVal, n);

        int[] values = new int[maxVal + 1];
        for (int n : nums)
            values[n] += n;

        // Applying House Robber logic
        // Áp dụng logic Ăn trộm nhà
        int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int v : values) {
            int current = Math.max(prev1, prev2 + v);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
