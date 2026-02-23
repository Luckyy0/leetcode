package leet_code.Problem_1009_Easy_Complement_of_Base_10_Integer;

/**
 * Problem 1009: Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * (Same as 476. Number Complement)
 */
public class Solution {

    /**
     * Calculates the complement of a base-10 integer by flipping its binary digits.
     * Strategy: Bitwise XOR mask filtering.
     * 
     * @param n The integer to complement.
     * @return The complement integer.
     * 
     *         Tóm tắt chiến lược:
     *         1. Muốn đảo toàn bộ số 1 thành số 0 và ngược lại trong mã nhị phân
     *         thì phép toán phần cứng XOR (^) cực kì hữu hiệu. (x ^ 1 = lật x).
     *         2. Ví dụ: n = 5 (mã nhị phân: 101).
     *         Để đảo n, ta thiết kế một "Mặt Nạ" (Mask) sao cho toàn bộ bit của
     *         nó đều là 1 và dài đúng bằng n. Ở đây mask sẽ là 111 (só 7).
     *         Thực hiện lệnh: 101 ^ 111 -> Kết quả tự lật thành 010 (số 2).
     *         3. Cách thức dò mask: Bắt đầu cho mask = 1. Liên tục đẩy mặt nạ sang
     *         trái 1 bit rồi lấp lỗ hổng đó bằng 1 (`mask = (mask << 1) | 1`)
     *         cho đến chi chiều rộng của `mask` to lớn hơn hoặc bằng `n`.
     *         (Nghĩa là bit 1 lấp kín số đó.)
     *         4. Chú ý ngoại lệ đầu vào n = 0, bù cho số 0 phải là 1.
     *         5. Cuối cùng trả về `n ^ mask`.
     */
    public int bitwiseComplement(int n) {
        // Trường hợp duy nhất ngoại lệ và nằm ngoài vòng lặp bit là n == 0
        if (n == 0) {
            return 1;
        }

        // Tạo ra 1 mặt nạ bit kiểu: 1, 11, 111, 1111, tùy thuộc vào độ dài binary của
        // N.
        int mask = 1;
        while (mask < n) {
            // (mask << 1) sẽ dời toàn bộ trái 1 ô (Thêm 0 sau cùng)
            // | 1 sẽ thay con 0 đó thành 1.
            // Biến mặt nạ thành tường toàn 1 vững chắc.
            mask = (mask << 1) | 1;
        }

        // Bất kỳ số nguyên nào XOR với 1 cũng tự nghịch đảo giá trị bản thân.
        return n ^ mask;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.bitwiseComplement(5)); // expected 2
        System.out.println("Result 2: " + sol.bitwiseComplement(7)); // expected 0
        System.out.println("Result 3: " + sol.bitwiseComplement(10)); // expected 5
        System.out.println("Result 0: " + sol.bitwiseComplement(0)); // expected 1
    }
}
