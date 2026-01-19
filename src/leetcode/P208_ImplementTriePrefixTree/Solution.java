package leetcode.P208_ImplementTriePrefixTree;

public class Solution {

    /**
     * Problem 208: Implement Trie (Prefix Tree)
     * Approach: Standard Trie Node
     * 
     * Theoretical Basis:
     * - Node has children[26] and isEnd boolean.
     * - O(L) operations.
     */
    static class Trie {

        static class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            TrieNode() {
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // insert "apple"
        trie.insert("apple");
        System.out.println("Insert apple");

        // search "apple" -> true
        System.out.println("Search 'apple': " + trie.search("apple"));

        // search "app" -> false
        System.out.println("Search 'app': " + trie.search("app"));

        // startsWith "app" -> true
        System.out.println("StartsWith 'app': " + trie.startsWith("app"));

        // insert "app"
        trie.insert("app");
        System.out.println("Insert app");

        // search "app" -> true
        System.out.println("Search 'app': " + trie.search("app"));
    }
}
