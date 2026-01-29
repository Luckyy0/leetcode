package leetcode.P1888_MinimumNumberOfFlipsToMakeTheBinaryStringAlternating;

public class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int minFlips = Integer.MAX_VALUE;

        // Target 1: 010101...
        // Target 2: 101010...
        int mismatches1 = 0;
        int mismatches2 = 0;

        // Process a window of size n over s+s (virtually)
        // Concatenated length is 2n.
        // We really care about windows starting at 0 to n-1.
        // Loop up to 2n - 1.

        for (int i = 0; i < 2 * n; i++) {
            char curr = s.charAt(i % n);

            // Logic for adding element at i
            char t1 = (i % 2 == 0) ? '0' : '1';
            char t2 = (i % 2 == 0) ? '1' : '0';

            if (curr != t1)
                mismatches1++;
            if (curr != t2)
                mismatches2++;

            // If window size exceeds n, remove element at i - n
            if (i >= n) {
                char removed = s.charAt((i - n) % n);
                char r1 = ((i - n) % 2 == 0) ? '0' : '1';
                char r2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (removed != r1)
                    mismatches1--;
                if (removed != r2)
                    mismatches2--;
            }

            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(mismatches1, mismatches2));
            }
        }

        return minFlips;
    }
}
