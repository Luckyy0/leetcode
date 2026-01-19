package leetcode.P131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 131: Palindrome Partitioning
     * Approach: Backtracking with DFS
     * 
     * Theoretical Basis:
     * - Use backtracking to explore all possible partition combinations.
     * - Only extend the path if the current substring is a palindrome.
     * 
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N) for recursion stack and current path.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPath, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // Choice
                currentPath.add(s.substring(start, end + 1));
                // Explore
                backtrack(s, end + 1, currentPath, result);
                // Unchoice (Backtrack)
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: "aab"
        System.out.println("Test 1: " + solution.partition("aab"));

        // Test Case 2: "a"
        System.out.println("Test 2: " + solution.partition("a"));
    }
}
