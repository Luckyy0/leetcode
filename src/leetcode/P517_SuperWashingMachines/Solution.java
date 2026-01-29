package leetcode.P517_SuperWashingMachines;

public class Solution {

    /**
     * Problem 517: Super Washing Machines
     * Approach: Cumulative Flow Balance
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines)
            total += m;

        int n = machines.length;
        if (total % n != 0)
            return -1;

        int target = total / n;
        int maxMoves = 0;
        int currentFlux = 0;

        for (int m : machines) {
            int balance = m - target;
            currentFlux += balance;

            // maxMoves is limited by the maximum outflow of a single machine
            // and the maximum flow across any boundary.
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(currentFlux), balance));
        }

        return maxMoves;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,0,5] -> 3
        int[] m1 = { 1, 0, 5 };
        System.out.println("Result 1: " + sol.findMinMoves(m1) + " (Expected: 3)");

        // [0,3,0] -> 2
        int[] m2 = { 0, 3, 0 };
        System.out.println("Result 2: " + sol.findMinMoves(m2) + " (Expected: 2)");

        // [0,2,0] -> -1
        int[] m3 = { 0, 2, 0 };
        System.out.println("Result 3: " + sol.findMinMoves(m3) + " (Expected: -1)");
    }
}
