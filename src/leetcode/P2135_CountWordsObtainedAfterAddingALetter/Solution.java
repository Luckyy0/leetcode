package leetcode.P2135_CountWordsObtainedAfterAddingALetter;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> startMasks = new HashSet<>();
        for (String s : startWords) {
            startMasks.add(getMask(s));
        }

        int count = 0;
        for (String t : targetWords) {
            int mask = getMask(t);
            boolean possible = false;

            // Try removing each present character
            for (char c : t.toCharArray()) {
                int bit = 1 << (c - 'a');
                // Since t has this char, removing it is XOR (or subtraction)
                int prevMask = mask ^ bit;
                if (startMasks.contains(prevMask)) {
                    possible = true;
                    break;
                }
            }

            if (possible)
                count++;
        }
        return count;
    }

    private int getMask(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= (1 << (c - 'a'));
        }
        return mask;
    }
}
