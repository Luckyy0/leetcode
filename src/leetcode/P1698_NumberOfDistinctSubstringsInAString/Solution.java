package leetcode.P1698_NumberOfDistinctSubstringsInAString;

public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                    count++;
                }
                curr = curr.children[index];
            }
        }

        return count;
    }
}
