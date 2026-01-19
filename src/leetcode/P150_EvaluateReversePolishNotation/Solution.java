package leetcode.P150_EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {

    /**
     * Problem 150: Evaluate Reverse Polish Notation
     * Approach: Stack
     * 
     * Theoretical Basis:
     * - Operands are pushed onto the stack.
     * - Operators pop two operands, perform operation, and push result back.
     * - Truncated division is handled by default integer division in Java.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = calculate(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        return "+-*/".contains(s) && s.length() == 1;
    }

    private int calculate(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["2","1","+","3","*"] -> 9
        String[] t1 = { "2", "1", "+", "3", "*" };
        System.out.println("Test 1: " + solution.evalRPN(t1));

        // ["4","13","5","/","+"] -> 6
        String[] t2 = { "4", "13", "5", "/", "+" };
        System.out.println("Test 2: " + solution.evalRPN(t2));

        // ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] -> 22
        String[] t3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println("Test 3: " + solution.evalRPN(t3));
    }
}
