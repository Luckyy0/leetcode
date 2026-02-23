package leet_code.Problem_342_Easy_Power_Of_Four;

public class Solution_Bitwise {

    /**
     * Checks if n is power of four.
     * Uses Power of 2 check + Modulo condition (or Mask).
     * Time: O(1), Space: O(1).
     * 
     * Kiểm tra xem n có phải là lũy thừa của bốn không.
     * Sử dụng kiểm tra Lũy thừa của 2 + điều kiện Modulo (hoặc Mask).
     */
    public boolean isPowerOfFour(int n) {
        // 1. n > 0
        // 2. n & (n - 1) == 0 (Power of 2: only one bit set)
        // 3. n % 3 == 1 (4^x - 1 is divisible by 3)
        // (4 - 1 = 3).

        return n > 0 && (n & (n - 1)) == 0 && (n % 3 == 1);

        // Alternative using Mask:
        // return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: 16 -> true
        System.out.println("Result 1: " + solution.isPowerOfFour(16));

        // Test Case 2: 5 -> false
        System.out.println("Result 2: " + solution.isPowerOfFour(5));

        // Test Case 3: 1 -> true
        System.out.println("Result 3: " + solution.isPowerOfFour(1));
    }
}
