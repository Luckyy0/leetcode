package leetcode.P2030_SmallestKLengthSubsequenceWithOccurrencesOfALetter;

public class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        int[] suffixLetters = new int[n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == letter)
                count++;
            suffixLetters[i] = count;
        }

        StringBuilder sb = new StringBuilder();
        int currentLetters = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Try to pop larger elements
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                // Check length constraint
                if (sb.length() + (n - 1 - i) < k)
                    break;

                // Check letter constraint
                char top = sb.charAt(sb.length() - 1);
                if (top == letter) {
                    // If we pop, will we have enough?
                    // currentLetters - 1 + suffixLetters[i] >= repetition?
                    // suffixLetters[i] includes s[i] matches.
                    // Actually suffixLetters[i] is count in s[i...].
                    // Wait, current iteration s[i] is available. "Suffix from i+1"?
                    // Actually, if we use suffix[i], it includes s[i] if s[i] == letter.
                    // But we are considering popping TOP. We haven't pushed s[i] yet.
                    // Remaining letters available after i: suffixLetters[i+1] (or calculated).
                    // The available letters to fulfill requirement are (currentLetters - 1) +
                    // (count in s[i...]).

                    // Actually, condition is: `(currentLetters - 1) + suffixLetters[i] >=
                    // repetition`.
                    // Yes, because suffixLetters[i] counts letters from i onwards (including i).
                    if (currentLetters - 1 + suffixLetters[i] < repetition)
                        break;
                }

                // Pop
                if (top == letter)
                    currentLetters--;
                sb.setLength(sb.length() - 1);
            }

            // Try to push
            if (sb.length() < k) {
                if (c == letter) {
                    sb.append(c);
                    currentLetters++;
                } else {
                    // Can we push a non-letter?
                    // Needed letters: max(0, repetition - currentLetters).
                    // Space remaining after push: k - (sb.length() + 1).
                    // We need space >= needed.
                    if (k - (sb.length() + 1) >= Math.max(0, repetition - currentLetters)) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
