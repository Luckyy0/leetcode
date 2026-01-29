package leetcode.P326_PowerOfThree;

public class Solution {

    /**
     * Problem 326: Power of Three
     * Approach: Integer Limit Check
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19, the largest power of 3 fitting in Integer.MAX_VALUE
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 27 -> true
        runTest(solution, 27, true);

        // 0 -> false
        runTest(solution, 0, false);

        // 9 -> true
        runTest(solution, 9, true);

        // 45 -> false
        runTest(solution, 45, false);
    }

    private static void runTest(Solution s, int n, boolean expected) {
        boolean result = s.isPowerOfThree(n);
        System.out.println("n: " + n + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
