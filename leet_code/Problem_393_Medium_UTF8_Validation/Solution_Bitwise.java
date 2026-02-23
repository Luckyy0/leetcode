package leet_code.Problem_393_Medium_UTF8_Validation;

public class Solution_Bitwise {

    /**
     * Validates UTF-8 encoding.
     * Uses bit manipulation and a counter for expected bytes.
     * Time: O(N), Space: O(1).
     * 
     * Xác thực mã hóa UTF-8.
     * Sử dụng thao tác bit và một bộ đếm cho các byte mong đợi.
     */
    public boolean validUtf8(int[] data) {
        int nBytes = 0; // Number of continuation bytes expected
                        // Số byte tiếp theo được mong đợi

        for (int b : data) {
            if (nBytes == 0) {
                // Determine how many bytes the current character has
                // Xác định ký tự hiện tại có bao nhiêu byte
                if ((b >> 7) == 0b0) {
                    nBytes = 0;
                } else if ((b >> 5) == 0b110) {
                    nBytes = 1;
                } else if ((b >> 4) == 0b1110) {
                    nBytes = 2;
                } else if ((b >> 3) == 0b11110) {
                    nBytes = 3;
                } else {
                    // Invalid start byte (e.g., starts with 10 or 11111)
                    return false;
                }
            } else {
                // Check if current byte starts with 10
                // Kiểm tra xem byte hiện tại có bắt đầu bằng 10 không
                if ((b >> 6) != 0b10) {
                    return false;
                }
                nBytes--;
            }
        }

        return nBytes == 0;
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: [197, 130, 1] -> true
        System.out.println("Result 1: " + solution.validUtf8(new int[] { 197, 130, 1 }));

        // Test Case 2: [235, 140, 4] -> false
        System.out.println("Result 2: " + solution.validUtf8(new int[] { 235, 140, 4 }));
    }
}
