package leetcode.P1255_MaximumScoreWordsFormedByLetters;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters)
            count[c - 'a']++;

        return backtrack(words, count, score, 0);
    }

    private int backtrack(String[] words, int[] lettersCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }

        // Option 1: Skip current word
        int max = backtrack(words, lettersCount, score, index + 1);

        // Option 2: Include current word (if possible)
        String word = words[index];
        boolean possible = true;
        int currentScore = 0;
        int[] subCount = new int[26]; // To track what we take

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            subCount[idx]++;
            if (lettersCount[idx] < subCount[idx]) {
                possible = false;
            }
            currentScore += score[idx];
        }

        if (possible) {
            // Apply changes
            for (int i = 0; i < 26; i++)
                lettersCount[i] -= subCount[i];

            max = Math.max(max, currentScore + backtrack(words, lettersCount, score, index + 1));

            // Backtrack changes
            for (int i = 0; i < 26; i++)
                lettersCount[i] += subCount[i];
        }

        return max;
    }
}
