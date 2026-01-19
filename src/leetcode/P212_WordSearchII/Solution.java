package leetcode.P212_WordSearchII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 212: Word Search II
     * Approach: Backtracking with Trie
     * 
     * Theoretical Basis:
     * - Use Trie to efficiently prune the search.
     * - Store the word at the leaf node of the Trie.
     */
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // 1. Build Trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = w; // Store full word at leaf
        }

        // 2. DFS from each cell
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (root.children[board[r][c] - 'a'] != null) {
                    dfs(board, r, c, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char letter = board[r][c];
        TrieNode currNode = parent.children[letter - 'a'];

        // Check if we found a word
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null; // Dedup: ensure we don't add the same word instance twice
        }

        // Mark as visited
        board[r][c] = '#';

        // Directions: up, right, down, left
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (board[nr][nc] != '#' && currNode.children[board[nr][nc] - 'a'] != null) {
                    dfs(board, nr, nc, currNode, result);
                }
            }
        }

        // Backtrack
        board[r][c] = letter;

        // Optimization: Removing leaf node to prune the Trie would go here
        // If currNode has no children, we can remove it from parent.children
        // (Not implemented here for simplicity, but good for very strict time limits)
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        char[][] b1 = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] w1 = { "oath", "pea", "eat", "rain" };
        System.out.println("Test 1: " + solution.findWords(b1, w1));
        // Expected: [oath, eat] (order may vary)

        // Example 2
        char[][] b2 = { { 'a', 'b' }, { 'c', 'd' } };
        String[] w2 = { "abcb" };
        System.out.println("Test 2: " + solution.findWords(b2, w2));
        // Expected: []
    }
}
