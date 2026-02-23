package leet_code.Problem_425_Hard_Word_Squares;

import java.util.*;

public class Solution_TrieBacktracking {

    class TrieNode {
        List<String> startWith = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
    }

    private void buildTrie(String[] words, TrieNode root) {
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
                curr.startWith.add(w);
            }
        }
    }

    private List<String> findByPrefix(TrieNode root, String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null)
                return new ArrayList<>();
            curr = curr.children[idx];
        }
        return curr.startWith;
    }

    /**
     * Finds all valid word squares.
     * Uses Backtracking with Trie for prefix lookup.
     * Time: O(N * 26^L), Space: O(N * L).
     * 
     * Tìm tất cả các hình vuông từ vựng hợp lệ.
     * Sử dụng Quay lui với Trie để tra cứu tiền tố.
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0)
            return res;

        int len = words[0].length();
        TrieNode root = new TrieNode();
        buildTrie(words, root);

        List<String> ans = new ArrayList<>();
        for (String w : words) {
            ans.add(w);
            backtrack(res, ans, len, root);
            ans.remove(ans.size() - 1);
        }

        return res;
    }

    private void backtrack(List<List<String>> res, List<String> ans, int len, TrieNode root) {
        if (ans.size() == len) {
            res.add(new ArrayList<>(ans));
            return;
        }

        int step = ans.size();
        StringBuilder sb = new StringBuilder();
        for (String s : ans) {
            sb.append(s.charAt(step));
        }

        String prefix = sb.toString();
        List<String> candidates = findByPrefix(root, prefix);

        for (String cand : candidates) {
            ans.add(cand);
            backtrack(res, ans, len, root);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution_TrieBacktracking solution = new Solution_TrieBacktracking();

        // Test Case 1
        String[] words1 = { "area", "lead", "wall", "lady", "ball" };
        System.out.println("Result 1: " + solution.wordSquares(words1));

        // Test Case 2
        String[] words2 = { "abat", "baba", "atan", "atal" };
        System.out.println("Result 2: " + solution.wordSquares(words2));
    }
}
