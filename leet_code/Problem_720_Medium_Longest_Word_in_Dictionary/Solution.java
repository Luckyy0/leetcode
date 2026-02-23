package leet_code.Problem_720_Medium_Longest_Word_in_Dictionary;

import java.util.*;

public class Solution {

    /**
     * Finds the longest word buildable one char at a time.
     * Strategy: Sort lexicographically and propagate valid prefixes via HashSet.
     * Time: O(N log N * L), Space: O(N * L).
     */
    public String longestWord(String[] words) {
        // Sort lexicographically
        Arrays.sort(words);

        Set<String> builtSet = new HashSet<>();
        builtSet.add(""); // Base empty prefix
        String ans = "";

        for (String word : words) {
            // Check if the prefix (word minus last char) is in our valid set
            String prefix = word.substring(0, word.length() - 1);
            if (builtSet.contains(prefix)) {
                builtSet.add(word);
                // Update ans if current word is longer
                // Due to sorting, we don't need to check dictionary order if lengths are same
                if (word.length() > ans.length()) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] w1 = { "w", "wo", "wor", "worl", "world" };
        System.out.println("Result 1: " + sol.longestWord(w1)); // world

        String[] w2 = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println("Result 2: " + sol.longestWord(w2)); // apple
    }
}
