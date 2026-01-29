package leetcode.P2168_UniqueSubstringsWithEqualDigitFrequency;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int equalDigitFrequency(String s) {
        Set<String> unique = new HashSet<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] counts = new int[10];
            for (int j = i; j < n; j++) {
                int digit = s.charAt(j) - '0';
                counts[digit]++;

                if (isValid(counts)) {
                    unique.add(s.substring(i, j + 1));
                }
            }
        }

        return unique.size();
    }

    private boolean isValid(int[] counts) {
        int commonFreq = -1;
        for (int c : counts) {
            if (c == 0)
                continue;
            if (commonFreq == -1)
                commonFreq = c;
            else if (commonFreq != c)
                return false;
        }
        return true;
    }
}
