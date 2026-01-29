package leetcode.P397_IntegerReplacement;

public class Solution {

    /**
     * Problem 397: Integer Replacement
     * Approach: Greedy (Bit Manipulation)
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int integerReplacement(int n) {
        long num = n; // Use long to handle Integer.MAX_VALUE + 1
        int steps = 0;

        while (num > 1) {
            steps++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                if (num == 3 || (num & 2) == 0) {
                    // Ends in ...01 or is 3
                    num--;
                } else {
                    // Ends in ...11
                    num++;
                }
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 8 -> 3
        runTest(solution, 8, 3);

        // 7 -> 4
        runTest(solution, 7, 4);

        // 4 -> 2
        runTest(solution, 4, 2);

        // 2147483647 -> 32
        runTest(solution, Integer.MAX_VALUE, 32);
    }

    private static void runTest(Solution sol, int n, int expected) {
        int result = sol.integerReplacement(n);
        System.out.println("n: " + n + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
