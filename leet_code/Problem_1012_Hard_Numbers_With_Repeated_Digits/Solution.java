package leet_code.Problem_1012_Hard_Numbers_With_Repeated_Digits;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1012: Numbers With Repeated Digits
 * https://leetcode.com/problems/numbers-with-repeated-digits/
 */
public class Solution {

    /**
     * Finds the number of positive integers <= n that have at least one repeated
     * digit.
     * Strategy: Combinatorics (Counting numbers with unique digits).
     * 
     * @param n The upper limit integer.
     * @return The count of numbers with repeated digits.
     * 
     *         Tóm tắt chiến lược:
     *         1. Muốn tìm số lượng những con số LẶP LẠI rất khó và rắc rối. Nên
     *         dùng nguyên lý bù đắp:
     *         (Chứa Lặp Lại) = (Toàn Bộ N Số) - (KHÔNG Lặp Lại Chút Nào)
     *         2. Hãy đi tìm số CÁC CON SỐ ĐỘC NHẤT (Unique Digits) < N + 1.
     *         3. Để cho thân thiện, biến N+1 thành List các chữ số rời [d0, d1,
     *         ..., dk]
     *         4. Phần 1: Các số Độc Nhất mang chiều rộng thấp hơn len(N):
     *         - Chiều rộng 1 (vd: 1-9): có 9 số (vì đầu số 0 vô nghĩa).
     *         - Chiều rộng i: chọn đầu 9 cách (1-9), chọn sau 9, 8, 7,.. -> 9 *
     *         P(9, i-1).
     *         Ta cộng gom nó lại thành Base Độc Nhất.
     *         5. Phần 2: Các số Độc Nhất mang chiều rộng y đúc len(N) nhưng có tiền
     *         tố:
     *         - Khóa từng chữ số đầu tiên `d`.
     *         - Xét `j` chạy từ 0 đến bé hơn `d` (Với i=0, j xuất phát từ 1 vì đứng
     *         đầu).
     *         - Nhờ `j < d`, dãy sinh mới này chắc chắn thấp hơn nhánh cha Nết nên
     *         ta
     *         tính Tổ hợp số còn lại (9 - i mống) rớt vào (len - i - 1 vị trí):
     *         P(m, k).
     *         - Sau khi cộng P đó, ta "Đánh dấu" `d` là đã dùng `seen[d] = true`.
     *         Rồi
     *         khóa 1 nấc `i` vào để tiến đánh tiền tố kế tiếp.
     *         - Bất ngờ nếu `seen[d]` đã tồn tại từ trước, thì cái tiền tố chính
     *         diện của
     *         cái N này bản chất đã Phế Phẩm (Tự bản thân nó lặp lại). Ta chặt đứt
     *         gốc rễ
     *         `break`.
     *         6. Trả kết quả: N - TotalUniqueDigits
     */
    public int numDupDigitsAtMostN(int n) {
        // Biến N thành N+1 để sử dụng phép < mượt mà hơn phép <=
        List<Integer> digits = new ArrayList<>();
        for (int x = n + 1; x > 0; x /= 10) {
            digits.add(0, x % 10);
        }

        int uniqueCount = 0;
        int len = digits.size();

        // 1. Phép cộng Tổ Hợp những số ngắn chữ số hơn N
        for (int i = 1; i < len; i++) {
            // VD 3 chữ số: 9 (vị trí đầu) * 9 * 8 (2 vị trí sau) = 9 * P(9, 2)
            uniqueCount += 9 * perm(9, i - 1);
        }

        // 2. Phép nhặt Số Dài đúng bằng len, có tiền tố chung
        boolean[] seen = new boolean[10];

        for (int i = 0; i < len; i++) {
            int digit = digits.get(i); // Nắm đầu 1 chữ số
            int start = (i == 0) ? 1 : 0; // Vi trí đầu tiên không bao giờ được phép bằng 0

            for (int j = start; j < digit; j++) {
                // Ta có quyền nhặt chữ số j nếu j chưa từng xuất hiện ở tiền tố khóa
                if (!seen[j]) {
                    // Chọn xong 1 chữ số hợp lệ, Số lượng chữ số còn bỏ trống là: len - i - 1
                    // Số lượng chữ số còn để thảy rỗng là: 9 - i
                    uniqueCount += perm(9 - i, len - i - 1);
                }
            }

            // Xử lý nhánh rễ của cây
            if (seen[digit]) {
                // Rễ này đã tự thắt, ngắt đứt tiến trình
                break;
            }
            seen[digit] = true; // Khóa chặt số này để vòng tiền tố sau kiêng cữ
        }

        return n - uniqueCount;
    }

    // Hàm tính Mảnh Hoán vị (Permutation): P(m, k) = m * (m-1) * ... * (m-k+1)
    private int perm(int m, int k) {
        if (k == 0)
            return 1;
        int p = 1;
        for (int i = 0; i < k; i++) {
            p *= (m - i);
        }
        return p;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.numDupDigitsAtMostN(20)); // expected 1
        System.out.println("Result 2: " + sol.numDupDigitsAtMostN(100)); // expected 10
        System.out.println("Result 3: " + sol.numDupDigitsAtMostN(1000)); // expected 262
    }
}
