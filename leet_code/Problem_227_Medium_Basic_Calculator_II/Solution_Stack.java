package leet_code.Problem_227_Medium_Basic_Calculator_II;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Evaluates a mathematical expression with +, -, *, /.
     * Uses a Stack to handle high-priority operations (*, /) immediately
     * and defer low-priority operations (+, -).
     * Time: O(N), Space: O(N).
     * 
     * Đánh giá biểu thức toán học với +, -, *, /.
     * Sử dụng Stack để xử lý các phép tính ưu tiên cao (*, /) ngay lập tức
     * và trì hoãn các phép tính ưu tiên thấp (+, -).
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+'; // Default operation for the first number
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            // If operator or end of string, process the accumulated number with the
            // previous operation
            // Nếu là toán tử hoặc cuối chuỗi, xử lý số đã tích lũy với toán tử trước đó
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: "3+2*2" -> 7
        System.out.println("Calc 1: " + solution.calculate("3+2*2"));

        // Test Case 2: " 3/2 " -> 1
        System.out.println("Calc 2: " + solution.calculate(" 3/2 "));

        // Test Case 3: " 3+5 / 2 " -> 5
        System.out.println("Calc 3: " + solution.calculate(" 3+5 / 2 "));
    }
}
