package leetcode.P416_PartitionEqualSubsetSum;

public class Solution {

    /**
     * Problem 416: Partition Equal Subset Sum
     * Approach: 0/1 Knapsack Dynamic Programming
     * 
     * Time Complexity: O(N * Target)
     * Space Complexity: O(Target)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int n : nums) {
            // Iterate backwards to avoid using the same item twice for the same sum
            for (int i = target; i >= n; i--) {
                dp[i] = dp[i] || dp[i - n];
            }
            // Optimization: if we already reached target, we can stop
            if (dp[target])
                return true;
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1, 5, 11, 5] -> true
        runTest(solution, new int[] { 1, 5, 11, 5 }, true);

        // [1, 2, 3, 5] -> false
        runTest(solution, new int[] { 1, 2, 3, 5 }, false);
    }

    private static void runTest(Solution sol, int[] nums, boolean expected) {
        boolean result = sol.canPartition(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
