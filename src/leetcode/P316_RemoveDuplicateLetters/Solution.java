package leetcode.P316_RemoveDuplicateLetters;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * Problem 316: Remove Duplicate Letters
     * Approach: Monotonic Stack
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "bcabc" -> "abc"
        runTest(solution, "bcabc", "abc");

        // "cbacdcbc" -> "acdb"
        runTest(solution, "cbacdcbc", "acdb");
    }

    private static void runTest(Solution s, String str, String expected) {
        String result = s.removeDuplicateLetters(str);
        System.out.println("Input: " + str + " -> " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
