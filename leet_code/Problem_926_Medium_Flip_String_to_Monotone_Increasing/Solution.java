package leet_code.Problem_926_Medium_Flip_String_to_Monotone_Increasing;

/**
 * Problem 926: Flip String to Monotone Increasing
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */
public class Solution {

    /**
     * Calculates the minimum flips to make the string monotone increasing.
     * Strategy: Dynamic Programming / Greedy.
     * 
     * @param s Input binary string.
     * @return Minimum flips.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt qua chuỗi từ trái sang phải.
     *         2. Sử dụng hai biến:
     *         - `count1`: Số lượng số '1' đã gặp cho đến thời điểm hiện tại.
     *         (Đây cũng là chi phí nếu ta quyết định lật TẤT CẢ các số '1' này
     *         thành '0' để giữ chuỗi toàn '0').
     *         - `flips`: Số lần lật tối thiểu để phần tiền tố đã duyệt trở nên đơn
     *         điệu tăng.
     *         3. Khi gặp ký tự '1':
     *         - Ta chỉ cần tăng `count1`. `flips` không đổi vì thêm một số '1' vào
     *         cuối một chuỗi
     *         đã đơn điệu tăng vẫn giữ nguyên tính đơn điệu.
     *         4. Khi gặp ký tự '0':
     *         - Ta có hai lựa chọn để duy trì tính đơn điệu:
     *         a) Lật số '0' này thành '1'. Chi phí tăng thêm 1 (`flips + 1`).
     *         (Giả sử ta giữ nguyên các lựa chọn tối ưu trước đó).
     *         b) Giữ số '0' này là '0'. Điều này bắt buộc TẤT CẢ các số phía trước
     *         phải là '0'.
     *         Chi phí cho lựa chọn này chính là `count1` (lật tất cả các số '1'
     *         trước đó thành '0').
     *         - Ta cập nhật `flips = min(flips + 1, count1)`.
     */
    public int minFlipsMonoIncr(String s) {
        int count1 = 0;
        int flips = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count1++;
            } else {
                // If current is '0', we can:
                // 1. Flip this '0' to '1' -> cost becomes flips + 1
                // 2. Flip all previous '1's to '0's -> cost becomes count1
                // Take the minimum cost
                flips = Math.min(flips + 1, count1);
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.minFlipsMonoIncr("00110")); // 1
        System.out.println("Result: " + sol.minFlipsMonoIncr("010110")); // 2
        System.out.println("Result: " + sol.minFlipsMonoIncr("00011000")); // 2
    }
}
