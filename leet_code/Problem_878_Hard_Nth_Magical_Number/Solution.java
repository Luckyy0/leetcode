package leet_code.Problem_878_Hard_Nth_Magical_Number;

/**
 * Problem 878: Nth Magical Number
 * https://leetcode.com/problems/nth-magical-number/
 */
public class Solution {

    /**
     * Finds the N-th magical number divisible by either a or b.
     * Strategy: Binary Search on the answer space combined with
     * the Principle of Inclusion-Exclusion.
     * 
     * @param n Index of magical number.
     * @param a First divisor.
     * @param b Second divisor.
     * @return N-th magical number modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một số x là kỳ ảo nếu nó chia hết cho a hoặc b.
     *         2. Số các số kỳ ảo <= x là: (x/a) + (x/b) - (x/LCM(a,b)).
     *         3. Vì hàm đếm này tăng đơn điệu theo x, ta dùng tìm kiếm nhị phân để
     *         tìm x.
     *         4. Phạm vi tìm kiếm từ min(a,b) đến n * min(a,b).
     */
    public int nthMagicalNumber(int n, int a, int b) {
        long A = a;
        long B = b;
        long MOD = 1_000_000_007;

        // Calculate Least Common Multiple (LCM)
        long l = (A * B) / gcd(A, B);

        long low = Math.min(A, B);
        long high = (long) n * Math.min(A, B);

        while (low < high) {
            long mid = low + (high - low) / 2;

            // Inclusion-Exclusion Principle
            long count = (mid / A) + (mid / B) - (mid / l);

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % MOD);
    }

    /**
     * Calculates Greatest Common Divisor (GCD) of two numbers.
     */
    private long gcd(long a, long b) {
        while (b > 0) {
            a %= b;
            // Swap a and b
            long temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.nthMagicalNumber(1, 2, 3)); // 2
        System.out.println("Result: " + sol.nthMagicalNumber(4, 2, 3)); // 6
    }
}
