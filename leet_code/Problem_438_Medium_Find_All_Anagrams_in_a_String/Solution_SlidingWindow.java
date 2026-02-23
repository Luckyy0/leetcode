package leet_code.Problem_438_Medium_Find_All_Anagrams_in_a_String;

import java.util.*;

public class Solution_SlidingWindow {

    /**
     * Finds all start indices of p's anagrams in s.
     * Strategy: Use character frequency arrays with sliding window.
     * Time: O(N), Space: O(1).
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length())
            return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int n = s.length();
        int m = p.length();

        // Initial window
        for (int i = 0; i < m; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount))
            result.add(0);

        // Slide window
        for (int i = m; i < n; i++) {
            // Add new char
            sCount[s.charAt(i) - 'a']++;
            // Remove old char
            sCount[s.charAt(i - m) - 'a']--;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - m + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();
        System.out.println("Result 1: " + solution.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println("Result 2: " + solution.findAnagrams("abab", "ab")); // [0, 1, 2]
    }
}
