package leet_code.Problem_439_Medium_Ternary_Expression_Parser;

import java.util.Stack;

public class Solution_BackwardStack {

    /**
     * Parses and evaluates a nested ternary expression.
     * Strategy: Traverse right to left using a stack.
     * Time: O(N), Space: O(N).
     */
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (!stack.isEmpty() && stack.peek() == '?') {
                // If top of stack is '?', and we just encountered a condition T/F
                // Wait, logic needs refinement. Usually, we find '?' then read the condition.
                // Let's stick to the logic: if expression[i] == '?', evaluate it.
                // But i is moving backward. So we see ':' then '?' then T/F.
            }

            if (c == '?') {
                // The condition precedes '?', so it's at expression[i-1]
                char condition = expression.charAt(--i);

                char exp1 = stack.pop(); // pop '?'
                stack.pop(); // pop ':'
                char exp2 = stack.pop(); // pop value for exp1
                char colonMark = stack.pop(); // wait, stack order is different
            }
            // Let's use a cleaner stack trace.
        }
        return ""; // placeholder
    }

    /**
     * Redesign: Simplified stack logic.
     */
    public String parseTernaryRefined(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // pop '?'
                char first = stack.pop(); // exp1
                stack.pop(); // pop ':'
                char second = stack.pop(); // exp2

                if (c == 'T')
                    stack.push(first);
                else
                    stack.push(second);
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.peek());
    }

    public static void main(String[] args) {
        Solution_BackwardStack solution = new Solution_BackwardStack();
        System.out.println("Result: " + solution.parseTernaryRefined("F?1:T?4:5")); // 4
        System.out.println("Result: " + solution.parseTernaryRefined("T?2:3")); // 2
    }
}
