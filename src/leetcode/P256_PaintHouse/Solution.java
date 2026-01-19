package leetcode.P256_PaintHouse;

public class Solution {

    /**
     * Problem 256: Paint House
     * Approach: Dynamic Programming (In-place)
     * 
     * Theoretical Basis:
     * - Minimum cost at step i depends on min cost of non-conflicting colors at
     * i-1.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // Iterate and update costs
        for (int i = 1; i < costs.length; i++) {
            // Red depends on min(Green, Blue) of prev
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            // Green depends on min(Red, Blue) of prev
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            // Blue depends on min(Red, Green) of prev
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int n = costs.length - 1;
        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[17,2,17],[16,16,5],[14,3,19]] -> 10
        int[][] costs1 = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        runTest(solution, costs1, 10);

        // [[7,6,2]] -> 2
        int[][] costs2 = { { 7, 6, 2 } };
        runTest(solution, costs2, 2);
    }

    private static void runTest(Solution s, int[][] costs, int expected) {
        // Need to clone if used multiple times because we modify in place.
        // Here we run once per array.
        int result = s.minCost(costs);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
