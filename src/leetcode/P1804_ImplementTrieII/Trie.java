package leetcode.P1804_ImplementTrieII;

public class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int countEnds = 0;
        int countPrefix = 0;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.countPrefix++;
        }
        curr.countEnds++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null)
                return 0;
            curr = curr.children[idx];
        }
        return curr.countEnds;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null)
                return 0;
            curr = curr.children[idx];
        }
        return curr.countPrefix;
    }

    public void erase(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            curr = curr.children[idx];
            curr.countPrefix--;
        }
        curr.countEnds--;
    }
}
