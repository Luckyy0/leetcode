package leetcode.P134_GasStation;

public class Solution {

    /**
     * Problem 134: Gas Station
     * Approach: One-Pass Greedy
     * 
     * Theoretical Basis:
     * - If Sum(gas) < Sum(cost), no solution exists.
     * - If we can't reach point B from A, then no point between A and B can reach
     * B.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalGas += net;
            currentGas += net;

            // If current gas drops below 0, reset start point to the next station
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }

        return (totalGas >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] gas1 = { 1, 2, 3, 4, 5 };
        int[] cost1 = { 3, 4, 5, 1, 2 };
        System.out.println("Test 1: " + solution.canCompleteCircuit(gas1, cost1)); // Expected: 3

        // Test Case 2
        int[] gas2 = { 2, 3, 4 };
        int[] cost2 = { 3, 4, 3 };
        System.out.println("Test 2: " + solution.canCompleteCircuit(gas2, cost2)); // Expected: -1
    }
}
