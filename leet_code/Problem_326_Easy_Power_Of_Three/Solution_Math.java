package leet_code.Problem_326_Easy_Power_Of_Three;

public class Solution_Math {

    /**
     * Checks if n is power of three.
     * Uses Math trick (Max integer power of 3).
     * Time: O(1), Space: O(1).
     * 
     * Kiểm tra xem n có phải là lũy thừa của ba không.
     * Sử dụng thủ thuật Toán học (Lũy thừa số nguyên lớn nhất của 3).
     */
    public boolean isPowerOfThree(int n) {
        // Max power of 3 in signed 32-bit integer is 3^19 = 1162261467
        // Lũy thừa lớn nhất của 3 trong số nguyên 32-bit có dấu là 3^19 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: 27 -> true
        System.out.println("Result 1: " + solution.isPowerOfThree(27));

        // Test Case 2: 0 -> false
        System.out.println("Result 2: " + solution.isPowerOfThree(0));

        // Test Case 3: 45 -> false
        System.out.println("Result 3: " + solution.isPowerOfThree(45));
    }
}
