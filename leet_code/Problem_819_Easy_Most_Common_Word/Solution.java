package leet_code.Problem_819_Easy_Most_Common_Word;

import java.util.*;

public class Solution {

    /**
     * Finds the most frequent non-banned word in a paragraph.
     * Strategy: Normalize string using regex, use HashSet for banned words, and
     * HashMap for counts.
     * Time: O(P + B), Space: O(P + B).
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        // Convert banned array to set for fast lookup
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }

        // Clean paragraph: to lowercase and replace non-alphabetical with space
        // regex [^a-z] matches any character NOT between a and z
        // the '+' means one or more.
        String[] words = paragraph.toLowerCase().split("[^a-z]+");

        Map<String, Integer> counts = new HashMap<>();
        String result = "";
        int maxCount = 0;

        for (String word : words) {
            // Split may produce empty strings if punctuation is at the edges
            if (word.isEmpty())
                continue;

            if (!bannedSet.contains(word)) {
                int count = counts.getOrDefault(word, 0) + 1;
                counts.put(word, count);

                // Keep track of the most frequent word so far
                if (count > maxCount) {
                    maxCount = count;
                    result = word;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String p1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b1 = { "hit" };
        System.out.println("Result 1: " + sol.mostCommonWord(p1, b1)); // ball

        String p2 = "a.";
        String[] b2 = {};
        System.out.println("Result 2: " + sol.mostCommonWord(p2, b2)); // a
    }
}
