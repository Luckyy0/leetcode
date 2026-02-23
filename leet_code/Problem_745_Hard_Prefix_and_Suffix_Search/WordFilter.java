package leet_code.Problem_745_Hard_Prefix_and_Suffix_Search;

public class WordFilter {

    private static class TrieNode {
        TrieNode[] children;
        int weight;

        TrieNode() {
            children = new TrieNode[27]; // 'a'-'z' and '{'
            weight = -1;
        }
    }

    private TrieNode root;

    /**
     * Initializes the WordFilter with a dictionary.
     * Strategy: Insert "suffix + '{' + word" keys into a Trie.
     * Time: O(N * L^2), Space: O(N * L^2).
     */
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            // Generate all suffix combinations
            // For word "apple", insert:
            // "e{apple", "le{apple", "ple{apple", "pple{apple", "apple{apple"
            for (int j = 0; j <= len; j++) {
                String suffix = word.substring(j); // Suffix starting from j
                String key = suffix + '{' + word;
                insert(key, i);
            }
        }
    }

    // Helper to insert a key into the Trie
    private void insert(String key, int weight) {
        TrieNode curr = root;
        // Since we process words in order 0 to N-1, we can greedily update weight
        // OR simply overwrite since bigger index is better.
        // But wait, "e{apple" inserted at index 0. Then "e{ale" at index 1.
        // Node "e" will be visited by index 1 last, so it will have weight 1. Logic
        // holds.
        curr.weight = weight;
        for (char c : key.toCharArray()) {
            int idx = (c == '{') ? 26 : c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.weight = weight; // Update largest index passing through this node
        }
    }

    /**
     * Finds the largest index of a word with given prefix and suffix.
     * Time: O(L_prefix + L_suffix).
     */
    public int f(String prefix, String suffix) {
        TrieNode curr = root;
        String key = suffix + '{' + prefix;
        for (char c : key.toCharArray()) {
            int idx = (c == '{') ? 26 : c - 'a';
            if (curr.children[idx] == null) {
                return -1;
            }
            curr = curr.children[idx];
        }
        return curr.weight;
    }

    public static void main(String[] args) {
        WordFilter wf = new WordFilter(new String[] { "apple" });
        System.out.println("Result 1: " + wf.f("a", "e")); // 0
        System.out.println("Result 2: " + wf.f("b", "")); // -1

        WordFilter wf2 = new WordFilter(new String[] { "apple", "ale" });
        System.out.println("Result 3: " + wf2.f("a", "e")); // 1 (ale has larger index)
    }
}
