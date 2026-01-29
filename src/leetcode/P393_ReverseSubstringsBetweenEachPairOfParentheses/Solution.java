package leetcode.P393_ReverseSubstringsBetweenEachPairOfParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * Problem 393: Reverse Substrings Between Each Pair of Parentheses
     * Approach: Stack of StringBuilders
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder()); // outermost level

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder cur = stack.pop();
                cur.reverse();
                stack.peek().append(cur);
            } else {
                stack.peek().append(c);
            }
        }

        return stack.pop().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "(abcd)", "dcba");
        runTest(solution, "u(love)i", "uevoli");
        runTest(solution, "(ed(et(oc))el)", "leetcode");
        runTest(solution, "a(bcdefghijkl(mno)p)q", "apmnolkjihgfedcbq"); // additional test
    }

    private static void runTest(Solution s, String input, String expected) {
        String result = s.reverseParentheses(input);
        System.out.println("Input: " + input + " -> " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
