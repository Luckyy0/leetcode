package leetcode.P1520_MaximumNumberOfNonOverlappingSubstrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] l = new int[26];
        int[] r = new int[26];
        for (int i = 0; i < 26; i++) {
            l[i] = Integer.MAX_VALUE;
            r[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            l[charIdx] = Math.min(l[charIdx], i);
            r[charIdx] = Math.max(r[charIdx], i);
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (l[i] == Integer.MAX_VALUE)
                continue;

            int currentL = l[i];
            int currentR = r[i];
            boolean valid = true;

            for (int k = currentL; k <= currentR; k++) {
                int ch = s.charAt(k) - 'a';
                if (l[ch] < currentL) {
                    // This creates an interval starting before currentL.
                    // But we are iterating chars. We only want intervals starting AT l[i]?
                    // No. If expanding makes start smaller, it means character i is part of a
                    // larger interval defined by `ch`.
                    // We can skip current `i` because we will process `ch` or ultimately the 'root'
                    // char.
                    // Actually, simple check: If expanding left goes beyond l[i], this specific
                    // candidiate starting at l[i] is invalid (it's part of bigger one).
                    // We only collect intervals that are valid expansions starting at l[i] and NOT
                    // expanding left.
                    valid = false;
                    break;
                }
                currentR = Math.max(currentR, r[ch]);
            }

            if (valid) {
                intervals.add(new int[] { currentL, currentR });
            }
        }

        // Greedy
        intervals.sort((a, b) -> (a[1] == b[1]) ? (b[1] - b[0] - (a[1] - a[0])) : (a[1] - b[1]));

        List<String> res = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                res.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return res;
    }
}
