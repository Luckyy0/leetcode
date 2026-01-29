package leetcode.P648_ReplaceWords;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    private TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        // Build Trie from dictionary
        // Xây dựng Trie từ từ điển
        root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }

        // Process sentence
        // Xử lý câu
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
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    private String findRoot(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return word; // No root found
            }
            prefix.append(c);
            node = node.children.get(c);

            if (node.isEnd) {
                return prefix.toString(); // Found shortest root
            }
        }

        return word; // No root found
    }
}
