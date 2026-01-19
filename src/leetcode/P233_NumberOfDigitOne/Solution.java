package leetcode.P233_NumberOfDigitOne;

public class Solution {

    /**
     * Problem 233: Number of Digit One
     * Approach: Digit Position Counting (Math)
     * 
     * Theoretical Basis:
     * - Iterate position i: 1, 10, 100...
     * - Count occurrences of 1 at current position i driven by higher and lower
     * bits.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int countDigitOne(int n) {
        int count = 0;

        // Use long for i to avoid overflow when i * 10
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;

            // Full blocks count
            // Each full block of size (i*10) contains 'i' sequences where digit at pos 'i'
            // is 1.
            // Example i=1: 0-9 has one 1. i=10: 0-99 has ten 1s at tens place (10-19).
            count += (n / divider) * i;

            // Partial block count
            // Look at remainder: range [0, 2*i - 1] contains 1s.
            // Specifically, range [i, 2*i - 1] has 1 at position.
            // Max number of 1s we can get from remainder is 'i'.
            long remainder = n % divider;

            // Check intersection of remainder with [i, 2*i - 1]
            // We want count of numbers in remainder >= i.
            // But if remainder >= 2*i, we just take 'i' (full set).
            // If remainder < i, we take 0.
            // If i <= remainder < 2*i, we take (remainder - i + 1).

            count += Math.min(Math.max(remainder - i + 1, 0), i);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 13 -> 6
        // 1, 10, 11, 12, 13
        runTest(solution, 13, 6);

        // 0 -> 0
        runTest(solution, 0, 0);

        // 100 -> 21
        // (n/10 * 1) + ...
        // ones: 10 * 1 + 1 (100 has 0) -> 10? No.
        // Hand calculation for 100:
        // Ones: 1, 11, 21 ... 91 (10 numbers) + 100 -> 10 numbers? 0..100.
        // 1, 11, ..., 91 -> 10.
        // Tens: 10-19 -> 10 numbers.
        // Hundreds: 100 -> 1 number. Total 21.
        runTest(solution, 100, 21);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.countDigitOne(n);
        System.out.println("Input: " + n + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
