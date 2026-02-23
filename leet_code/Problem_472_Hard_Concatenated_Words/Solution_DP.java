package leet_code.Problem_472_Hard_Concatenated_Words;

import java.util.*;

public class Solution_DP {

    /**
     * Finds all concatenated words.
     * Strategy: Sort by length, put shorter words in a Set, check larger words
     * using Word Break DP.
     * Time: O(N * L^2), Space: O(N * L).
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();

        // Sort by length so we process shorter words first
        // Actually, sorting helps optimization but isn't strictly needed if we
        // implement canForm correctly
        // to require at least 2 words.
        // However, standard sorting makes it easy: "Can we form this word using
        // PREVIOUSLY seen words?"
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            // Add current word to set so it can be used for future longer words
            wordSet.add(word);
        }

        return result;
    }

    // Standard Word Break logic
    private boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty())
            return false;
        int len = word.length();
        if (len == 0)
            return false; // Empty strings don't count

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            // j starts from 0 (check whole prefix) up to i-1
            // Optimization: Since min word length in dict is at least 1, j < i is correct.
            // Further optimization: j doesn't need to go back all the way if max word len
            // is small,
            // but strict constraints analysis says L is small (30), so O(L^2) is fine.
            for (int j = 0; j < i; j++) {
                if (!dp[j])
                    continue;

                String sub = word.substring(j, i);
                if (dict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
        System.out.println("Result: " + solution.findAllConcatenatedWordsInADict(words));
    }
}
