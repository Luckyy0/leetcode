package leetcode.P1624_LargestSubstringBetweenTwoEqualCharacters;

import java.util.Arrays;

public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxLen = -1;

        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            if (firstIndex[charIdx] != -1) {
                maxLen = Math.max(maxLen, i - firstIndex[charIdx] - 1);
            } else {
                firstIndex[charIdx] = i;
            }
        }

        return maxLen;
    }
}
