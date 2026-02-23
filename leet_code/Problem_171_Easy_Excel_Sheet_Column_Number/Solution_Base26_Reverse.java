package leet_code.Problem_171_Easy_Excel_Sheet_Column_Number;

public class Solution_Base26_Reverse {

    /**
     * Converts an Excel sheet column title to its corresponding column number.
     * Uses repetitive multiplication of base 26.
     * 
     * Chuyển đổi tiêu đề cột Excel thành số cột tương ứng.
     * Sử dụng phép nhân lặp lại của cơ số 26.
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            // Convert 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
            int val = c - 'A' + 1;

            // Standard positional system calculation
            // Tính toán hệ thống theo vị trí tiêu chuẩn
            result = result * 26 + val;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Base26_Reverse solution = new Solution_Base26_Reverse();

        // Test Case 1: "A" -> 1
        System.out.println("A -> " + solution.titleToNumber("A"));

        // Test Case 2: "AB" -> 28
        System.out.println("AB -> " + solution.titleToNumber("AB"));

        // Test Case 3: "ZY" -> 701
        System.out.println("ZY -> " + solution.titleToNumber("ZY"));
    }
}
