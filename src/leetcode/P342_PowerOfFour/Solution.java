package leetcode.P342_PowerOfFour;

public class Solution {

    /**
     * Problem 342: Power of Four
     * Approach: Bit Manipulation
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isPowerOfFour(int n) {
        // n > 0
        // Power of 2: (n & (n - 1)) == 0
        // Bit at even position (0, 2, 4...): (n & 0x55555555) != 0
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 16 -> true
        runTest(solution, 16, true);

        // 5 -> false
        runTest(solution, 5, false);

        // 1 -> true
        runTest(solution, 1, true);

        // 8 -> false (Power of 2, but not 4)
        runTest(solution, 8, false);
    }

    private static void runTest(Solution s, int n, boolean expected) {
        boolean result = s.isPowerOfFour(n);
        System.out.println("n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
