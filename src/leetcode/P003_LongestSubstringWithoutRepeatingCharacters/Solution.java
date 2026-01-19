package leetcode.P003_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^3) - TLE for large inputs
     * Space Complexity: O(min(n, m))
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        Set<Character> chars = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (chars.contains(c)) {
                return false;
            }
            chars.add(c);
        }
        return true;
    }

    /**
     * Approach 2: Sliding Window
     * Time Complexity: O(2n) = O(n)
     * Space Complexity: O(min(n, m))
     */
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // Try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * Approach 3: Sliding Window Optimized
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, m))
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        int n = s.length();
        int ans = 0;
        // Map stores the index of the character + 1 (next valid start position)
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // If found duplicate, move i to the max of current i or the position after the
                // duplicate
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            // Store index + 1 so we can jump directly to it
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testInputs = {
                "abcabcbb", // Exp: 3
                "bbbbb", // Exp: 1
                "pwwkew", // Exp: 3
                "", // Exp: 0
                " ", // Exp: 1
                "au", // Exp: 2
                "dvdf" // Exp: 3
        };

        for (String s : testInputs) {
            System.out.println("Input: \"" + s + "\"");
            System.out.println("BruteForce: " + solution.lengthOfLongestSubstringBruteForce(s));
            System.out.println("SlidingWindow: " + solution.lengthOfLongestSubstringSlidingWindow(s));
            System.out.println("Optimized: " + solution.lengthOfLongestSubstringOptimized(s));
            System.out.println("-----------------");
        }
    }
}
