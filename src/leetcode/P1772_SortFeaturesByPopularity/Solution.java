package leetcode.P1772_SortFeaturesByPopularity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> counts = new HashMap<>();
        // Initialize counts to 0 to handle unused features
        for (String f : features)
            counts.put(f, 0);

        for (String res : responses) {
            String[] words = res.split(" ");
            Set<String> uniqueWords = new HashSet<>();
            for (String w : words)
                uniqueWords.add(w);

            for (String w : uniqueWords) {
                if (counts.containsKey(w)) {
                    counts.put(w, counts.get(w) + 1);
                }
            }
        }

        Map<String, Integer> initialOrder = new HashMap<>();
        for (int i = 0; i < features.length; i++) {
            initialOrder.put(features[i], i);
        }

        Arrays.sort(features, (a, b) -> {
            int ca = counts.get(a);
            int cb = counts.get(b);
            if (ca != cb)
                return cb - ca; // Descending
            return initialOrder.get(a) - initialOrder.get(b); // Ascending order
        });

        return features;
    }
}
