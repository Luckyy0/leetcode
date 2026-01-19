package leetcode.P244_ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 244: Shortest Word Distance II
     * Approach: HashMap + Two Pointers
     * 
     * Theoretical Basis:
     * - Precompute indices for O(1) avg lookup preparation.
     * - Query takes O(freq1 + freq2) using sorted list merge logic.
     */
    static class WordDistance {

        private Map<String, List<Integer>> map;

        public WordDistance(String[] wordsDict) {
            map = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                map.putIfAbsent(wordsDict[i], new ArrayList<>());
                map.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);

            int i = 0, j = 0;
            int minDiff = Integer.MAX_VALUE;

            while (i < list1.size() && j < list2.size()) {
                int idx1 = list1.get(i);
                int idx2 = list2.get(j);

                minDiff = Math.min(minDiff, Math.abs(idx1 - idx2));

                if (idx1 < idx2) {
                    i++;
                } else {
                    j++;
                }
            }

            return minDiff;
        }
    }

    public static void main(String[] args) {
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        WordDistance obj = new WordDistance(words);

        // "coding", "practice" -> 3
        int res1 = obj.shortest("coding", "practice");
        System.out.println("Result 1: " + res1 + " (Expected: 3)");

        // "makes", "coding" -> 1
        int res2 = obj.shortest("makes", "coding");
        System.out.println("Result 2: " + res2 + " (Expected: 1)");
    }
}
