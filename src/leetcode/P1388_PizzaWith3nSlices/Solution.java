package leetcode.P1388_PizzaWith3nSlices;

import java.util.Arrays;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int m = slices.length;
        int n = m / 3;

        // Case 1: Exclude last element
        int[] arr1 = Arrays.copyOfRange(slices, 0, m - 1);
        // Case 2: Exclude first element
        int[] arr2 = Arrays.copyOfRange(slices, 1, m);

        return Math.max(solve(arr1, n), solve(arr2, n));
    }

    private int solve(int[] arr, int k) {
        int len = arr.length;
        // dp[i][j] max sum using j items from first i items (1-based index)
        // Optimization: dp[j] using current row vs prev row
        // dp[i][j] uses arr[i-1].
        // dp[i][j] = max(dp[i-1][j], dp[i-2][j-1] + arr[i-1])

        int[][] dp = new int[len + 1][k + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                int pick = arr[i - 1] + (i >= 2 ? dp[i - 2][j - 1] : 0);
                int notPick = dp[i - 1][j];
                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[len][k];
    }
}
