package leet_code.Problem_224_Hard_Basic_Calculator;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Evaluates a basic mathematical expression with +, -, and ().
     * Uses a Stack to handle parentheses and recursion simulation.
     * Time: O(N), Space: O(N).
     * 
     * Đánh giá một biểu thức toán học cơ bản với +, -, và ().
     * Sử dụng Stack để xử lý dấu ngoặc và mô phỏng đệ quy.
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1; // 1 represents +, -1 represents -

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // Parse the full number (might be multiple digits)
                // Phân tích toàn bộ số (có thể có nhiều chữ số)
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // Backtrack one step because the loop incremented extra

                // Add to result with current sign
                // Cộng vào kết quả với dấu hiện tại
                result += sign * num;

            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                // Push result and sign onto stack for later
                // Đẩy kết quả và dấu vào stack để dùng sau
                stack.push(result);
                stack.push(sign);

                // Reset for the inner expression
                // Đặt lại cho biểu thức bên trong
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Evaluate the expression inside parentheses
                // result is currently the result of the parenthesis
                // result hiện tại là kết quả của dấu ngoặc

                // Apply the sign before the parenthesis
                // Áp dụng dấu trước dấu ngoặc
                result *= stack.pop();

                // Add to the result before the parenthesis
                // Cộng với kết quả trước dấu ngoặc
                result += stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: "1 + 1" -> 2
        System.out.println("Calc 1: " + solution.calculate("1 + 1"));

        // Test Case 2: " 2-1 + 2 " -> 3
        System.out.println("Calc 2: " + solution.calculate(" 2-1 + 2 "));

        // Test Case 3: "(1+(4+5+2)-3)+(6+8)" -> 23
        System.out.println("Calc 3: " + solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
