package leetcode.P290_WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 290: Word Pattern
     * Approach: Two HashMaps (Bijection)
     * 
     * Theoretical Basis:
     * - Ensure 1-to-1 mapping between char and word.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(M)
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            // Check char mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) {
                    return false;
                }
            } else {
                // If char is new, word must also be new
                if (wordToChar.containsKey(w)) {
                    return false;
                }

                charToWord.put(c, w);
                wordToChar.put(w, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "abba", "dog cat cat dog" -> true
        runTest(solution, "abba", "dog cat cat dog", true);

        // "abba", "dog cat cat fish" -> false
        runTest(solution, "abba", "dog cat cat fish", false);

        // "aaaa", "dog cat cat dog" -> false
        runTest(solution, "aaaa", "dog cat cat dog", false);
    }

    private static void runTest(Solution s, String pattern, String str, boolean expected) {
        boolean result = s.wordPattern(pattern, str);
        System.out
                .println("Pattern: " + pattern + ", S: \"" + str + "\" -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
