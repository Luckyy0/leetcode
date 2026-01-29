package leetcode.P1307_VerbalArithmeticPuzzle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private int[] charToDigit;
    private boolean[] digitUsed;
    private boolean[] leadingChars; // Stores if a char is leading char

    public boolean isSolvable(String[] words, String result) {
        Set<Character> chars = new HashSet<>();
        leadingChars = new boolean[26];
        int maxLen = result.length();

        for (String w : words) {
            if (w.length() > maxLen)
                return false; // Basic pruning
            if (w.length() > 1)
                leadingChars[w.charAt(0) - 'A'] = true;
            for (char c : w.toCharArray())
                chars.add(c);
        }
        if (result.length() > 1)
            leadingChars[result.charAt(0) - 'A'] = true;
        for (char c : result.toCharArray())
            chars.add(c);

        if (chars.size() > 10)
            return false;

        charToDigit = new int[26];
        Arrays.fill(charToDigit, -1);
        digitUsed = new boolean[10];

        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = new StringBuilder(words[i]).reverse().toString();
        }
        String reversedResult = new StringBuilder(result).reverse().toString();

        return backtrack(0, 0, 0, reversedWords, reversedResult);
    }

    // col: current column (power of 10)
    // wordIdx: which word in LHS we are processing for current col
    // carry: carry from previous column
    private boolean backtrack(int col, int wordIdx, int carry, String[] words, String result) {
        if (col == result.length()) { // Processed all columns up to result length
            if (wordIdx == 0 && carry == 0)
                return true; // Done and no carry
            return false;
            // Wait, logic:
            // If col >= result.length(), we only check carry.
            // If carry > 0, invalid (result cannot accommodate more digits).
        }

        // Summation phase
        if (wordIdx < words.length) {
            String w = words[wordIdx];
            if (col >= w.length()) {
                // This word has no char at this col, move to next word
                return backtrack(col, wordIdx + 1, carry, words, result);
            }

            char c = w.charAt(col);
            int charIdx = c - 'A';

            if (charToDigit[charIdx] != -1) {
                // Already assigned
                if (leadingChars[charIdx] && charToDigit[charIdx] == 0)
                    return false; // Should be handled at assignment
                return backtrack(col, wordIdx + 1, carry + charToDigit[charIdx], words, result);
            } else {
                // Try assigning digit
                for (int d = 0; d <= 9; d++) {
                    if (!digitUsed[d]) {
                        if (d == 0 && leadingChars[charIdx])
                            continue;

                        digitUsed[d] = true;
                        charToDigit[charIdx] = d;

                        if (backtrack(col, wordIdx + 1, carry + d, words, result))
                            return true;

                        charToDigit[charIdx] = -1;
                        digitUsed[d] = false;
                    }
                }
                return false;
            }
        } else {
            // Finished summing LHS for this column. Check result digit.
            int sum = carry;
            int digit = sum % 10;
            int nextCarry = sum / 10;

            char resChar = result.charAt(col);
            int resIdx = resChar - 'A';

            if (charToDigit[resIdx] != -1) {
                if (charToDigit[resIdx] == digit) {
                    if (leadingChars[resIdx] && digit == 0 && result.length() > 1)
                        return false; // Although leading check done, re-verify
                    return backtrack(col + 1, 0, nextCarry, words, result);
                } else {
                    return false; // Mismatch
                }
            } else {
                if (digitUsed[digit])
                    return false; // Digit needed but used elsewhere
                if (digit == 0 && leadingChars[resIdx])
                    return false;

                digitUsed[digit] = true;
                charToDigit[resIdx] = digit;

                if (backtrack(col + 1, 0, nextCarry, words, result))
                    return true;

                charToDigit[resIdx] = -1;
                digitUsed[digit] = false;
                return false;
            }
        }
    }
}
