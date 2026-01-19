package leetcode.P139_WordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Problem 139: Word Break
     * Approach: Dynamic Programming
     * 
     * Theoretical Basis:
     * - dp[i] is true if s[0...i-1] can be segmented.
     * - dp[i] = any(dp[j] && wordDict.contains(s[j...i-1])) for 0 <= j < i.
     * 
     * Time Complexity: O(N^2 * L) where N is string length and L is max length of
     * word in dict.
     * Space Complexity: O(N) for DP array.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string

        // Find the maximum length of a word in the dictionary to optimize
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = 1; i <= n; i++) {
            // Check all possible split points
            for (int j = i - 1; j >= 0; j--) {
                // Optimization: if the current substring is longer than any word in dict, skip
                if (i - j > maxLen)
                    break;

                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test 1: " + solution.wordBreak("leetcode", Arrays.asList("leet", "code"))); // Expected:
                                                                                                        // true

        // Test Case 2
        System.out.println("Test 2: " + solution.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // Expected:
                                                                                                             // true

        // Test Case 3
        System.out.println(
                "Test 3: " + solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // Expected:
                                                                                                                   // false
    }
}
