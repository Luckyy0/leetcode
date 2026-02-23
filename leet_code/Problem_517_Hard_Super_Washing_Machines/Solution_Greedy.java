package leet_code.Problem_517_Hard_Super_Washing_Machines;

public class Solution_Greedy {

    /**
     * Finds min moves to balance machines.
     * Strategy: Track prefix balance and local excess.
     * Time: O(N), Space: O(1).
     */
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines)
            total += m;

        int n = machines.length;
        if (total % n != 0)
            return -1;

        int avg = total / n;
        int balance = 0;
        int maxMoves = 0;

        for (int m : machines) {
            int diff = m - avg;
            balance += diff;

            // The constraint is determined by:
            // 1. The flow passing through this point (abs(balance))
            // 2. The pure output this machine must produce (diff)
            // Note: If diff is negative (receiving), it doesn't limit moves by itself
            // (neighbors can help).
            // But if diff is positive, this machine must output diff items one by one.

            maxMoves = Math.max(maxMoves, Math.max(Math.abs(balance), diff));
        }

        return maxMoves;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[] machines = { 1, 0, 5 };
        System.out.println("Result: " + solution.findMinMoves(machines)); // 3
    }
}
