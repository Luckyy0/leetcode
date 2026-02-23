package leet_code.Problem_676_Medium_Implement_Magic_Dictionary;

import java.util.*;

public class MagicDictionary {

    private String[] words;

    /**
     * Initializes the object.
     */
    public MagicDictionary() {
    }

    /**
     * Sets the data structure with an array of strings.
     * Strategy: Store the dictionary array directly.
     */
    public void buildDict(String[] dictionary) {
        this.words = dictionary;
    }

    /**
     * Returns true if exactly one character in searchWord can be changed to match a
     * dictionary word.
     * Strategy: Iterate through all dictionary words and count differences.
     * Time: O(D * L), Space: O(1) extra.
     */
    public boolean search(String searchWord) {
        for (String word : words) {
            // Must be same length to be a candidate
            if (word.length() != searchWord.length())
                continue;

            int diffCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diffCount++;
                }
                // Optimization: if more than 1 diff found, move to next word
                if (diffCount > 1)
                    break;
            }

            // Requirement is EXACTLY one character change
            if (diffCount == 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] { "hello", "leetcode" });

        System.out.println("Search 'hello': " + magicDictionary.search("hello")); // false
        System.out.println("Search 'hhllo': " + magicDictionary.search("hhllo")); // true
        System.out.println("Search 'hell': " + magicDictionary.search("hell")); // false
        System.out.println("Search 'leetcoded': " + magicDictionary.search("leetcoded")); // false
    }
}
