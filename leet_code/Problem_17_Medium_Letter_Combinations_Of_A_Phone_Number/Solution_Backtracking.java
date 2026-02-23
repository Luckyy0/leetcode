package leet_code.Problem_17_Medium_Letter_Combinations_Of_A_Phone_Number;

public class Solution_Backtracking {

    /**
     * Custom generic List-like structure.
     * Cấu trúc giống List tùy chỉnh.
     */
    static class MyArrayList<T> {
        Object[] elements;
        int size;

        public MyArrayList() {
            elements = new Object[10];
            size = 0;
        }

        public void add(T element) {
            if (size == elements.length) {
                Object[] newElements = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newElements, 0, size);
                elements = newElements;
            }
            elements[size++] = element;
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

    private static final String[] KEYS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    /**
     * Generates letter combinations.
     * Uses Backtracking.
     * Tạo các tổ hợp chữ cái.
     * Sử dụng Quay lui.
     */
    public MyArrayList<String> letterCombinations(String digits) {
        MyArrayList<String> result = new MyArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(MyArrayList<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = KEYS[digit];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(result, digits, index + 1, current);
            // Backtrack: removing the last character
            // Quay lui: xóa ký tự cuối cùng
            current.deleteCharAt(current.length() - 1);
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        String d1 = "23";
        System.out.println("Test Case 1: " + solution.letterCombinations(d1));
        // Expected: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        // Test Case 2
        String d2 = "";
        System.out.println("Test Case 2: " + solution.letterCombinations(d2));
        // Expected: []

        // Test Case 3
        String d3 = "2";
        System.out.println("Test Case 3: " + solution.letterCombinations(d3));
        // Expected: ["a", "b", "c"]
    }
}
