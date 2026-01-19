package leetcode.P265_PaintHouseII;

public class Solution {

    /**
     * Problem 265: Paint House II
     * Approach: DP with O(NK) optimization
     * 
     * Theoretical Basis:
     * - Only need to track min1 and min2 of previous row.
     * 
     * Time Complexity: O(NK)
     * Space Complexity: O(1)
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;

        int n = costs.length;
        int k = costs[0].length;

        // Edge case: k=1
        if (k == 1) {
            return n == 1 ? costs[0][0] : -1; // -1 or infinity conceptually if n > 1
        }

        // State of previous row
        int min1 = 0;
        int min2 = 0;
        int index1 = -1;

        for (int i = 0; i < n; i++) {
            // State of current row
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curIndex1 = -1;

            for (int j = 0; j < k; j++) {
                // Calculate cost for painting house i with color j
                int cost = costs[i][j] + (j == index1 ? min2 : min1);

                // Update current row min1/min2
                if (cost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curIndex1 = j;
                } else if (cost < curMin2) {
                    curMin2 = cost;
                }
            }

            // Move current to previous
            min1 = curMin1;
            min2 = curMin2;
            index1 = curIndex1;
        }

        return min1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,5,3],[2,9,4]] -> 5
        int[][] costs1 = { { 1, 5, 3 }, { 2, 9, 4 } };
        runTest(solution, costs1, 5);

        // [[1,3],[2,4]] -> 5
        int[][] costs2 = { { 1, 3 }, { 2, 4 } };
        runTest(solution, costs2, 5);

        // k=1, n=1 -> 1
        int[][] costs3 = { { 1 } };
        runTest(solution, costs3, 1);
    }

    private static void runTest(Solution s, int[][] costs, int expected) {
        int result = s.minCostII(costs);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
