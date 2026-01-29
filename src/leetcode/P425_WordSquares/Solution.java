package leetcode.P425_WordSquares;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> wordsWithPrefix = new ArrayList<>();
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.wordsWithPrefix.add(word);
        }
    }

    private List<String> findWordsWithPrefix(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return new ArrayList<>();
            }
            curr = curr.children[idx];
        }
        return curr.wordsWithPrefix;
    }

    /**
     * Problem 425: Word Squares
     * Approach: Backtracking with Trie
     * 
     * Time Complexity: O(N * 26^L) worst case, pruned by Trie
     * Space Complexity: O(N * L) for Trie
     */
    public List<List<String>> wordSquares(String[] words) {
        for (String w : words) {
            insert(w);
        }

        List<List<String>> result = new ArrayList<>();
        int wordLen = words[0].length();

        List<String> currentSquare = new ArrayList<>();
        for (String w : words) {
            currentSquare.add(w);
            backtrack(1, wordLen, currentSquare, result);
            currentSquare.remove(currentSquare.size() - 1);
        }

        return result;
    }

    private void backtrack(int row, int wordLen, List<String> currentSquare, List<List<String>> result) {
        if (row == wordLen) {
            result.add(new ArrayList<>(currentSquare));
            return;
        }

        // Build the prefix required for the current row
        StringBuilder prefixBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            prefixBuilder.append(currentSquare.get(i).charAt(row));
        }
        String prefix = prefixBuilder.toString();

        List<String> candidates = findWordsWithPrefix(prefix);
        for (String cand : candidates) {
            currentSquare.add(cand);
            backtrack(row + 1, wordLen, currentSquare, result);
            currentSquare.remove(currentSquare.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["area","ball","dear","lady","lead","yard"]
        String[] words = { "area", "ball", "dear", "lady", "lead", "yard" };
        List<List<String>> squares = solution.wordSquares(words);
        System.out.println("Word Squares: " + squares);
    }
}
