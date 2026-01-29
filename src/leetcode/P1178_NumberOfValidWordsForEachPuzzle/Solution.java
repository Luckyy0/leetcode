package leetcode.P1178_NumberOfValidWordsForEachPuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordCount = new HashMap<>();

        for (String w : words) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            // Only counting logic. Words longer than 7 might not fit?
            // "puzzle length is 7". Words can verify if they fit puzzle.
            // If word mask has bits not in puzzle mask, it's invalid.
            // The check is submask check.
            wordCount.put(mask, wordCount.getOrDefault(mask, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (String p : puzzles) {
            int mask = 0;
            for (char c : p.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            int first = (1 << (p.charAt(0) - 'a'));

            int count = 0;
            int sub = mask;

            // Submask enumeration
            while (true) { // Do-while logic manually
                // Check if sub contains first char
                if ((sub & first) == first) {
                    if (wordCount.containsKey(sub)) {
                        count += wordCount.get(sub);
                    }
                }
                if (sub == 0)
                    break;
                sub = (sub - 1) & mask;
            }

            res.add(count);
        }

        return res;
    }
}
