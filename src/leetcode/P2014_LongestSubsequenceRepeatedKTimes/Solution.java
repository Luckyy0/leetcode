package leetcode.P2014_LongestSubsequenceRepeatedKTimes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        List<Character> validChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k)
                validChars.add((char) ('a' + i));
        }

        // Sorting chars helps processing order?
        // We want lexicographically largest of longest length.
        // BFS generates shortest first. So we just update 'best' continuously.
        // If we process level by level, the last level is longest.
        // Within same level, we want lexicographically largest.

        String best = "";
        Queue<String> q = new ArrayDeque<>();
        q.offer("");

        while (!q.isEmpty()) {
            String curr = q.poll();

            // Try appending next valid char
            for (char c : validChars) {
                String next = curr + c;
                if (check(s, next, k)) {
                    // It is valid. Update best if longer or (equal len and bigger)
                    // BFS guarantees non-decreasing length.
                    // If length increases, update. If equal, check lexicographical.
                    /*
                     * Actually, standard BFS logic:
                     * We iterate layers.
                     * Layer L: strings length L.
                     * We want to process all valid length L, pick max.
                     */
                    // Simple update:
                    // Since BFS explores length 0, 1, 2...
                    // 'next' is always >= 'best' in length.
                    // If next.length > best.length, it's clearly better.
                    // If equal, compareTo.
                    // Actually, simpler: in BFS, we might visit "ba" before "ab" depending on loop?
                    // No complexity issue to just check.

                    if (next.length() > best.length() || (next.length() == best.length() && next.compareTo(best) > 0)) {
                        best = next;
                    }
                    q.offer(next);
                }
            }
        }

        return best;
    }

    private boolean check(String s, String sub, int k) {
        int n = s.length();
        int m = sub.length();
        int repeat = 0;
        int subIdx = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == sub.charAt(subIdx)) {
                subIdx++;
                if (subIdx == m) {
                    repeat++;
                    subIdx = 0;
                    if (repeat == k)
                        return true;
                }
            }
        }
        return false;
    }
}
