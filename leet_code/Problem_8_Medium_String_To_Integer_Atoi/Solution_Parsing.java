package leet_code.Problem_8_Medium_String_To_Integer_Atoi;

public class Solution_Parsing {

    /**
     * Converts a string to a 32-bit signed integer (atoi implementation).
     * Handles whitespace, sign, non-digit characters, and overflow.
     * Chuyển đổi một chuỗi thành số nguyên 32-bit có dấu (cài đặt atoi).
     * Xử lý khoảng trắng, dấu, ký tự không phải số, và tràn số.
     */
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        // 1. Skip leading whitespace
        // 1. Bỏ qua khoảng trắng ở đầu
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Return 0 if string contains only whitespace or is empty
        // Trả về 0 nếu chuỗi chỉ chứa khoảng trắng hoặc rỗng
        if (index == n) {
            return 0;
        }

        // 2. Check for sign
        // 2. Kiểm tra dấu
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }

        // 3. Read digits
        // 3. Đọc các chữ số
        int result = 0;
        while (index < n) {
            char c = s.charAt(index);

            // If not a digit, stop parsing
            // Nếu không phải là chữ số, dừng phân tích
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            // 4. Check for overflow/underflow
            // Check if result * 10 + digit > Integer.MAX_VALUE
            // 4. Kiểm tra tràn số (dương/âm)
            // Kiểm tra xem result * 10 + digit > Integer.MAX_VALUE
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {

                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Parsing solution = new Solution_Parsing();

        // Test Case 1
        String s1 = "42";
        System.out.println("Test Case 1: " + solution.myAtoi(s1));
        // Expected: 42

        // Test Case 2
        String s2 = "   -42";
        System.out.println("Test Case 2: " + solution.myAtoi(s2));
        // Expected: -42

        // Test Case 3
        String s3 = "4193 with words";
        System.out.println("Test Case 3: " + solution.myAtoi(s3));
        // Expected: 4193

        // Test Case 4: Overflow
        String s4 = "-91283472332";
        System.out.println("Test Case 4: " + solution.myAtoi(s4));
        // Expected: -2147483648 (Integer.MIN_VALUE)

        // Test Case 5: Non-digit start
        String s5 = "words and 987";
        System.out.println("Test Case 5: " + solution.myAtoi(s5));
        // Expected: 0
    }
}
