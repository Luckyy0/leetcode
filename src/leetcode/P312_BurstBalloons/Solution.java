package leetcode.P312_BurstBalloons;

public class Solution {

    /**
     * Problem 312: Burst Balloons
     * Approach: Interval DP
     * 
     * Time Complexity: O(N^3)
     * Space Complexity: O(N^2)
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Augment nums with 1 at boundaries
        int[] vals = new int[n + 2];
        vals[0] = 1;
        vals[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            vals[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // Iterate length of range (from 3 items: boundary left, k, boundary right.
        // Distance j-i >= 2)
        // Length of range is j - i. We need at least one element k between i and j.
        // Smallest length j-i is 2.

        for (int len = 2; len <= n + 1; len++) {
            for (int i = 0; i <= n + 1 - len; i++) {
                int j = i + len;
                // Iterate k between i and j
                for (int k = i + 1; k < j; k++) {
                    int logic = dp[i][k] + dp[k][j] + vals[i] * vals[k] * vals[j];
                    dp[i][j] = Math.max(dp[i][j], logic);
                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,1,5,8] -> 167
        runTest(solution, new int[] { 3, 1, 5, 8 }, 167);

        // [1,5] -> 10
        runTest(solution, new int[] { 1, 5 }, 10);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.maxCoins(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
