package leetcode.P820_ShortEncodingOfWords;

import java.util.*;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));

        for (String w : words) {
            // Remove all proper suffixes of w
            // Loai bo tat ca cac hau to cua w
            for (int i = 1; i < w.length(); i++) {
                set.remove(w.substring(i));
            }
        }

        int res = 0;
        for (String w : set) {
            res += w.length() + 1; // +1 for the #
        }
        return res;
    }
}
