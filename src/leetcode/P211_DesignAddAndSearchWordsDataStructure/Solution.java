package leetcode.P211_DesignAddAndSearchWordsDataStructure;

public class Solution {

    /**
     * Problem 211: Design Add and Search Words Data Structure
     * Approach: Trie with Backtracking (DFS) for wildcard '.'
     * 
     * Theoretical Basis:
     * - '.' acts as a wildcard requiring us to check all children.
     * 
     * Time Complexity: O(M) for add, O(M * 26^M) for search in worst case.
     * Space Complexity: O(M * N * 26)
     */
    static class WordDictionary {

        static class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            TrieNode() {
                children = new TrieNode[26];
                isEndOfWord = false;
            }
        }

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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
            return searchHelper(word, 0, root);
        }

        private boolean searchHelper(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node.isEndOfWord;
            }

            char c = word.charAt(index);

            if (c == '.') {
                // Try all possible children
                for (TrieNode child : node.children) {
                    if (child != null) {
                        if (searchHelper(word, index + 1, child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int childIndex = c - 'a';
                TrieNode child = node.children[childIndex];
                if (child == null) {
                    return false;
                }
                return searchHelper(word, index + 1, child);
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        // search "pad" -> false
        System.out.println("Search 'pad': " + wordDictionary.search("pad"));

        // search "bad" -> true
        System.out.println("Search 'bad': " + wordDictionary.search("bad"));

        // search ".ad" -> true
        System.out.println("Search '.ad': " + wordDictionary.search(".ad"));

        // search "b.." -> true
        System.out.println("Search 'b..': " + wordDictionary.search("b.."));
    }
}
