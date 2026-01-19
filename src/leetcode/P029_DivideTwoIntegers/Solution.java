package leetcode.P029_DivideTwoIntegers;

public class Solution {

    /**
     * Problem 29: Divide Two Integers
     * Approach: Bit Manipulation (Shift & Subtract)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int divide(int dividend, int divisor) {
        // Special Case: Overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Use long to prevent overflow during absolute value conversion
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int quotient = 0;

        // Loop while dividend >= divisor
        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // Find the largest multiple of divisor (b * 2^k) that fits in a
            // Tìm bội số lớn nhất của divisor (b * 2^k) mà nằm trong a
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 10, 3, 3);
        runTest(solution, 7, -3, -2);
        runTest(solution, -2147483648, -1, 2147483647);
        runTest(solution, 1, 1, 1);
    }

    private static void runTest(Solution s, int dividend, int divisor, int expected) {
        System.out.println("Dividend: " + dividend + ", Divisor: " + divisor);
        int result = s.divide(dividend, divisor);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
