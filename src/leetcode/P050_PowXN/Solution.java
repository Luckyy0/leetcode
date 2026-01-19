package leetcode.P050_PowXN;

public class Solution {

    /**
     * Problem 50: Pow(x, n)
     * Approach: Binary Exponentiation (Iterative)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public double myPow(double x, int n) {
        long N = n; // Use long to handle Integer.MIN_VALUE abs
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;
        double current_product = x;

        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 2.0, 10, 1024.0);
        runTest(solution, 2.1, 3, 9.261);
        runTest(solution, 2.0, -2, 0.25);
        runTest(solution, 2.0, Integer.MIN_VALUE, 0.0); // 1 / 2^2147483648 ~ 0
    }

    private static void runTest(Solution s, double x, int n, double expected) {
        System.out.println("Input: x=" + x + ", n=" + n);
        double result = s.myPow(x, n);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (Math.abs(result - expected) < 1e-5) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
