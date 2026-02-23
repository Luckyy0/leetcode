package leet_code.Problem_677_Medium_Map_Sum_Pairs;

import java.util.*;

public class MapSum {

    /**
     * Internal Trie node structure.
     */
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int sum = 0; // Cumulative sum of all keys passing through this node
    }

    private TrieNode root;
    private Map<String, Integer> valueMap;

    /**
     * Initializes the MapSum object.
     */
    public MapSum() {
        root = new TrieNode();
        valueMap = new HashMap<>();
    }

    /**
     * Inserts the key-val pair. Overrides if key exists.
     * Strategy: Calculate delta and update sum along the Trie path.
     * Time: O(L), Space: O(N * L).
     */
    public void insert(String key, int val) {
        int oldVal = valueMap.getOrDefault(key, 0);
        int delta = val - oldVal;
        valueMap.put(key, val);

        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            curr.sum += delta;
        }
    }

    /**
     * Returns the sum of all pairs' value whose key starts with prefix.
     * Strategy: Traverse to the prefix node and read the stored sum.
     * Time: O(P), Space: O(1).
     */
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return 0;
            }
            curr = curr.children.get(c);
        }
        return curr.sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println("Sum 'ap': " + mapSum.sum("ap")); // 3
        mapSum.insert("app", 2);
        System.out.println("Sum 'ap': " + mapSum.sum("ap")); // 5
    }
}
