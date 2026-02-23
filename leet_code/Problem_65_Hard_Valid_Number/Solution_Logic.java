package leet_code.Problem_65_Hard_Valid_Number;

public class Solution_Logic {

    /**
     * Checks if a string is a valid number.
     * Uses state tracking flags.
     * Kiểm tra xem một chuỗi có phải là số hợp lệ không.
     * Sử dụng các cờ theo dõi trạng thái.
     */
    public boolean isValidNumber(String s) {
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitSeen = true;
            } else if (c == '.') {
                // Cannot have more than one dot or a dot after 'e'
                // Không thể có nhiều hơn một dấu chấm hoặc dấu chấm sau 'e'
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                // Cannot have more than one 'e' or 'e' before any digit
                // Không thể có nhiều hơn một 'e' hoặc 'e' trước khi thấy bất kỳ chữ số nào
                if (eSeen || !digitSeen) {
                    return false;
                }
                eSeen = true;
                digitSeen = false; // Need digits after 'e'
            } else if (c == '+' || c == '-') {
                // Sign can only appear at start or after 'e'
                // Dấu chỉ có thể xuất hiện ở đầu hoặc sau 'e'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return digitSeen;
    }

    public static void main(String[] args) {
        Solution_Logic solution = new Solution_Logic();

        // Valid cases
        System.out.println("Test Case 1 (0): " + solution.isValidNumber("0")); // True
        System.out.println("Test Case 2 (2e10): " + solution.isValidNumber("2e10")); // True
        System.out.println("Test Case 3 (-.9): " + solution.isValidNumber("-.9")); // True
        System.out.println("Test Case 4 (3e+7): " + solution.isValidNumber("3e+7")); // True

        // Invalid cases
        System.out.println("Test Case 5 (e): " + solution.isValidNumber("e")); // False
        System.out.println("Test Case 6 (.): " + solution.isValidNumber(".")); // False
        System.out.println("Test Case 7 (99e2.5): " + solution.isValidNumber("99e2.5")); // False
    }
}
