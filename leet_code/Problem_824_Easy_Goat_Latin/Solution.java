package leet_code.Problem_824_Easy_Goat_Latin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Converts a sentence to Goat Latin.
     * Strategy: Split sentence into words, apply rules per word, and join back.
     * Time: O(N + W^2), Space: O(N + W^2).
     */
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        String[] words = sentence.split(" ");
        StringBuilder finalSentence = new StringBuilder();

        // Progressively building suffix "a", "aa", "aaa", ...
        StringBuilder currentSuffixA = new StringBuilder("a");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);

            // Rule 1 & 2
            if (vowels.contains(firstChar)) {
                finalSentence.append(word);
            } else {
                finalSentence.append(word.substring(1));
                finalSentence.append(firstChar);
            }

            // Add "ma" and the required number of 'a's (Rule 3)
            finalSentence.append("ma");
            finalSentence.append(currentSuffixA);

            // Add space between words
            if (i != words.length - 1) {
                finalSentence.append(" ");
            }

            // Augment the suffix for the next word
            currentSuffixA.append("a");
        }

        return finalSentence.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.toGoatLatin("I speak Goat Latin"));
        // Imaa peaksmaaa oatGmaaaa atinLmaaaaa

        System.out.println("Result 2: " + sol.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa
        // azylmaaaaaaaaa ogdmaaaaaaaaaa
    }
}
