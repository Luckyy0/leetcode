package leetcode.P390_EliminationGame;

public class Solution {

    /**
     * Problem 390: Elimination Game
     * Approach: Mathematical Simulation
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean left = true;

        while (remaining > 1) {
            // If going left, or going right but odd count, head moves
            if (left || remaining % 2 == 1) {
                head += step;
            }

            remaining /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 9 -> 6
        runTest(solution, 9, 6);

        // 1 -> 1
        runTest(solution, 1, 1);

        // 10 -> 8
        runTest(solution, 10, 8);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.lastRemaining(n);
        System.out.println("n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
