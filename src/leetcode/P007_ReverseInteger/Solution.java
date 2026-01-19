package leetcode.P007_ReverseInteger;

public class Solution {

    /**
     * Problem 7: Reverse Integer
     * Time Complexity: O(log(x))
     * Space Complexity: O(1)
     */
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Check for potential overflow before adding digit
            // Kiểm tra khả năng tràn số trước khi thêm chữ số

            // Positive Overflow Check
            // MAX_VALUE = 2147483647 (last digit 7)
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            // Negative Overflow Check
            // MIN_VALUE = -2147483648 (last digit -8)
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1. Standard Case
        runTest(solution, 123, 321);

        // 2. Negative
        runTest(solution, -123, -321);

        // 3. Trailing Zero
        runTest(solution, 120, 21);

        // 4. Overflow Case (1534236469 -> 9646324351 which > MAX_INT)
        runTest(solution, 1534236469, 0);

        // 5. Overflow Case Negative
        // -2147483648 reversed is basically overflow since 846... > MAX
        runTest(solution, -2147483648, 0);
    }

    private static void runTest(Solution s, int input, int expected) {
        System.out.println("Input: " + input);
        int result = s.reverse(input);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
