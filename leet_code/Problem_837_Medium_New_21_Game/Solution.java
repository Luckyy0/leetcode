package leet_code.Problem_837_Medium_New_21_Game;

public class Solution {

    /**
     * Calculates the probability of finishing with N or fewer points.
     * Strategy: DP with sliding window sum optimization.
     * Time: O(N), Space: O(N).
     */
    public double new21Game(int n, int k, int maxPts) {
        // Edge case: if k is 0, Alice starts with 0 and stops immediately (prob 1.0)
        // If n >= k + maxPts - 1, Alice can never exceed n (prob 1.0)
        if (k == 0 || n >= k + maxPts) {
            return 1.0;
        }

        // dp[i] = probability of having i points
        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        // Maintains the sum of probabilities of scores that can reach the current score
        double windowSum = 1.0;
        double probabilityResult = 0.0;

        for (int i = 1; i <= n; i++) {
            // dp[i] is the average of previous maxPts probabilities
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // If score is less than k, game continues
                windowSum += dp[i];
            } else {
                // If score is >= k, game stops. This is a possible final score.
                probabilityResult += dp[i];
            }

            // Sliding window: remove the probability that is no longer reachable
            if (i >= maxPts) {
                windowSum -= dp[i - maxPts];
            }
        }

        return probabilityResult;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.new21Game(10, 1, 10)); // 1.0
        System.out.println("Result 2: " + sol.new21Game(6, 1, 10)); // 0.6
        System.out.println("Result 3: " + sol.new21Game(21, 17, 10)); // 0.73278
    }
}
