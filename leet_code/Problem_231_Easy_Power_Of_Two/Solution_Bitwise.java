package leet_code.Problem_231_Easy_Power_Of_Two;

public class Solution_Bitwise {

    /**
     * Checks if a number is a power of two.
     * Uses the bitwise trick: n & (n-1) == 0.
     * Time: O(1), Space: O(1).
     * 
     * Kiểm tra xem một số có phải là lũy thừa của 2 hay không.
     * Sử dụng mẹo thao tác bit: n & (n-1) == 0.
     */
    public boolean isPowerOfTwo(int n) {
        // A number is a power of two if it's positive and has exactly one bit set.
        // n > 0 check is crucial because 0 and negative numbers are not powers of two.
        // Một số là lũy thừa của 2 nếu nó dương và có chính xác một bit được đặt.
        // Kiểm tra n > 0 rất quan trọng vì 0 và số âm không phải là lũy thừa của 2.
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: 1 -> true
        System.out.println("Is 1 power of two? " + solution.isPowerOfTwo(1));

        // Test Case 2: 16 -> true
        System.out.println("Is 16 power of two? " + solution.isPowerOfTwo(16));

        // Test Case 3: 3 -> false
        System.out.println("Is 3 power of two? " + solution.isPowerOfTwo(3));

        // Test Case 4: 0 -> false
        System.out.println("Is 0 power of two? " + solution.isPowerOfTwo(0));
    }
}
