package leet_code.Problem_738_Medium_Monotone_Increasing_Digits;

import java.util.*;

public class Solution {

    /**
     * Finds the largest integer <= n with monotone increasing digits.
     * Strategy: Greedy scanning from right to left.
     * Time: O(D), Space: O(D).
     */
    public int monotoneIncreasingDigits(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int marker = s.length;

        // Scan from right to left
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i - 1] > s[i]) {
                // If violation found, decrement left digit
                s[i - 1]--;
                // All digits to the right should become '9'
                marker = i;
            }
        }

        // Fill with '9' from the earliest marker
        for (int i = marker; i < s.length; i++) {
            s[i] = '9';
        }

        return Integer.parseInt(new String(s));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.monotoneIncreasingDigits(10)); // 9
        System.out.println(sol.monotoneIncreasingDigits(1234)); // 1234
        System.out.println(sol.monotoneIncreasingDigits(332)); // 299
    }
}
