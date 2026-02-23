package leet_code.Problem_940_Hard_Distinct_Subsequences_II;

import java.util.Arrays;

/**
 * Problem 940: Distinct Subsequences II
 * https://leetcode.com/problems/distinct-subsequences-ii/
 */
public class Solution {

    /**
     * Counts the number of distinct subsequences of s.
     * Strategy: Dynamic Programming.
     * 
     * @param s Input string.
     * @return Number of distinct subsequences modulo 10^9 + 7.
     * 
     *         Tóm tắt chiến lược:
     *         1. Ta sử dụng mảng `last[26]` để lưu số lượng chuỗi con riêng biệt
     *         kết thúc bằng mỗi ký tự từ 'a' đến 'z'.
     *         2. Khi duyệt qua một ký tự `c` trong chuỗi `s`:
     *         - Số lượng chuỗi con mới CÓ THỂ tạo ra bằng cách thêm `c` vào sau TẤT
     *         CẢ các chuỗi con hiện có.
     *         - Cộng thêm chính ký tự `c` đứng một mình.
     *         - Do đó, số lượng chuỗi con kết thúc bằng `c` mới sẽ là `(Tổng số
     *         chuỗi con hiện tại) + 1`.
     *         3. Điểm quan trọng: Việc cập nhật `last[c - 'a']` này sẽ ghi đè lên
     *         giá trị cũ.
     *         Điều này tự động xử lý vấn đề trùng lặp. Ví dụ: nếu trước đó đã có
     *         các chuỗi con kết thúc bằng 'a',
     *         thì bây giờ ta thay thế chúng bằng tập hợp chuỗi con mới kết thúc
     *         bằng 'a' (bao gồm cả những chuỗi cũ + 'a').
     *         Thực tế, `last[c]` mới đại diện cho TẤT CẢ chuỗi con kết thúc bằng
     *         `c` tính đến thời điểm này.
     *         4. Cuối cùng, tổng tất cả các giá trị trong `last` là kết quả.
     */
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;

        // last[i] stores the count of distinct subsequences ending with the i-th
        // character ('a' -> 0, etc.)
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            long total = 0;
            // Calculate sum of all distinct subsequences found so far
            for (long count : last) {
                total = (total + count) % MOD;
            }

            // The new count of subsequences ending with 'c' is (Total + 1)
            // +1 accounts for the subsequence "c" itself
            last[c - 'a'] = (total + 1) % MOD;
        }

        // Sum up counts for all ending characters
        long result = 0;
        for (long count : last) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.distinctSubseqII("abc")); // 7 ("a", "b", "c", "ab", "ac", "bc", "abc")
        System.out.println("Result: " + sol.distinctSubseqII("aba")); // 6 ("a", "b", "ab", "aa", "ba", "aba")
        System.out.println("Result: " + sol.distinctSubseqII("aaa")); // 3 ("a", "aa", "aaa")
    }
}
