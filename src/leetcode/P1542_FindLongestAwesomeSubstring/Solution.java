package leetcode.P1542_FindLongestAwesomeSubstring;

import java.util.Arrays;

class Solution {
    public int longestAwesome(String s) {
        int[] seen = new int[1024];
        Arrays.fill(seen, -2);
        seen[0] = -1;

        int mask = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            mask ^= (1 << digit);

            if (seen[mask] != -2) {
                maxLen = Math.max(maxLen, i - seen[mask]);
            }

            for (int k = 0; k < 10; k++) {
                int target = mask ^ (1 << k);
                if (seen[target] != -2) {
                    maxLen = Math.max(maxLen, i - seen[target]);
                }
            }

            if (seen[mask] == -2) {
                seen[mask] = i;
            }
        }

        return maxLen;
    }
}
