package leetcode.P242_ValidAnagram;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 242: Valid Anagram
     * Approach: Frequency Array (Bucket Sort logic)
     * 
     * Theoretical Basis:
     * - Anagrams have identical character counts.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) (Size 26)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "anagram", "nagaram" -> true
        runTest(solution, "anagram", "nagaram", true);

        // "rat", "car" -> false
        runTest(solution, "rat", "car", false);
    }

    private static void runTest(Solution s, String str1, String str2, boolean expected) {
        boolean result = s.isAnagram(str1, str2);
        System.out.println("Input: \"" + str1 + "\", \"" + str2 + "\"");
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
