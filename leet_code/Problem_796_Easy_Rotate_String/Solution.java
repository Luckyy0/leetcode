package leet_code.Problem_796_Easy_Rotate_String;

public class Solution {

    /**
     * Checks if s can be rotated to become goal.
     * Strategy: Check if goal is a substring of s + s.
     * Time: O(N^2) or O(N) depending on 'contains' implementation.
     * Space: O(N).
     */
    public boolean rotateString(String s, String goal) {
        // Rotations of A are contained in A + A.
        // Also must verify lengths match to avoid false positive like "abc" inside
        // "ababa"? No, "abc" inside "ababa" is false.
        // "abc", goal="ab" -> "abcabc" contains "ab". But length different.
        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.rotateString("abcde", "cdeab")); // true
        System.out.println("Result 2: " + sol.rotateString("abcde", "abced")); // false
    }
}
