package leet_code.Problem_13_Easy_Roman_To_Integer;

public class Solution_Switch {

    /**
     * Converts a Roman numeral to an integer.
     * Uses O(N) Time and O(1) Space.
     * Chuyển đổi một số La Mã thành số nguyên.
     * Sử dụng O(N) Thời gian và O(1) Không gian.
     */
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentVal = getValue(s.charAt(i));

            // Check if there is a next value and if the current value is less than the next
            // value
            // Kiểm tra xem có giá trị tiếp theo không và giá trị hiện tại có nhỏ hơn giá
            // trị tiếp theo không
            if (i < n - 1 && currentVal < getValue(s.charAt(i + 1))) {
                sum -= currentVal;
            } else {
                sum += currentVal;
            }
        }

        return sum;
    }

    /**
     * Helper to get value of a Roman character.
     * Hàm hỗ trợ lấy giá trị của ký tự La Mã.
     */
    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Switch solution = new Solution_Switch();

        // Test Case 1
        String s1 = "III";
        System.out.println("Test Case 1: " + solution.romanToInt(s1));
        // Expected: 3

        // Test Case 2
        String s2 = "LVIII";
        System.out.println("Test Case 2: " + solution.romanToInt(s2));
        // Expected: 58

        // Test Case 3
        String s3 = "MCMXCIV";
        System.out.println("Test Case 3: " + solution.romanToInt(s3));
        // Expected: 1994
    }
}
