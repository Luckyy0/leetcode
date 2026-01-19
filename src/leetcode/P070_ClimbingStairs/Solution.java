package leetcode.P070_ClimbingStairs;

public class Solution {

    /**
     * Problem 70: Climbing Stairs
     * Approach: Dynamic Programming (Iterative)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int prev2 = 1;
        int prev1 = 2;
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 2, 2);
        runTest(solution, 3, 3);
        runTest(solution, 4, 5);
        runTest(solution, 5, 8);
    }

    private static void runTest(Solution s, int n, int expected) {
        System.out.println("Input: " + n);
        int result = s.climbStairs(n);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
