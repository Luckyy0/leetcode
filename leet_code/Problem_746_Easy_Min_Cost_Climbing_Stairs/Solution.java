package leet_code.Problem_746_Easy_Min_Cost_Climbing_Stairs;

public class Solution {

    /**
     * Calculates the minimum cost to reach the top.
     * Strategy: Dynamic Programming with O(1) space.
     * Time: O(N), Space: O(1).
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i] represents min cost TO REACH step i.
        // We can start at 0 or 1, so cost to reach them is 0 effectively?
        // No, standard loop logic:
        // We are at step 'i'. We want to compute min cost to reach 'i'.

        int prev2 = 0; // Cost to reach step 0
        int prev1 = 0; // Cost to reach step 1

        // Loop from step 2 up to step n (top)
        for (int i = 2; i <= n; i++) {
            // To reach 'i':
            // 1. From 'i-1': pay cost[i-1]
            // 2. From 'i-2': pay cost[i-2]
            int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] cost1 = { 10, 15, 20 };
        System.out.println("Result 1: " + sol.minCostClimbingStairs(cost1)); // 15

        int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println("Result 2: " + sol.minCostClimbingStairs(cost2)); // 6
    }
}
