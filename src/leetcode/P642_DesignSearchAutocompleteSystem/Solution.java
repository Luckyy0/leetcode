package leetcode.P642_DesignSearchAutocompleteSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>(); // Stores sentence counts reaching here?
                                                       // Better: just sentence counts.
                                                       // Or cache top 3?
        // Let's optimize: traverse to leaf to gather all sentences.
        // N is small? (Sentences 100).
        // If N is small, just traverse.
    }

    TrieNode root;
    TrieNode curr;
    StringBuilder buffer;
    Map<String, Integer> globalCounts; // sentence -> frequency

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curr = root;
        buffer = new StringBuilder();
        globalCounts = new HashMap<>();

        for (int i = 0; i < sentences.length; i++) {
            globalCounts.put(sentences[i], times[i]);
            add(sentences[i]);
        }
    }

    // Add sentence to Trie
    private void add(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            String sentence = buffer.toString();
            // Upate count
            globalCounts.put(sentence, globalCounts.getOrDefault(sentence, 0) + 1);
            // Add to Trie (might be new sentence)
            add(sentence);

            // Reset
            buffer = new StringBuilder();
            curr = root;
            return new ArrayList<>(); // return empty list
        }

        buffer.append(c);
        if (curr != null) {
            curr = curr.children.get(c);
        }

        if (curr == null)
            return new ArrayList<>();

        // Find all sentences reachable from curr
        List<String> list = new ArrayList<>();
        dfs(curr, buffer.toString(), list);

        // Sort
        Collections.sort(list, (a, b) -> {
            int ca = globalCounts.get(a);
            int cb = globalCounts.get(b);
            if (ca != cb)
                return cb - ca; // Higher count first
            return a.compareTo(b); // Smaller ASCII first
        });

        if (list.size() > 3)
            return list.subList(0, 3);
        return list;
    }

    private void dfs(TrieNode node, String path, List<String> list) {
        // Since we only store counts at global level or leaves?
        // Actually we need to know where sentences end.
        // TrieNode doesn't imply end.
        // But globalCounts check works if we have the string.
        if (globalCounts.containsKey(path)) {
            list.add(path);
        }

        for (char next : node.children.keySet()) {
            dfs(node.children.get(next), path + next, list);
        }
    }
}
