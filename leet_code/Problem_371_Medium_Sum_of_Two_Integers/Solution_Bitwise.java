package leet_code.Problem_371_Medium_Sum_of_Two_Integers;

public class Solution_Bitwise {

    /**
     * Sums two integers without + operator.
     * Uses XOR for sum and AND-Shift for carry.
     * Time: O(1), Space: O(1).
     * 
     * Cộng hai số nguyên mà không dùng toán tử +.
     * Sử dụng XOR cho tổng và AND-Shift cho phần nhớ.
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: 1, 2 -> 3
        System.out.println("1 + 2 = " + solution.getSum(1, 2));

        // Test Case 2: 2, 3 -> 5
        System.out.println("2 + 3 = " + solution.getSum(2, 3));

        // Test Case 3: -1, 1 -> 0
        System.out.println("-1 + 1 = " + solution.getSum(-1, 1));
    }
}
