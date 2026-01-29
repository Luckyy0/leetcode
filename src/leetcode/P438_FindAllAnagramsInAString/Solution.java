package leetcode.P438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 438: Find All Anagrams in a String
     * Approach: Sliding Window with Frequency Array
     * 
     * Time Complexity: O(N) where N is s.length()
     * Space Complexity: O(1) as arrays are size 26
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        // Initial window
        for (int i = 0; i < p.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pFreq, sFreq)) {
            result.add(0);
        }

        for (int i = 1; i <= s.length() - p.length(); i++) {
            // Remove previous char
            sFreq[s.charAt(i - 1) - 'a']--;
            // Add next char
            sFreq[s.charAt(i + p.length() - 1) - 'a']++;

            if (Arrays.equals(pFreq, sFreq)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "cbaebabacd", "abc" -> [0, 6]
        System.out.println("Result 1: " + sol.findAnagrams("cbaebabacd", "abc"));

        // "abab", "ab" -> [0, 1, 2]
        System.out.println("Result 2: " + sol.findAnagrams("abab", "ab"));
    }
}
