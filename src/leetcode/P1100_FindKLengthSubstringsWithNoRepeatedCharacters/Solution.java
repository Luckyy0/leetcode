package leetcode.P1100_FindKLengthSubstringsWithNoRepeatedCharacters;

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26 || k > s.length())
            return 0;

        int[] count = new int[26];
        int repeats = 0;
        int res = 0;

        // Init window
        for (int i = 0; i < k; i++) {
            int idx = s.charAt(i) - 'a';
            count[idx]++;
            if (count[idx] == 2)
                repeats++;
        }

        if (repeats == 0)
            res++;

        // Slide
        for (int i = k; i < s.length(); i++) {
            // Remove old
            int oldIdx = s.charAt(i - k) - 'a';
            count[oldIdx]--;
            if (count[oldIdx] == 1)
                repeats--;

            // Add new
            int newIdx = s.charAt(i) - 'a';
            count[newIdx]++;
            if (count[newIdx] == 2)
                repeats++;

            if (repeats == 0)
                res++;
        }

        return res;
    }
}
