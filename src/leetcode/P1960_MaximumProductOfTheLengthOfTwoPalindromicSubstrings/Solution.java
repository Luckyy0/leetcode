package leetcode.P1960_MaximumProductOfTheLengthOfTwoPalindromicSubstrings;

public class Solution {
    public long maxProduct(String s) {
        int n = s.length();
        int[] P = manacher(s);

        long[] maxLeft = new long[n];
        long[] maxRight = new long[n];

        // Calculate maxLeft
        // 1. Mark max length ending at specific index
        for (int i = 0; i < n; i++) {
            int r = P[i];
            int end = i + r;
            int start = i - r; // Included
            // Only odd length palindromes. Length is 2*r + 1.
            // Wait, Manacher P[i] is radius excluding center? Usually.
            // If length 1 ('a'), r=0. Len = 1.
            // If length 3 ('aba'), r=1. Len 3.
            // My manacher below returns P[i] where length is 2*P[i]+1.

            // We want maxLeft[end] >= 2*r+1.
            // But we actually only care about start/end.
            if (end < n)
                maxLeft[end] = Math.max(maxLeft[end], 2L * r + 1);
        }

        // 2. Propagate backwards: if palindrome of len L ends at i, len L-2 ends at i-1
        for (int i = n - 2; i >= 0; i--) {
            maxLeft[i] = Math.max(maxLeft[i], maxLeft[i + 1] - 2);
        }

        // 3. Propagate forwards: maxLeft[i] is max(maxLeft[i], maxLeft[i-1]) meaning
        // max in range [0...i]
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i], maxLeft[i - 1]);
        }

        // Calculate maxRight (Symmetric)
        for (int i = 0; i < n; i++) {
            int r = P[i];
            int start = i - r;
            if (start >= 0)
                maxRight[start] = Math.max(maxRight[start], 2L * r + 1);
        }

        for (int i = 1; i < n; i++) {
            maxRight[i] = Math.max(maxRight[i], maxRight[i - 1] - 2);
        }

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i], maxRight[i + 1]);
        }

        long maxProd = 0;
        // Split between i and i+1.
        // Left ends at i. Right starts at i+1.
        for (int i = 0; i < n - 1; i++) {
            maxProd = Math.max(maxProd, maxLeft[i] * maxRight[i + 1]);
        }

        return maxProd;
    }

    private int[] manacher(String s) {
        int n = s.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 0; i < n; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);
            } else {
                P[i] = 0;
            }

            while (i - 1 - P[i] >= 0 && i + 1 + P[i] < n && s.charAt(i - 1 - P[i]) == s.charAt(i + 1 + P[i])) {
                P[i]++;
            }

            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        return P;
    }
}
