package leetcode.P377_CombinationSumIV;

public class Solution {

    /**
     * Problem 377: Combination Sum IV
     * Approach: Dynamic Programming
     * 
     * Time Complexity: O(Target * N)
     * Space Complexity: O(Target)
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3], 4 -> 7
        runTest(solution, new int[] { 1, 2, 3 }, 4, 7);

        // [9], 3 -> 0
        runTest(solution, new int[] { 9 }, 3, 0);
    }

    private static void runTest(Solution s, int[] nums, int target, int expected) {
        int result = s.combinationSum4(nums, target);
        System.out.println("Target: " + target + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
