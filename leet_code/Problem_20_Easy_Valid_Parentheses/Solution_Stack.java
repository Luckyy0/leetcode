package leet_code.Problem_20_Easy_Valid_Parentheses;

public class Solution_Stack {

    /**
     * Checks if the parentheses string is valid.
     * Uses a custom array-based Stack.
     * Kiểm tra xem chuỗi ngoặc có hợp lệ không.
     * Sử dụng Stack tùy chỉnh dựa trên mảng.
     */
    public boolean isValid(String s) {
        // Use a char array as a stack
        // Sử dụng mảng char làm stack
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            // Push open brackets
            // Đẩy các dấu ngoặc mở vào
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else {
                // If stack is empty, no matching open bracket
                // Nếu stack rỗng, không có dấu ngoặc mở tương ứng
                if (top == -1) {
                    return false;
                }

                // Pop and check validity
                // Lấy ra và kiểm tra tính hợp lệ
                char open = stack[top--];
                if (c == ')' && open != '(')
                    return false;
                if (c == '}' && open != '{')
                    return false;
                if (c == ']' && open != '[')
                    return false;
            }
        }

        // Return true only if stack is empty
        // Chỉ trả về true nếu stack rỗng
        return top == -1;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1
        String s1 = "()";
        System.out.println("Test Case 1: " + solution.isValid(s1));
        // Expected: true

        // Test Case 2
        String s2 = "()[]{}";
        System.out.println("Test Case 2: " + solution.isValid(s2));
        // Expected: true

        // Test Case 3
        String s3 = "(]";
        System.out.println("Test Case 3: " + solution.isValid(s3));
        // Expected: false

        // Test Case 4: Unclosed
        String s4 = "(()";
        System.out.println("Test Case 4: " + solution.isValid(s4));
        // Expected: false
    }
}
