package leet_code.Problem_734_Easy_Sentence_Similarity;

import java.util.*;

public class Solution {

    /**
     * Checks if two sentences are similar given a list of similar pairs.
     * Strategy: Store pairs in a HashSet for O(1) lookup. Similarity is NOT
     * transitive.
     * Time: O(N + P), Space: O(P).
     */
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // Condition 1: Length must be same
        if (sentence1.length != sentence2.length) {
            return false;
        }

        // Store pairs in a Set for quick retrieval
        // "word1#word2" format to distinguish between pairs
        Set<String> set = new HashSet<>();
        for (List<String> pair : similarPairs) {
            set.add(pair.get(0) + "#" + pair.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];

            // Words are similar if:
            // 1. They are the same word
            // 2. The pair (w1, w2) exists in set
            // 3. The pair (w2, w1) exists in set
            if (!w1.equals(w2) &&
                    !set.contains(w1 + "#" + w2) &&
                    !set.contains(w2 + "#" + w1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s1 = { "great", "acting", "skills" };
        String[] s2 = { "fine", "drama", "talent" };
        List<List<String>> pairs = Arrays.asList(
                Arrays.asList("great", "fine"),
                Arrays.asList("drama", "acting"),
                Arrays.asList("skills", "talent"));
        System.out.println("Result: " + sol.areSentencesSimilar(s1, s2, pairs)); // true
    }
}
