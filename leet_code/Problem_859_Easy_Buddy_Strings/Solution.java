package leet_code.Problem_859_Easy_Buddy_Strings;

import java.util.*;

/**
 * Problem 859: Buddy Strings
 * https://leetcode.com/problems/buddy-strings/
 */
public class Solution {

    /**
     * Determines if exactly one swap in s makes it equal to goal.
     * Strategy: Check for two cases: s equals goal or s differs from goal.
     * 
     * @param s    The source string.
     * @param goal The target string.
     * @return True if buddy strings.
     * 
     *         Tóm tắt chiến lược:
     *         1. Nếu s bằng goal, s phải có ít nhất một ký tự trùng lặp để tráo đổi
     *         mà
     *         không làm thay đổi chuỗi.
     *         2. Nếu s khác goal, độ dài phải bằng nhau và chỉ được có đúng 2 vị
     *         trí
     *         khác biệt sao cho s[i]==goal[j] và s[j]==goal[i].
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        // Case: s and goal are identical
        if (s.equals(goal)) {
            // We need at least one character to appear twice to swap it with itself
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                if (++counts[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        // Case: s and goal are different
        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIndices.add(i);
            }
        }

        // there must be exactly two differences
        if (diffIndices.size() != 2) {
            return false;
        }

        int i = diffIndices.get(0);
        int j = diffIndices.get(1);

        // The cross-swap must fix the differences
        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.buddyStrings("ab", "ba")); // true
        System.out.println("Result: " + sol.buddyStrings("ab", "ab")); // false
        System.out.println("Result: " + sol.buddyStrings("aa", "aa")); // true
    }
}
