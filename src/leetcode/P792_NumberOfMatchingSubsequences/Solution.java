package leetcode.P792_NumberOfMatchingSubsequences;

import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // 26 buckets for each letter a-z
        List<StringBuilder>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            heads[i] = new ArrayList<>();

        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }

        int count = 0;
        for (char c : s.toCharArray()) {
            List<StringBuilder> oldBucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();

            for (StringBuilder wordSb : oldBucket) {
                wordSb.deleteCharAt(0);
                if (wordSb.length() == 0) {
                    count++;
                } else {
                    heads[wordSb.charAt(0) - 'a'].add(wordSb);
                }
            }
        }

        return count;
    }
}
