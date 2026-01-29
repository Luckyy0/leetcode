package leetcode.P1032_StreamOfCharacters;

import java.util.HashMap;
import java.util.Map;

class StreamChecker {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String w : words) {
            TrieNode node = root;
            // Insert reversed
            for (int i = w.length() - 1; i >= 0; i--) {
                char c = w.charAt(i);
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEnd = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            node = node.children.get(c);
            if (node == null)
                return false;
            if (node.isEnd)
                return true;
        }
        return false;
    }
}
