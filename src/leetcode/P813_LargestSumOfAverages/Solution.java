package leetcode.P813_LargestSumOfAverages;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        // dp[i] will store max score of partitioning first i elements into x subarrays
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (prefixSum[n] - prefixSum[i]) / (n - i);
        }

        // We do k-1 iterations because the base case (1 subarray) is done differently
        // or implicitly here
        // (This specific logic solves it for exactly partitioning remaining parts)
        // Let's use a clearer 2D table logic for robustness
        double[][] table = new double[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            table[1][i] = prefixSum[i] / i;
        }

        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int p = j - 1; p < i; p++) {
                    table[j][i] = Math.max(table[j][i], table[j - 1][p] + (prefixSum[i] - prefixSum[p]) / (i - p));
                }
            }
        }

        return table[k][n];
    }
}
