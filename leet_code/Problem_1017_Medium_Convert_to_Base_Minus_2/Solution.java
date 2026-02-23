package leet_code.Problem_1017_Medium_Convert_to_Base_Minus_2;

/**
 * Problem 1017: Convert to Base -2
 * https://leetcode.com/problems/convert-to-base-2/
 */
public class Solution {

    /**
     * Converts an integer to its base -2 binary string representation.
     * Strategy: Negative Division & Remainder Adjustment.
     * 
     * @param n The integer to convert.
     * @return The base -2 string.
     * 
     *         Tóm tắt chiến lược:
     *         1. Việc cộng dồn những con luỹ thừa Âm 2 (-2, 4, -8, 16) từ đỉnh
     *         xuống vô cùng hỗn loạn do dấu nhảy lung tung.
     *         2. Thay vì đoán số bự từ trên giáng xuống, chuyển hướng CHIA XẺ N
     *         từ đáy xẻ lên. Mượn lại mẹo Toán Học "Chia hệ nhị phân" bằng phép lấy
     *         dư.
     *         3. Công thức: Cứ lấy N chia cho Cơ Số (-2). Chữ số cần tìm chính là
     *         SỐ DƯ (Remainder). Ghi số dư vào chuỗi rỗng.
     *         - Rồi biến đổi N thành THƯƠNG SỐ vừa chia (Q). Tiếp tục quá trình cho
     *         tới khi N cạn kiệt thành 0.
     *         4. VẬN RỦI: Trong ngôn ngữ lập trình, phép chia cho số Âm thi thoảng
     *         đẻ
     *         ra SỐ DƯ ÂM. (Ví dụ: -3 chia -2 bằng 1, dư -1!).
     *         5. Bất cứ Hệ cơ số nào thì chữ số cũng KHÔNG ĐƯỢC PHÉP LÀ SỐ ÂM.
     *         Trong hệ Nhị Phân chữ số là "0" hoặc "1". Chẳng có chữ "-1" nào cả.
     *         6. TÙY CƠ ỨNG BIẾN KHI GẶP DƯ "-1":
     *         - Biến rủi thành may: Ta cướp đi 1 đơn vị của Thương Số (-2 x 1 =
     *         -2),
     *         bù nó ngược vào Dư Số (+2).
     *         Nghĩa là: Thương Số (Quotient) tự phình thêm 1, còn Số Dư tự Cộng
     *         thêm 2.
     *         - Lúc này, Dư "-1" cắn thuốc liền biến thành "1"! Vẹn cả đôi đường!
     *         7. Thuận buồm xuôi gió đảo ngược (reverse) Chuỗi Kết quả cuối cùng.
     */
    public String baseNeg2(int n) {
        // Trường hợp N = 0 tẻ nhạt
        if (n == 0) {
            return "0";
        }

        // Băng chuyền lắp ráp chữ số
        StringBuilder result = new StringBuilder();

        // Gọt giũa N tới khi hóa 0
        while (n != 0) {
            int remainder = n % -2;
            n = n / -2;

            // Xử lý thần kỳ: Khử số Dư âm về chuẩn
            if (remainder < 0) {
                // Biến dư -1 thành số 1 "chính diện"
                remainder += 2;
                // Cưỡng chế bù đắp cân nặng cho Thương số mới đẩy ngược lên 1 bậc
                n += 1;
            }

            // Móc Dư số lên móc áo treo
            result.append(remainder);
        }

        // Thuật toán ép số đuôi lên đầu (từ phải qua trái), bắt buộc phải Lộn Ngược
        // chuỗi.
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.baseNeg2(2)); // expected "110"
        System.out.println("Result 2: " + sol.baseNeg2(3)); // expected "111"
        System.out.println("Result 3: " + sol.baseNeg2(4)); // expected "100"
    }
}
