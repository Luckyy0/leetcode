package leet_code.Problem_32_Hard_Longest_Valid_Parentheses;

public class Solution_Stack {

    /**
     * Finds the length of longest valid parentheses.
     * Uses Stack approach.
     * Tìm độ dài chuỗi ngoặc hợp lệ dài nhất.
     * Sử dụng phương pháp Stack.
     */
    public int longestValidParentheses(String s) {
        // Use an array as a stack to store indices
        // Sử dụng mảng làm stack để lưu trữ chỉ số
        int[] stack = new int[s.length() + 1];
        int top = -1;

        // Push -1 as the initial base index
        // Đẩy -1 làm chỉ số cơ sở ban đầu
        stack[++top] = -1;

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack[++top] = i;
            } else {
                // Determine if this closing bracket matches an open bracket
                // Xác định xem dấu ngoặc đóng này có khớp với dấu ngoặc mở không
                top--; // Pop

                if (top == -1) {
                    // Stack is empty, meaning this ')' is unmatched and becomes the new base
                    // Stack rỗng, nghĩa là ')' này không khớp và trở thành cơ sở mới
                    stack[++top] = i;
                } else {
                    // Calculate valid length
                    // Tính độ dài hợp lệ
                    int currentLen = i - stack[top];
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                    }
                }
            }
        }

        return maxLen;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1
        String s1 = "(()";
        System.out.println("Test Case 1: " + solution.longestValidParentheses(s1));
        // Expected: 2

        // Test Case 2
        String s2 = ")()())";
        System.out.println("Test Case 2: " + solution.longestValidParentheses(s2));
        // Expected: 4

        // Test Case 3
        String s3 = "";
        System.out.println("Test Case 3: " + solution.longestValidParentheses(s3));
        // Expected: 0
    }
}
