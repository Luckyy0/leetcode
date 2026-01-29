package leetcode.P1657_DetermineIfTwoStringsAreClose;

import java.util.Arrays;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray())
            freq1[c - 'a']++;
        for (char c : word2.toCharArray())
            freq2[c - 'a']++;

        // Check 1: Must have same set of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Check 2: Must have same multiset of frequencies
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
