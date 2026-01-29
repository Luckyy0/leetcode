package leetcode.P2131_LongestPalindromeByConcatenatingTwoLetterWords;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words)
            freq.put(w, freq.getOrDefault(w, 0) + 1);

        int length = 0;
        boolean hasMiddle = false;

        for (String key : freq.keySet()) {
            if (key.charAt(0) == key.charAt(1)) {
                // Same char like "aa"
                int count = freq.get(key);
                length += (count / 2) * 4;
                if (count % 2 == 1)
                    hasMiddle = true;
            } else {
                // Diff char like "ab"
                String rev = "" + key.charAt(1) + key.charAt(0);
                // To minimize double counting, only process if key < rev
                if (key.compareTo(rev) < 0 && freq.containsKey(rev)) {
                    int c1 = freq.get(key);
                    int c2 = freq.get(rev);
                    length += Math.min(c1, c2) * 4;
                }
            }
        }

        if (hasMiddle)
            length += 2;

        return length;
    }
}
