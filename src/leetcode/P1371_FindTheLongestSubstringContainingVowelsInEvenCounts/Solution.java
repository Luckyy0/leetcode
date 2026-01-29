package leetcode.P1371_FindTheLongestSubstringContainingVowelsInEvenCounts;

import java.util.Arrays;

class Solution {
    public int findTheLongestSubstring(String s) {
        int[] firstOccurrence = new int[32];
        Arrays.fill(firstOccurrence, -2);
        firstOccurrence[0] = -1;

        int state = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                state ^= (1 << 0);
            else if (c == 'e')
                state ^= (1 << 1);
            else if (c == 'i')
                state ^= (1 << 2);
            else if (c == 'o')
                state ^= (1 << 3);
            else if (c == 'u')
                state ^= (1 << 4);

            if (firstOccurrence[state] != -2) {
                maxLen = Math.max(maxLen, i - firstOccurrence[state]);
            } else {
                firstOccurrence[state] = i;
            }
        }

        return maxLen;
    }
}
