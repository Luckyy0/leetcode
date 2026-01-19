package leetcode.P291_WordPatternII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * Problem 291: Word Pattern II
     * Approach: Backtracking
     * 
     * Theoretical Basis:
     * - Try mapping current pattern char to all possible substrings starting at
     * sIndex.
     * 
     * Time Complexity: Exponential
     * Space Complexity: O(N)
     */
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        return backtrack(pattern, s, 0, 0, map, used);
    }

    private boolean backtrack(String pattern, String s, int pIndex, int sIndex,
            Map<Character, String> map, Set<String> used) {
        // Base case: both reach end
        if (pIndex == pattern.length() && sIndex == s.length()) {
            return true;
        }
        // If one finishes but not other
        if (pIndex == pattern.length() || sIndex == s.length()) {
            return false;
        }

        char c = pattern.charAt(pIndex);

        // If char is already mapped
        if (map.containsKey(c)) {
            String w = map.get(c);

            // Check if s starts with w at sIndex
            if (!s.startsWith(w, sIndex)) {
                return false;
            }

            // Continue
            return backtrack(pattern, s, pIndex + 1, sIndex + w.length(), map, used);
        } else {
            // Char not mapped. Try all substrings.
            for (int k = sIndex; k < s.length(); k++) {
                String w = s.substring(sIndex, k + 1);

                // Bijection check: word must not be used by another char
                if (used.contains(w)) {
                    continue;
                }

                // Map and recurse
                map.put(c, w);
                used.add(w);

                if (backtrack(pattern, s, pIndex + 1, k + 1, map, used)) {
                    return true;
                }

                // Backtrack
                map.remove(c);
                used.remove(w);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "abab", "redblueredblue" -> true
        runTest(solution, "abab", "redblueredblue", true);

        // "aaaa", "asdasdasdasd" -> true
        runTest(solution, "aaaa", "asdasdasdasd", true);

        // "aabb", "xyzabcxzyabc" -> false
        runTest(solution, "aabb", "xyzabcxzyabc", false);
    }

    private static void runTest(Solution s, String pattern, String str, boolean expected) {
        boolean result = s.wordPatternMatch(pattern, str);
        System.out
                .println("Pattern: " + pattern + ", S: \"" + str + "\" -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
