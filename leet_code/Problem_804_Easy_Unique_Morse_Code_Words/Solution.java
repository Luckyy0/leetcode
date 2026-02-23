package leet_code.Problem_804_Easy_Unique_Morse_Code_Words;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Counts the number of unique Morse code transformations.
     * Strategy: Use a HashSet to store unique string transformations.
     * Time: O(S), Space: O(S).
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        Set<String> uniqueTransformations = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            uniqueTransformations.add(sb.toString());
        }

        return uniqueTransformations.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words1 = { "gin", "zen", "gig", "msg" };
        System.out.println("Result 1: " + sol.uniqueMorseRepresentations(words1)); // 2

        String[] words2 = { "a" };
        System.out.println("Result 2: " + sol.uniqueMorseRepresentations(words2)); // 1
    }
}
