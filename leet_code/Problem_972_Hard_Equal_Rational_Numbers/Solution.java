package leet_code.Problem_972_Hard_Equal_Rational_Numbers;

import java.util.*;

/**
 * Problem 972: Equal Rational Numbers
 * https://leetcode.com/problems/equal-rational-numbers/
 */
public class Solution {

    /**
     * Determines if two rational number strings are equal.
     * Strategy: String Expansion to Double.
     * 
     * @param s First number string.
     * @param t Second number string.
     * @return true if equal within tolerance.
     * 
     *         Tóm tắt chiến lược:
     *         1. Số hữu tỉ lặp lại trong bài toán này có kích thước phần lặp lại
     *         nhỏ (tối đa 4).
     *         2. Ta có thể xấp xỉ giá trị của số này bằng cách mở rộng phần lặp lại
     *         ra đủ dài (khoảng 20 chữ số thập phân)
     *         và chuyển thành kiểu `double`.
     *         3. Kiểu `double` có độ chính xác khoảng 15-17 chữ số thập phân.
     *         Với độ dài này, sự khác biệt giữa các chuỗi lặp lại như `0.(9)` và
     *         `1.` sẽ trở nên rất nhỏ (xét về mặt toán học 0.(9) = 1).
     *         Ví dụ: `0.9999999999999999` sẽ được làm tròn thành `1.0` hoặc rất gần
     *         với `1.0`.
     *         4. Các bước cụ thể:
     *         - Tìm vị trí dấu ngoặc `(`.
     *         - Nếu không có dấu ngoặc, đơn giản parse chuỗi thành `double`.
     *         - Nếu có, tách phần cơ sở (`base`) và phần lặp lại (`rep`).
     *         - Nối `rep` vào `base` liên tục cho đến khi chuỗi đủ dài (khoảng 20
     *         ký tự).
     *         - Parse chuỗi kết quả thành `double`.
     *         5. So sánh giá trị tuyệt đối của hai số `double` tìm được. Nếu nhỏ
     *         hơn `1e-9` (hoặc ngưỡng an toàn tương đương), coi như bằng nhau.
     */
    public boolean isRationalEqual(String s, String t) {
        return Math.abs(convertToDouble(s) - convertToDouble(t)) < 1e-9;
    }

    private double convertToDouble(String s) {
        int i = s.indexOf('(');
        if (i != -1) {
            String base = s.substring(0, i);
            String rep = s.substring(i + 1, s.length() - 1);

            // StringBuilder to construct the expanded number string
            StringBuilder sb = new StringBuilder(base);

            // Repeat the repeating part until we have enough precision (~20 chars total)
            // 20 is sufficient for standard double precision
            while (sb.length() < 20) {
                sb.append(rep);
            }

            // Parse the expanded string into a double
            // Note: If repeating part makes number effectively finite but repeats 0 (e.g.
            // 1.2(0)), standard double parsing works fine.
            return Double.parseDouble(sb.toString());
        }

        // No repeating part
        return Double.parseDouble(s);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.isRationalEqual("0.(52)", "0.5(25)")); // true
        System.out.println("Result: " + sol.isRationalEqual("0.1666(6)", "0.166(66)")); // true
        System.out.println("Result: " + sol.isRationalEqual("0.9(9)", "1.")); // true
    }
}
