package leet_code.Problem_7_Medium_Reverse_Integer;

public class Solution_Math {

    /**
     * Reverses the digits of a 32-bit signed integer.
     * Returns 0 if result overflows.
     * Đảo ngược các chữ số của một số nguyên 32-bit có dấu.
     * Trả về 0 nếu kết quả bị tràn.
     */
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Check for overflow before multiplying by 10
            // Integer.MAX_VALUE is 2147483647
            // Kiểm tra tràn số trước khi nhân với 10
            // Integer.MAX_VALUE là 2147483647
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            // Check for underflow
            // Integer.MIN_VALUE is -2147483648
            // Kiểm tra tràn số âm
            // Integer.MIN_VALUE là -2147483648
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1
        int x1 = 123;
        System.out.println("Test Case 1: " + solution.reverse(x1));
        // Expected: 321

        // Test Case 2
        int x2 = -123;
        System.out.println("Test Case 2: " + solution.reverse(x2));
        // Expected: -321

        // Test Case 3
        int x3 = 120;
        System.out.println("Test Case 3: " + solution.reverse(x3));
        // Expected: 21

        // Test Case 4: Overflow
        int x4 = 1534236469; // Reverse > MAX_VALUE
        System.out.println("Test Case 4: " + solution.reverse(x4));
        // Expected: 0
    }
}
