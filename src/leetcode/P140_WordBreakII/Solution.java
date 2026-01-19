package leetcode.P140_WordBreakII;

import java.util.*;

public class Solution {

    /**
     * Problem 140: Word Break II
     * Approach: Backtracking with Memoization
     * 
     * Theoretical Basis:
     * - We recursively split the string and find valid dictionary words.
     * - Use a HashMap to store the results of subproblems (suffixes).
     * 
     * Time Complexity: O(2^N) in the worst case (though limited by output size).
     * Space Complexity: O(2^N) for storage and recursion.
     */
    private Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(s, wordSet);
    }

    private List<String> backtrack(String s, Set<String> wordSet) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> subList = backtrack(s.substring(word.length()), wordSet);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                "Test 1: " + solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));

        // Test Case 2
        solution.memo.clear();
        System.out.println("Test 2: " + solution.wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));

        // Test Case 3
        solution.memo.clear();
        System.out.println(
                "Test 3: " + solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
