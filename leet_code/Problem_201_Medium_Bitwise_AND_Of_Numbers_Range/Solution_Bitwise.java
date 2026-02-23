package leet_code.Problem_201_Medium_Bitwise_AND_Of_Numbers_Range;

public class Solution_Bitwise {

    /**
     * Calculates the bitwise AND of all numbers in the range [left, right].
     * Uses the common prefix logic by shifting.
     * Time: O(1) (max 32 shifts), Space: O(1).
     * 
     * Tính toán bitwise AND của tất cả các số trong khoảng [left, right].
     * Sử dụng logic tiền tố chung bằng cách dịch bit.
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;

        // Find the common prefix by shifting right until numbers are equal
        // Tìm tiền tố chung bằng cách dịch phải cho đến khi các số bằng nhau
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }

        // Shift back to the left to obtain the result
        // Dịch ngược lại sang trái để lấy kết quả
        return left << shiftCount;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: [5, 7] -> 4
        System.out.println("Range [5, 7]: " + solution.rangeBitwiseAnd(5, 7));

        // Test Case 2: [0, 0] -> 0
        System.out.println("Range [0, 0]: " + solution.rangeBitwiseAnd(0, 0));

        // Test Case 3: [1, 2147483647] -> 0
        System.out.println("Range [1, 2147483647]: " + solution.rangeBitwiseAnd(1, 2147483647));
    }
}
