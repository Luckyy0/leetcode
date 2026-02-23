package leet_code.Problem_670_Medium_Maximum_Swap;

import java.util.*;

public class Solution {

    /**
     * Finds the maximum number achievable by swapping two digits at most once.
     * Strategy: Greedy - find the leftmost digit that can be swapped with a larger
     * digit appearing later.
     * Time: O(N), Space: O(N).
     */
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        // Record the last occurrence of each digit 0-9
        int[] last = new int[10];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }

        // Traverse from left to right to find the first improvable digit
        for (int i = 0; i < n; i++) {
            int currentDigit = digits[i] - '0';

            // Check if any digit larger than currentDigit appears later than index i
            for (int d = 9; d > currentDigit; d--) {
                if (last[d] > i) {
                    // Swap and return immediately
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result for 2736: " + sol.maximumSwap(2736)); // 7236
        System.out.println("Result for 9973: " + sol.maximumSwap(9973)); // 9973
    }
}
