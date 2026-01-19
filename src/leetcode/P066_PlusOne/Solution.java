package leetcode.P066_PlusOne;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 66: Plus One
     * Approach: Iterate Backwards
     * Time Complexity: O(n)
     * Space Complexity: O(1) or O(n) for resize
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If we're here, all digits were 9
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        // Rest are 0 by default
        return newDigits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 });
        runTest(solution, new int[] { 4, 3, 2, 1 }, new int[] { 4, 3, 2, 2 });
        runTest(solution, new int[] { 9 }, new int[] { 1, 0 });
        runTest(solution, new int[] { 9, 9 }, new int[] { 1, 0, 0 });
    }

    private static void runTest(Solution s, int[] digits, int[] expected) {
        System.out.println("Input: " + Arrays.toString(digits));
        // Note: Java passes array by reference, so digits will be modified.
        // For testing display, we printed before calling.
        int[] result = s.plusOne(digits);
        System.out.println("Output: " + Arrays.toString(result) + " (Expected: " + Arrays.toString(expected) + ")");

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
