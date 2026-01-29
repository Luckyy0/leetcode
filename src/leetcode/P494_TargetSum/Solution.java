package leetcode.P494_TargetSum;

public class Solution {

    /**
     * Problem 494: Target Sum
     * Approach: Dynamic Programming (Subset Sum variation)
     * 
     * Time Complexity: O(N * S)
     * Space Complexity: O(S)
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        // Mathematical condition: sum(P) = (target + sum(nums)) / 2
        if (Math.abs(target) > sum || (target + sum) % 2 != 0)
            return 0;

        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int n : nums) {
            for (int i = subsetSum; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }

        return dp[subsetSum];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // nums = [1,1,1,1,1], target = 3 -> 5
        int[] n1 = { 1, 1, 1, 1, 1 };
        System.out.println("Result 1: " + sol.findTargetSumWays(n1, 3) + " (Expected: 5)");

        // nums = [1], target = 1 -> 1
        int[] n2 = { 1 };
        System.out.println("Result 2: " + sol.findTargetSumWays(n2, 1) + " (Expected: 1)");
    }
}
