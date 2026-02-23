package leet_code.Problem_150_Medium_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Evaluates an arithmetic expression in Reverse Polish Notation.
     * Uses a Stack to store operands.
     * O(N) time and O(N) space.
     * 
     * Đánh giá biểu thức số học trong Ký pháp Ba Lan ngược.
     * Sử dụng Ngăn xếp để lưu trữ các toán hạng.
     * Thời gian O(N) và không gian O(N).
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop the two most recent operands
                // Lấy ra hai toán hạng gần nhất
                int b = stack.pop();
                int a = stack.pop();

                // Perform calculation based on operator
                // Thực hiện tính toán dựa trên toán tử
                int result = 0;
                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b; // Truncates toward zero by default in Java
                        break;
                }
                stack.push(result);
            } else {
                // Token is a number, parse and push
                // Token là một con số, phân tích và đẩy vào ngăn xếp
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: ["2","1","+","3","*"] -> 9
        String[] t1 = { "2", "1", "+", "3", "*" };
        System.out.println("Test Case 1: " + solution.evalRPN(t1));

        // Test Case 2: ["4","13","5","/","+"] -> 6
        String[] t2 = { "4", "13", "5", "/", "+" };
        System.out.println("Test Case 2: " + solution.evalRPN(t2));

        // Test Case 3: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] -> 22
        String[] t3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println("Test Case 3: " + solution.evalRPN(t3));
    }
}
