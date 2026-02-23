package leet_code.Problem_258_Easy_Add_Digits;

public class Solution_Math {

    /**
     * Calculates the digital root of a number.
     * Uses O(1) mathematical formula based on Congruence formula.
     * Time: O(1), Space: O(1).
     * 
     * Tính căn số của một số.
     * Sử dụng công thức toán học O(1) dựa trên công thức Đồng dư.
     */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: 38 -> 2
        System.out.println("Add Digits 38: " + solution.addDigits(38));

        // Test Case 2: 0 -> 0
        System.out.println("Add Digits 0: " + solution.addDigits(0));

        // Test Case 3: 18 -> 9
        System.out.println("Add Digits 18: " + solution.addDigits(18));
    }
}
