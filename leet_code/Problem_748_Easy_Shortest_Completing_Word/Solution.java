package leet_code.Problem_748_Easy_Shortest_Completing_Word;

public class Solution {

    /**
     * Finds the shortest completing word.
     * Strategy: Frequency array comparison.
     * Time: O(N * L), Space: O(1).
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetCounts = new int[26];

        // Parse license plate
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                targetCounts[Character.toLowerCase(c) - 'a']++;
            }
        }

        String bestWord = null;

        for (String word : words) {
            if (isCompleting(word, targetCounts)) {
                // If bestWord is null OR current word is shorter than bestWord
                // Note: If equal length, we keep the original bestWord (first occurrence)
                if (bestWord == null || word.length() < bestWord.length()) {
                    bestWord = word;
                }
            }
        }

        return bestWord;
    }

    // Helper to check if word contains all required chars
    private boolean isCompleting(String word, int[] targetCounts) {
        int[] wordCounts = new int[26];
        for (char c : word.toCharArray()) {
            wordCounts[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (wordCounts[i] < targetCounts[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String lp1 = "1s3 PSt";
        String[] words1 = { "step", "steps", "stripe", "stepple" };
        System.out.println("Result 1: " + sol.shortestCompletingWord(lp1, words1)); // steps

        String lp2 = "1s3 456";
        String[] words2 = { "looks", "pest", "stew", "show" };
        System.out.println("Result 2: " + sol.shortestCompletingWord(lp2, words2)); // pest
    }
}
