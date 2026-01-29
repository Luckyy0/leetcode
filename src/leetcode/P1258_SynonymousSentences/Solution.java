package leetcode.P1258_SynonymousSentences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    Map<String, String> parent = new HashMap<>();

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        // Union Find
        for (List<String> pair : synonyms) {
            union(pair.get(0), pair.get(1));
        }

        // Group by root
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : parent.keySet()) {
            String root = find(word);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(word);
        }
        for (List<String> g : groups.values()) {
            Collections.sort(g);
        }

        String[] words = text.split(" ");
        TreeSet<String> res = new TreeSet<>();
        backtrack(words, 0, new StringBuilder(), groups, res);

        return new ArrayList<>(res);
    }

    private void backtrack(String[] words, int index, StringBuilder current, Map<String, List<String>> groups,
            TreeSet<String> res) {
        if (index == words.length) {
            res.add(current.toString().trim());
            return;
        }

        String word = words[index];
        String root = find(word); // ensure word is in parent map if it has synonyms?
        // If word not in parent, find returns word but groups might not have it if no
        // synonyms processed.
        // Wait, if word not in synonyms at all, 'find' is tricky if we don't init
        // parent.
        // My 'find' lazy inits.
        // But groups keys are only from synonyms list.

        List<String> options;
        if (groups.containsKey(root)) {
            options = groups.get(root);
        } else {
            options = Collections.singletonList(word);
        }

        int len = current.length();
        for (String opt : options) {
            current.append(opt).append(" ");
            backtrack(words, index + 1, current, groups, res);
            current.setLength(len);
        }
    }

    private String find(String s) {
        if (!parent.containsKey(s))
            parent.put(s, s);
        if (!s.equals(parent.get(s))) {
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

    private void union(String s1, String s2) {
        String root1 = find(s1);
        String root2 = find(s2);
        if (!root1.equals(root2)) {
            parent.put(root1, root2);
        }
    }
}
