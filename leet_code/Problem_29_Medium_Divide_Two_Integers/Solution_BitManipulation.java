package leet_code.Problem_29_Medium_Divide_Two_Integers;

public class Solution_BitManipulation {

    /**
     * Divides two integers without multiplication, division, or mod.
     * Uses Bit Manipulation.
     * Chia hai số nguyên mà không dùng nhân, chia, hoặc mod.
     * Sử dụng Thao tác Bit.
     */
    public int divide(int dividend, int divisor) {
        // Handle overflow case: INT_MIN / -1 = INT_MAX + 1 (overflow)
        // Xử lý trường hợp tràn số: INT_MIN / -1 = INT_MAX + 1 (tràn)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        // Xác định dấu
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to safely handle absolute values of INT_MIN
        // Chuyển sang long để xử lý an toàn giá trị tuyệt đối của INT_MIN
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;

        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // Shift divisor left as long as it's less than dividend
            // Dịch chuyển divisor sang trái miễn là nó nhỏ hơn dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            result += multiple;
        }

        if (negative) {
            return (int) -result;
        } else {
            return (int) result;
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_BitManipulation solution = new Solution_BitManipulation();

        // Test Case 1
        int d1 = 10, v1 = 3;
        System.out.println("Test Case 1: " + solution.divide(d1, v1));
        // Expected: 3

        // Test Case 2
        int d2 = 7, v2 = -3;
        System.out.println("Test Case 2: " + solution.divide(d2, v2));
        // Expected: -2

        // Test Case 3: Overflow
        int d3 = Integer.MIN_VALUE, v3 = -1;
        System.out.println("Test Case 3: " + solution.divide(d3, v3));
        // Expected: 2147483647 (Integer.MAX_VALUE)
    }
}
