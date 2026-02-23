package leet_code.Problem_820_Medium_Short_Encoding_of_Words;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Calculates the length of the shortest encoding reference string.
     * Strategy: Remove any word that is a suffix of another word.
     * Time: O(Sum(W_i^2)), Space: O(Sum(W_i)).
     */
    public int minimumLengthEncoding(String[] words) {
        // Use a set to store unique words and allow fast removals
        Set<String> set = new HashSet<>(Arrays.asList(words));

        // Iterate through all words and check their suffixes
        for (String word : words) {
            // For each word, generate all proper suffixes (excluding the word itself)
            // Example for "time": "ime", "me", "e"
            for (int i = 1; i < word.length(); i++) {
                String suffix = word.substring(i);
                // If a suffix is present as a standalone word, it's redundant
                set.remove(suffix);
            }
        }

        // Sum the length of remaining unique "root" words
        int totalLength = 0;
        for (String word : set) {
            // Each encoded word in s ends with a '#'
            totalLength += word.length() + 1;
        }

        return totalLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] w1 = { "time", "me", "bell" };
        System.out.println("Result 1: " + sol.minimumLengthEncoding(w1)); // 10

        String[] w2 = { "t" };
        System.out.println("Result 2: " + sol.minimumLengthEncoding(w2)); // 2
    }
}
