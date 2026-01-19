package leetcode.P266_PalindromePermutation;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 266: Palindrome Permutation
     * Approach: HashSet toggle
     * 
     * Theoretical Basis:
     * - Palindrome allows at most one character with odd frequency.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) (charset size)
     */
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "code" -> false
        runTest(solution, "code", false);

        // "aab" -> true
        runTest(solution, "aab", true);

        // "carerac" -> true
        runTest(solution, "carerac", true);
    }

    private static void runTest(Solution s, String str, boolean expected) {
        boolean result = s.canPermutePalindrome(str);
        System.out.println("Input: " + str + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
