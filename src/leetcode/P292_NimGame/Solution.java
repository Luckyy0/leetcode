package leetcode.P292_NimGame;

public class Solution {

    /**
     * Problem 292: Nim Game
     * Approach: Math (Modulo)
     * 
     * Theoretical Basis:
     * - Winning states map to n % 4 != 0.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 4 -> false
        runTest(solution, 4, false);

        // 1 -> true
        runTest(solution, 1, true);

        // 2 -> true
        runTest(solution, 2, true);
    }

    private static void runTest(Solution s, int n, boolean expected) {
        boolean result = s.canWinNim(n);
        System.out.println("n=" + n + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
