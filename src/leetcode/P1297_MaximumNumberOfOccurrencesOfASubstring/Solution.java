package leetcode.P1297_MaximumNumberOfOccurrencesOfASubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> counts = new HashMap<>();
        int maxOccurrences = 0;
        int n = s.length();

        // Only check substrings of length minSize
        for (int i = 0; i <= n - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            if (isValid(sub, maxLetters)) {
                counts.put(sub, counts.getOrDefault(sub, 0) + 1);
                maxOccurrences = Math.max(maxOccurrences, counts.get(sub));
            }
        }

        return maxOccurrences;
    }

    // Check unique chars
    private boolean isValid(String sub, int maxLetters) {
        Set<Character> unique = new HashSet<>();
        for (char c : sub.toCharArray()) {
            unique.add(c);
            if (unique.size() > maxLetters)
                return false;
        }
        return unique.size() <= maxLetters;
    }
}
