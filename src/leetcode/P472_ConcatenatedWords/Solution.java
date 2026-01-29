package leetcode.P472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Problem 472: Concatenated Words
     * Approach: Dynamic Programming with Sorting
     * 
     * Time Complexity: O(N * L^3) where N is number of words, L is max length
     * Space Complexity: O(N)
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // Sort words by length: a concatenated word can only be formed by shorter words
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();

        for (String w : words) {
            if (canForm(w, preWords)) {
                result.add(w);
            }
            if (!w.isEmpty()) {
                preWords.add(w);
            }
        }

        return result;
    }

    private boolean canForm(String s, Set<String> set) {
        if (set.isEmpty())
            return false;

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
        String[] words1 = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat" };
        System.out.println("Result 1: " + sol.findAllConcatenatedWordsInADict(words1));

        // ["cat","dog","catdog"] -> ["catdog"]
        String[] words2 = { "cat", "dog", "catdog" };
        System.out.println("Result 2: " + sol.findAllConcatenatedWordsInADict(words2));
    }
}
