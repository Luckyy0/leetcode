package leetcode.P916_WordSubsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] bFreq = count(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], bFreq[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (String a : words1) {
            int[] aFreq = count(a);
            boolean universal = true;
            for (int i = 0; i < 26; i++) {
                if (aFreq[i] < maxFreq[i]) {
                    universal = false;
                    break;
                }
            }
            if (universal)
                res.add(a);
        }
        return res;
    }

    private int[] count(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;
        return f;
    }
}
