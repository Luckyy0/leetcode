package leetcode.P734_SentenceSimilarity;

import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            String u = pair.get(0);
            String v = pair.get(1);
            map.putIfAbsent(u, new HashSet<>());
            map.putIfAbsent(v, new HashSet<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];

            if (w1.equals(w2))
                continue;
            if (!map.containsKey(w1) || !map.get(w1).contains(w2))
                return false;
        }

        return true;
    }
}
