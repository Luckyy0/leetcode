package leet_code.Problem_66_Easy_Plus_One;

import java.util.Arrays;

public class Solution_Array {

    /**
     * Increments the large integer represented as an array of digits by one.
     * Uses a linear scan from right to handle carry.
     * Tăng số nguyên lớn được đại diện bởi một mảng các chữ số lên một đơn vị.
     * Sử dụng duyệt tuyến tính từ bên phải để xử lý số nhớ.
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // If current digit is less than 9, just increment and return
                // Nếu chữ số hiện tại nhỏ hơn 9, chỉ cần tăng lên và trả về
                digits[i]++;
                return digits;
            }

            // Current digit is 9, becomes 0 and carry continues
            // Chữ số hiện tại là 9, trở thành 0 và số nhớ tiếp tục
            digits[i] = 0;
        }

        // If we reach here, it means all digits were 9 (e.g., 999 -> 1000)
        // Nếu đến được đây, có nghĩa là tất cả các chữ số đều là 9
        int[] result = new int[n + 1];
        result[0] = 1; // The rest are already 0 by default in Java

        return result;
    }

    public static void main(String[] args) {
        Solution_Array solution = new Solution_Array();

        // Test Case 1
        int[] d1 = { 1, 2, 3 };
        System.out.println("Test Case 1: " + Arrays.toString(solution.plusOne(d1)));
        // Expected: [1, 2, 4]

        // Test Case 2
        int[] d2 = { 9, 9, 9 };
        System.out.println("Test Case 2: " + Arrays.toString(solution.plusOne(d2)));
        // Expected: [1, 0, 0, 0]
    }
}
