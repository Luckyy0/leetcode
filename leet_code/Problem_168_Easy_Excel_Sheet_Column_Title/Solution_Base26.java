package leet_code.Problem_168_Easy_Excel_Sheet_Column_Title;

public class Solution_Base26 {

    /**
     * Converts a column number to an Excel sheet column title.
     * Uses base-26 conversion with a subtract-one shift.
     * 
     * Chuyển đổi số cột thành tiêu đề cột Excel.
     * Sử dụng chuyển đổi cơ số 26 với phép dịch trừ một.
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            // Subtract 1 to adjust 1-indexed Excel system to 0-indexed calculation
            // Trừ 1 để điều chỉnh hệ thống Excel (bắt đầu từ 1) sang tính toán (bắt đầu từ
            // 0)
            columnNumber--;

            int remainder = columnNumber % 26;
            char c = (char) ('A' + remainder);
            sb.append(c);

            columnNumber /= 26;
        }

        // The characters were added from least significant digit, so reverse.
        // Các ký tự được thêm từ hàng đơn vị, vì vậy cần đảo ngược lại.
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_Base26 solution = new Solution_Base26();

        // Test Case 1: 1 -> A
        System.out.println("1 -> " + solution.convertToTitle(1));

        // Test Case 2: 28 -> AB
        System.out.println("28 -> " + solution.convertToTitle(28));

        // Test Case 3: 701 -> ZY
        System.out.println("701 -> " + solution.convertToTitle(701));
    }
}
