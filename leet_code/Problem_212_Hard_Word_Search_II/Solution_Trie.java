package leet_code.Problem_212_Hard_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

public class Solution_Trie {

    // Trie Node structure optimized for the problem
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Stores the word ending here, null if not end
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // 1. Build Trie
        // 1. Xây dựng Trie
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
            node.word = w; // Mark end of word by storing the string itself
        }

        // 2. DFS on each cell
        // 2. DFS trên mỗi ô
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode parent, List<String> result) {
        char c = board[i][j];
        TrieNode curr = parent.children[c - 'a'];

        // If we found a word
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null; // Deduplicate: ensure we don't add the same word again
        }

        // Mark as visited
        board[i][j] = '#';

        // Explore neighbors
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                char nextChar = board[ni][nj];
                if (nextChar != '#' && curr.children[nextChar - 'a'] != null) {
                    dfs(board, ni, nj, curr, result);
                }
            }
        }

        // Backtrack
        board[i][j] = c;

        // Optimization: Leaf pruning (Optional but recommended for speed)
        // If the current node has no children, remove it from parent to pruning future
        // searches
        // Tối ưu hóa: Cắt tỉa lá. Nếu nút hiện tại không có con, xóa nó khỏi cha để cắt
        // tỉa các tìm kiếm sau này
        if (isEmpty(curr)) {
            parent.children[c - 'a'] = null;
        }
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_Trie solution = new Solution_Trie();

        char[][] board = {
                { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' }
        };
        String[] words = { "oath", "pea", "eat", "rain" };

        System.out.println("Found words: " + solution.findWords(board, words));
    }
}
