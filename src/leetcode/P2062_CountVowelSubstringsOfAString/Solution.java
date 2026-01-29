package leetcode.P2062_CountVowelSubstringsOfAString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();
        int lastConsorant = -1;

        // Sliding window on vowel segments
        // We track window [left, right] within segment (lastConsorant + 1, right)
        // Maintain counts of vowels in CURRENT minimal valid window [k, right]
        // Actually slightly complex to maintain "all valid starts".
        // Simpler logic for O(N):
        // Iterate R. If consonant, reset everything.
        // If vowel:
        // Track map of vowels in current valid window [L, R]
        // We want to count valid starts.
        // Let's process each segment independently.
        // Or just use brute force O(N^2) if valid? Constraints n <= 100? Yes usually.
        // Wait. "1 <= word.length <= 100".
        // Brute force O(N^2) or O(N^3) is trivial and safest.

        // Brute force:
        for (int i = 0; i < n; i++) {
            Set<Character> vowels = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!isVowel(c))
                    break;
                vowels.add(c);
                if (vowels.size() == 5)
                    count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
