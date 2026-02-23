package leet_code.Problem_190_Easy_Reverse_Bits;

public class Solution_Bitwise {

    /**
     * Reverses the bits of a given 32-bit unsigned integer.
     * Uses bitwise operators for O(1) time complexity.
     * 
     * Đảo ngược các bit của một số nguyên không dấu 32-bit.
     * Sử dụng toán tử bitwise cho độ phức tạp thời gian O(1).
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        // Iterate through all 32 bits
        // Duyệt qua tất cả 32 bit
        for (int i = 0; i < 32; i++) {
            // Shift result to left to open up space for new bit
            // Dịch kết quả sang trái để mở không gian cho bit mới
            result <<= 1;

            // Get the last bit of n and add it to result
            // Lấy bit cuối của n và thêm vào result
            if ((n & 1) == 1) {
                result++; // or result |= 1;
            }

            // Shift n to right to process next bit
            // Dịch n sang phải để xử lý bit tiếp theo
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: 43261596 (binary ...0010100101000001111010011100)
        // Expected Output: 964176192 (binary 00111001011110000010100101000000)
        int n1 = 43261596;
        System.out.println("Reverse of 43261596: " + solution.reverseBits(n1));

        // Test Case 2: -3 (binary 1111...1101)
        // Reverse should be ...101111...
        int n2 = -3;
        System.out.println("Reverse of -3: " + solution.reverseBits(n2));
    }
}
