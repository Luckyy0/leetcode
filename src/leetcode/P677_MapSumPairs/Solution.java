package leetcode.P677_MapSumPairs;

import java.util.HashMap;
import java.util.Map;

class MapSum {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int score = 0;
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.score += diff;
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null)
                return 0;
        }
        return curr.score;
    }
}
