package leet_code.Problem_813_Medium_Largest_Sum_of_Averages;

public class Solution {

    /**
     * Finds the maximum sum of averages by partitioning the array into at most k
     * subarrays.
     * Strategy: Dynamic Programming.
     * Time: O(K * N^2), Space: O(K * N).
     */
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        // dp[i][g] is the max score for i elements partitioned into g groups
        double[][] dp = new double[n + 1][k + 1];

        // Prefix sums to calculate subarray sums in O(1)
        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Base case: exactly 1 group for first i elements
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i] / i;
        }

        // DP for number of groups from 2 up to k
        for (int g = 2; g <= k; g++) {
            // Number of elements considered
            for (int i = 1; i <= n; i++) {
                // j is the split point: i-j elements are in the g-th group
                // Previous g-1 groups covered j elements
                for (int j = g - 1; j < i; j++) {
                    double currentAvg = (prefixSum[i] - prefixSum[j]) / (i - j);
                    dp[i][g] = Math.max(dp[i][g], dp[j][g - 1] + currentAvg);
                }
            }
        }

        // We want to maximize, and partitioning into FEWER than k groups might be worse
        // or equal.
        // The loops above populate exactly g groups. We need the best among 1..k.
        // Actually, dp[n][k] will naturally pick the best if we consider partitioning
        // to be exactly k.
        // But since we can use AT MOST k, let's verify if we need to check other
        // columns.
        // In this problem, adding more split points (up to k) usually increases or
        // keeps the score same.
        double maxScore = 0;
        for (int g = 1; g <= k; g++) {
            maxScore = Math.max(maxScore, dp[n][g]);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = { 9, 1, 2, 3, 9 };
        System.out.println("Result 1: " + sol.largestSumOfAverages(n1, 3)); // 20.0

        int[] n2 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Result 2: " + sol.largestSumOfAverages(n2, 4)); // 12.75
    }
}
