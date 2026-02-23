package leet_code.Problem_642_Hard_Design_Search_Autocomplete_System;

import java.util.*;

public class AutocompleteSystem {

    private class TrieNode {
        // Sentence -> Frequency
        Map<String, Integer> counts;
        Map<Character, TrieNode> children;

        TrieNode() {
            counts = new HashMap<>();
            children = new HashMap<>();
        }
    }

    private class NodeInfo {
        String sentence;
        int count;

        NodeInfo(String s, int c) {
            sentence = s;
            count = c;
        }
    }

    private TrieNode root;
    private String currentInput;
    private TrieNode currentPtr;
    private boolean deadPath;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        currentInput = "";
        currentPtr = root;
        deadPath = false;

        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    /**
     * Updates the Trie with a new sentence (or updates frequency of existing one).
     */
    private void addSentence(String s, int time) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + time);
        }
    }

    /**
     * Processes each character input.
     */
    public List<String> input(char c) {
        if (c == '#') {
            // End of sentence, save and reset
            addSentence(currentInput, 1);
            currentInput = "";
            currentPtr = root;
            deadPath = false;
            return new ArrayList<>();
        }

        currentInput += c;

        if (deadPath || !currentPtr.children.containsKey(c)) {
            deadPath = true;
            return new ArrayList<>();
        }

        currentPtr = currentPtr.children.get(c);

        // Pick top 3 sentences from the current TrieNode
        PriorityQueue<NodeInfo> pq = new PriorityQueue<>((a, b) -> {
            if (a.count != b.count)
                return a.count - b.count; // Min-heap by frequency
            return b.sentence.compareTo(a.sentence); // Max-heap by ASCII for same freq
        });

        for (String s : currentPtr.counts.keySet()) {
            pq.offer(new NodeInfo(s, currentPtr.counts.get(s)));
            if (pq.size() > 3)
                pq.poll();
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().sentence);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = { "i love you", "island", "ironman", "i love leetcode" };
        int[] t = { 5, 3, 2, 2 };
        AutocompleteSystem system = new AutocompleteSystem(s, t);
        System.out.println(system.input('i')); // ["i love you", "island", "i love leetcode"]
        System.out.println(system.input(' ')); // ["i love you", "i love leetcode"]
        System.out.println(system.input('a')); // []
        System.out.println(system.input('#')); // []
    }
}
