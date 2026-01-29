package leetcode.P1647_MinimumDeletionsToMakeCharacterFrequenciesUnique;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> seen = new HashSet<>();
        int deletions = 0;

        for (int count : freq) {
            if (count == 0)
                continue;

            while (count > 0 && seen.contains(count)) {
                count--;
                deletions++;
            }

            if (count > 0) {
                seen.add(count);
            }
        }

        return deletions;
    }
}
