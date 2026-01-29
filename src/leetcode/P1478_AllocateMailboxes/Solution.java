package leetcode.P1478_AllocateMailboxes;

import java.util.Arrays;

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;

        // Precompute cost for 1 mailbox for range [i, j]
        int[][] costs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int median = houses[(i + j) / 2];
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += Math.abs(houses[l] - median);
                }
                costs[i][j] = sum;
            }
        }

        // dp[k][i] - min cost for houses 0...i using k mailboxes
        // Note: k is 1-indexed count, i is 0-indexed house
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE / 2);

        // Base case: k=1
        for (int i = 0; i < n; i++) {
            dp[1][i] = costs[0][i];
        }

        for (int m = 2; m <= k; m++) {
            for (int i = m - 1; i < n; i++) {
                for (int j = m - 2; j < i; j++) {
                    dp[m][i] = Math.min(dp[m][i], dp[m - 1][j] + costs[j + 1][i]);
                }
            }
        }

        return dp[k][n - 1];
    }
}
