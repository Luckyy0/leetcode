package leetcode.P231_PowerOfTwo;

public class Solution {

    /**
     * Problem 231: Power of Two
     * Approach: Bit Manipulation
     * 
     * Theoretical Basis:
     * - Powers of two have exactly one bit set.
     * - (n & (n - 1)) == 0 checks if there is only one bit set.
     * - Must ensure n > 0.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 -> true
        runTest(solution, 1, true);

        // 16 -> true
        runTest(solution, 16, true);

        // 3 -> false
        runTest(solution, 3, false);

        // 0 -> false
        runTest(solution, 0, false);

        // -16 -> false
        runTest(solution, -16, false);
    }

    private static void runTest(Solution s, int n, boolean expected) {
        boolean result = s.isPowerOfTwo(n);
        System.out.println("Input: " + n + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
