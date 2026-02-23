package leet_code.Problem_50_Medium_Pow_x_n;

public class Solution_FastPower {

    /**
     * Calculates x^n.
     * Uses Binary Exponentiation (Fast Power).
     * Tính x^n.
     * Sử dụng Lũy Thừa Nhị Phân (Tính nhanh lũy thừa).
     */
    public double myPow(double x, int n) {
        long N = n; // Use long to avoid overflow when n is Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_FastPower solution = new Solution_FastPower();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.myPow(2.0, 10));
        // Expected: 1024.0

        // Test Case 2
        System.out.println("Test Case 2: " + solution.myPow(2.1, 3));
        // Expected: 9.261

        // Test Case 3: Negative exponent
        System.out.println("Test Case 3: " + solution.myPow(2.0, -2));
        // Expected: 0.25

        // Test Case 4: Min value exponent
        System.out.println("Test Case 4: " + solution.myPow(1.0, Integer.MIN_VALUE));
        // Expected: 1.0
    }
}
