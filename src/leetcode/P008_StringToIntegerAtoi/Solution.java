package leetcode.P008_StringToIntegerAtoi;

public class Solution {

    /**
     * Problem 8: String to Integer (atoi)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int myAtoi(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        // 1. Bỏ qua khoảng trắng đầu
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n)
            return 0; // All whitespaces

        // 2. Check sign
        // 2. Kiểm tra dấu
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // 3. Convert numbers
        // 3. Chuyển đổi số
        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check for overflow
            // 4. Kiểm tra tràn số
            // If result > MAX/10, next step (result * 10) will definitely overflow
            // If result == MAX/10, next step only overflows if digit > 7
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "42", 42);
        runTest(solution, "   -42", -42);
        runTest(solution, "4193 with words", 4193);
        runTest(solution, "words and 987", 0);
        runTest(solution, "-91283472332", -2147483648); // Clamped MIN
        runTest(solution, "2147483648", 2147483647); // Clamped MAX
        runTest(solution, "+1", 1);
        runTest(solution, "", 0);
        runTest(solution, " ", 0);
        runTest(solution, "2147483646", 2147483646); // Boundary check
    }

    private static void runTest(Solution s, String input, int expected) {
        System.out.println("Input: \"" + input + "\"");
        int result = s.myAtoi(input);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
