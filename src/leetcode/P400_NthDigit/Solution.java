package leetcode.P400_NthDigit;

public class Solution {

    /**
     * Problem 400: Nth Digit
     * Approach: Mathematical Calculation
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        long start = 1;

        // Step 1: Find the length of the number
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        // Step 2: Find the actual number
        // n is now 1-indexed relative to the start of len-digit numbers
        long targetNum = start + (n - 1) / len;

        // Step 3: Find the digit in the target number
        String s = String.valueOf(targetNum);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 3 -> 3
        runTest(solution, 3, 3);

        // 11 -> 0
        runTest(solution, 11, 0);

        // 1000 -> 3
        // Sequence: 1-9 (9), 10-99 (180), 100-333...
        // 1000 - 9 - 180 = 811.
        // 811 / 3 = 270.33 -> 270 numbers after 99. 100+270 = 370.
        // digit index: 811 % 3 = 1 -> index 0 of 370 is 3.
        runTest(solution, 1000, 3);
    }

    private static void runTest(Solution sol, int n, int expected) {
        int result = sol.findNthDigit(n);
        System.out.println("n: " + n + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
