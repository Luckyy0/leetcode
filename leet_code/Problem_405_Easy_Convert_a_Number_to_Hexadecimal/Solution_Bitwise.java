package leet_code.Problem_405_Easy_Convert_a_Number_to_Hexadecimal;

public class Solution_Bitwise {

    /**
     * Converts a number to hexadecimal.
     * Uses bit manipulation (unsigned right shift).
     * Time: O(1), Space: O(1).
     * 
     * Chuyển đổi một số sang hệ thập lục phân.
     * Sử dụng thao tác bit (dịch phải không dấu).
     */
    public String toHex(int num) {
        if (num == 0)
            return "0";

        char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();

        // At most 8 iterations for 32-bit (8 * 4 = 32)
        // Tối đa 8 lần lặp cho 32-bit
        int count = 0;
        while (num != 0 && count < 8) {
            // Get last 4 bits
            // Lấy 4 bit cuối
            int val = num & 15;
            sb.insert(0, map[val]);

            // Unsigned right shift by 4 bits
            // Dịch phải không dấu 4 bit
            num >>>= 4;
            count++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_Bitwise solution = new Solution_Bitwise();

        // Test Case 1: 26 -> "1a"
        System.out.println("Result 26: " + solution.toHex(26));

        // Test Case 2: -1 -> "ffffffff"
        System.out.println("Result -1: " + solution.toHex(-1));
    }
}
