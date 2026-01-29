package leetcode.P2052_MinimumCostToSeparateSentenceIntoRows;

import java.util.Arrays;

public class Solution {
    public int minimumCost(String sentence, int k) {
        String[] words = sentence.split(" ");
        int n = words.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        // DP backwards
        for (int i = n - 1; i >= 0; i--) {
            int currentLen = 0;
            for (int j = i; j < n; j++) {
                currentLen += words[j].length();
                if (j > i)
                    currentLen++; // space

                if (currentLen > k)
                    break;

                int cost;
                if (j == n - 1) {
                    cost = 0;
                } else {
                    cost = (k - currentLen) * (k - currentLen);
                }

                if (dp[j + 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], cost + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}
