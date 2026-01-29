package leetcode.P1406_StoneGameIII;

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[n] = 0

        for (int i = n - 1; i >= 0; i--) {
            int takeOne = stoneValue[i] - dp[i + 1];
            int maxDiff = takeOne;

            if (i + 1 < n) {
                int takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
                maxDiff = Math.max(maxDiff, takeTwo);
            }

            if (i + 2 < n) {
                int takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
                maxDiff = Math.max(maxDiff, takeThree);
            }

            dp[i] = maxDiff;
        }

        if (dp[0] > 0)
            return "Alice";
        if (dp[0] < 0)
            return "Bob";
        return "Tie";
    }
}
