package leet_code.Problem_737_Medium_Sentence_Similarity_II;

import java.util.*;

public class Solution {

    /**
     * Checks if two sentences are similar given a list of similar pairs
     * (transitive).
     * Strategy: Disjoint Set Union (DSU) with a Map for strings.
     * Time: O(P + S), Space: O(P).
     */
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, String> parent = new HashMap<>();

        // Union words in similarPairs
        for (List<String> pair : similarPairs) {
            String u = pair.get(0);
            String v = pair.get(1);
            union(parent, u, v);
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];

            if (w1.equals(w2))
                continue;

            // Check if they share the same root in DSU
            if (!find(parent, w1).equals(find(parent, w2))) {
                return false;
            }
        }

        return true;
    }

    private String find(Map<String, String> parent, String s) {
        if (!parent.containsKey(s)) {
            parent.put(s, s);
            return s;
        }
        if (parent.get(s).equals(s)) {
            return s;
        }
        // Path compression
        parent.put(s, find(parent, parent.get(s)));
        return parent.get(s);
    }

    private void union(Map<String, String> parent, String s1, String s2) {
        String root1 = find(parent, s1);
        String root2 = find(parent, s2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s1 = { "great", "acting", "skills" };
        String[] s2 = { "fine", "drama", "talent" };
        List<List<String>> pairs = Arrays.asList(
                Arrays.asList("great", "good"),
                Arrays.asList("fine", "good"),
                Arrays.asList("drama", "acting"),
                Arrays.asList("skills", "talent"));
        System.out.println("Result: " + sol.areSentencesSimilarTwo(s1, s2, pairs)); // true
    }
}
