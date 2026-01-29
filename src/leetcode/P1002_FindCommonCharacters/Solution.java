package leetcode.P1002_FindCommonCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String w : words) {
            int[] charFreq = new int[26];
            for (char c : w.toCharArray()) {
                charFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                res.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        return res;
    }
}
