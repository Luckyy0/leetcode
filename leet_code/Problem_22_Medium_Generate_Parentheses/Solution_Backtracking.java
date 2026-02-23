package leet_code.Problem_22_Medium_Generate_Parentheses;

public class Solution_Backtracking {

    static class MyArrayList<T> {
        Object[] elements;
        int size;

        public MyArrayList() {
            elements = new Object[10];
            size = 0;
        }

        public void add(T e) {
            if (size == elements.length) {
                Object[] newE = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newE, 0, size);
                elements = newE;
            }
            elements[size++] = e;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append("\"").append(elements[i]).append("\"");
                if (i < size - 1)
                    sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /**
     * Generates all combinations of well-formed parentheses.
     * Uses Backtracking.
     * Tạo tất cả các tổ hợp dấu ngoặc hợp lệ.
     * Sử dụng Quay lui.
     */
    public MyArrayList<String> generateParenthesis(int n) {
        MyArrayList<String> result = new MyArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(MyArrayList<String> result, String current, int open, int close, int max) {
        // Base case: current string length matches 2 * n
        // Trường hợp cơ sở: độ dài chuỗi hiện tại bằng 2 * n
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can add an open bracket, do it
        // Nếu có thể thêm dấu ngoặc mở, hãy thêm
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // If we can add a close bracket (must be less than open brackets)
        // Nếu có thể thêm dấu ngoặc đóng (phải ít hơn dấu ngoặc mở)
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        int n1 = 3;
        System.out.println("Test Case 1: " + solution.generateParenthesis(n1));
        // Expected: ["((()))", "(()())", "(())()", "()(())", "()()()"]

        // Test Case 2
        int n2 = 1;
        System.out.println("Test Case 2: " + solution.generateParenthesis(n2));
        // Expected: ["()"]
    }
}
