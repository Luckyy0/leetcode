package leet_code.Problem_494_Medium_Target_Sum;

public class Solution_DP {

    /**
     * Finds number of ways to reach target.
     * Strategy: Transform to Subset Sum Problem sum(P) = (target + totalSum) / 2.
     * Time: O(N * Sum), Space: O(Sum).
     */
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        // Validation: (target + totalSum) must be non-negative and even
        if (totalSum < Math.abs(target) || (target + totalSum) % 2 != 0) {
            return 0;
        }

        int subsetSum = (target + totalSum) / 2;

        // DP for Subset Sum count
        // dp[i] stores number of subsets with sum i
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // One way to get sum 0 (empty subset)

        for (int num : nums) {
            // Iterate backwards to avoid using same element twice in one step
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        int[] nums = { 1, 1, 1, 1, 1 };
        System.out.println("Result: " + solution.findTargetSumWays(nums, 3)); // 5
    }
}
