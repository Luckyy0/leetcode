package leet_code.Problem_172_Medium_Factorial_Trailing_Zeroes;

public class Solution_Math {

    /**
     * Calculates the number of trailing zeroes in n!.
     * Based on counting factors of 5.
     * Time: O(log N), Space: O(1).
     * 
     * Tính số lượng chữ số 0 tận cùng của n!.
     * Dựa trên việc đếm các thừa số 5.
     * Thời gian: O(log N), Không gian: O(1).
     */
    public int trailingZeroes(int n) {
        int count = 0;

        // Count factors of 5, 25, 125, etc.
        // Đếm các thừa số 5, 25, 125, v.v.
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: 3 -> 0
        System.out.println("3! Trailing Zeroes: " + solution.trailingZeroes(3));

        // Test Case 2: 5 -> 1
        System.out.println("5! Trailing Zeroes: " + solution.trailingZeroes(5));

        // Test Case 3: 100 -> 24
        System.out.println("100! Trailing Zeroes: " + solution.trailingZeroes(100));
    }
}
