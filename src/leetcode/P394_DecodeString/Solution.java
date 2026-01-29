package leetcode.P394_DecodeString;

import java.util.Stack;

public class Solution {

    /**
     * Problem 394: Decode String
     * Approach: Two Stacks
     * 
     * Time Complexity: O(N) where N is the length of the decoded string.
     * Space Complexity: O(N)
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                resStack.push(res);
                res = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = res;
                int count = countStack.pop();
                res = resStack.pop();
                while (count-- > 0) {
                    res.append(temp);
                }
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "3[a]2[bc]" -> "aaabcbc"
        runTest(solution, "3[a]2[bc]", "aaabcbc");

        // "3[a2[c]]" -> "accaccacc"
        runTest(solution, "3[a2[c]]", "accaccacc");

        // "2[abc]3[cd]ef" -> "abcabccdcdcdef"
        runTest(solution, "2[abc]3[cd]ef", "abcabccdcdcdef");

        // "abc3[cd]xyz" -> "abccdcdcdxyz"
        runTest(solution, "abc3[cd]xyz", "abccdcdcdxyz");
    }

    private static void runTest(Solution sol, String s, String expected) {
        String result = sol.decodeString(s);
        System.out.println("Input: \"" + s + "\" -> Result: \"" + result + "\" (Expected: \"" + expected + "\")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
