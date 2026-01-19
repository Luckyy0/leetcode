package leetcode.P263_UglyNumber;

public class Solution {

    /**
     * Problem 263: Ugly Number
     * Approach: Division by 2, 3, 5
     * 
     * Theoretical Basis:
     * - Reduce n by dividing out all factors of 2, 3, 5.
     * - If result is 1, it's ugly.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;

        return n == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 6 -> true
        runTest(solution, 6, true);

        // 1 -> true
        runTest(solution, 1, true);

        // 14 -> false
        runTest(solution, 14, false);

        // -6 -> false
        runTest(solution, -6, false);
    }

    private static void runTest(Solution s, int n, boolean expected) {
        boolean result = s.isUgly(n);
        System.out.println("Input: " + n + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
