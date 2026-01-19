package leetcode.P087_ScrambleString;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Solution {

    private Map<String, Boolean> memo = new HashMap<>();

    /**
     * Problem 87: Scramble String
     * Approach: Memoized Recursion
     * Time Complexity: O(N^4) roughly
     * Space Complexity: O(N^3)
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check character counts (Pruning)
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0)
                return false;
        }

        // Memoization check
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No Swap
            // s1[0..i] matches s2[0..i] AND s1[i..n] matches s2[i..n]
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Case 2: Swap
            // s1[0..i] matches s2[n-i..n] AND s1[i..n] matches s2[0..n-i]
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "great", "rgeat", true);
        runTest(solution, "abcde", "caebd", false);
        runTest(solution, "a", "a", true);
    }

    private static void runTest(Solution s, String s1, String s2, boolean expected) {
        System.out.println("Input: s1=\"" + s1 + "\", s2=\"" + s2 + "\"");
        // Create new instance or clear map to avoid state leak between tests (though
        // logic works fine with global cache if consistent)
        s.memo.clear();
        boolean result = s.isScramble(s1, s2);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
