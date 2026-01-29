package leetcode.P1065_IndexPairsOfAString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public int[][] indexPairs(String text, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        List<int[]> resultList = new ArrayList<>();
        int n = text.length();

        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                char c = text.charAt(j);
                if (!node.children.containsKey(c))
                    break;
                node = node.children.get(c);
                if (node.isWord) {
                    resultList.add(new int[] { i, j });
                }
            }
        }

        int[][] res = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }
}
