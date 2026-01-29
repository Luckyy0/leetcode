package leetcode.P2067_NumberOfEqualCountSubstrings;

public class Solution {
    public int equalCountSubstrings(String s, int count) {
        int n = s.length();
        int res = 0;

        // Iterate number of unique characters u from 1 to 26
        for (int u = 1; u <= 26; u++) {
            int len = u * count;
            if (len > n)
                break;

            // Sliding window of fixed size len
            int[] freq = new int[26];
            int validChars = 0; // Chars with freq == count
            // Note: need to ensure NO char has freq != count (except 0)
            // But if total length is u*count, and we have `validChars` valid,
            // validChars * count == length implies everything is valid (0 or count).
            // So just check validChars == u.

            for (int i = 0; i < n; i++) {
                // Add right
                int charIdx = s.charAt(i) - 'a';
                freq[charIdx]++;
                if (freq[charIdx] == count)
                    validChars++;
                if (freq[charIdx] == count + 1)
                    validChars--;

                // Remove left
                if (i >= len) {
                    int leftIdx = s.charAt(i - len) - 'a';
                    if (freq[leftIdx] == count)
                        validChars--;
                    freq[leftIdx]--;
                    if (freq[leftIdx] == count)
                        validChars++;
                }

                // Check
                if (i >= len - 1) {
                    if (validChars == u)
                        res++;
                }
            }
        }

        return res;
    }
}
