package leetcode.P2083_SubstringsThatBeginAndEndWithTheSameLetter;

public class Solution {
    public long numberOfSubstrings(String s) {
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long total = 0;
        for (long f : freq) {
            total += f * (f + 1) / 2;
        }
        return total;
    }
}
