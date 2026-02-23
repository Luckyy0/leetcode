package leet_code.Problem_648_Medium_Replace_Words;

import java.util.*;

public class Solution_Trie {

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfRoot;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfRoot = false;
        }
    }

    private TrieNode root;

    /**
     * Replaces words in a sentence with their shortest matching roots from
     * dictionary.
     * Strategy: Use a Trie to store roots and find the shortest prefix for each
     * word.
     * Time: O(D + S), Space: O(D * 26).
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        // Build Trie from dictionary
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0)
                result.append(" ");
            result.append(findRoot(words[i]));
        }

        return result.toString();
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfRoot = true;
    }

    private String findRoot(String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return word; // No root found in dictionary
            }
            curr = curr.children[c - 'a'];
            prefix.append(c);
            if (curr.isEndOfRoot) {
                return prefix.toString(); // Found shortest root
            }
        }
        return word;
    }

    public static void main(String[] args) {
        Solution_Trie sol = new Solution_Trie();
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(sol.replaceWords(dictionary, sentence));
        // Output: "the cat was rat by the bat"
    }
}
