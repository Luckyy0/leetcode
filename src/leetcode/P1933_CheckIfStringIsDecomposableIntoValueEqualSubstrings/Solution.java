package leetcode.P1933_CheckIfStringIsDecomposableIntoValueEqualSubstrings;

public class Solution {
    public boolean isDecomposable(String s) {
        int n = s.length();
        int i = 0;
        int twoCount = 0;

        while (i < n) {
            char c = s.charAt(i);
            int start = i;
            while (i < n && s.charAt(i) == c) {
                i++;
            }
            int len = i - start;

            if (len % 3 == 0) {
                // All 3s, contributes 0 twos
                continue;
            } else if (len % 3 == 1) {
                // e.g. 1 (impossible), 4 (2+2), 7 (3+2+2)...
                // Requires at least two 2s. But we are only allowed ONE 2 in total string.
                // So this immediately invalidates.
                return false;
            } else { // len % 3 == 2
                // e.g. 2, 5 (3+2), 8 (3+3+2)
                // Exactly one 2 needed for this block.
                twoCount++;
            }
        }

        return twoCount == 1;
    }
}
