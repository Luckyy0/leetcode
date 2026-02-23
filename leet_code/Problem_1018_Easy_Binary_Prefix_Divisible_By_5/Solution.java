package leet_code.Problem_1018_Easy_Binary_Prefix_Divisible_By_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1018: Binary Prefix Divisible By 5
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 */
public class Solution {

    /**
     * Checks if the binary prefixes are divisible by 5.
     * Strategy: Modulo Arithmetic Tracking without storing large values.
     * 
     * @param nums The array of binary digits.
     * @return A list of booleans indicating divisibility by 5.
     * 
     *         Tóm tắt chiến lược:
     *         1. Có Lỗi Chết Trệt (Fatal Flaw) ở cách giải thông thường:
     *         Mảng bit này dài tận 100 Ngàn (10^5) ký tự. Nếu mình ráng cố công
     *         nhồi
     *         hết mấy số này vào biến Long 64-bit, lúc dịch qua tới vòng thứ 64 nó
     *         sẽ bể tung nóc nhà gây lỗi Tràn Bộ Nhớ Số (Integer Overflow).
     *         - Dùng BigInteger để dắt bò 100 ngàn lần x2 thì thảm hoạ máy tính,
     *         tốc độ rùa bò sẽ dính lỗi TLE.
     *         2. Điểm lóe sáng toán học: Ta chửi thề vào giá trị Bự Chà Bá kia.
     *         - Số To (M) = 5 * K + R (Trong đó R là Số Dư).
     *         - Do vậy (Số To * 2) = 10 * K + 2*R. Phần 10K hiển nhiên chia hết cho
     *         5,
     *         suy ra 10K là đồ bỏ!
     *         - Ta chỉ móc ráp duy nhất phần (2*R) mà thôi!
     *         3. Công thức Thần Đồng được chốt: Dư_Mới = (Dư_Cũ * 2 + Bit) mod 5.
     *         4. Thay vì ôm nguyên mảng to, biến Số Dư `remainder` của ta chỉ luẩn
     *         quẩn
     *         từ 0 đến 4! Bóp dẹp cơn hoảng loạn của Ram (Tránh Tràn số 100%).
     *         5. Vừa lặp, vừa dịch bit `(remainder << 1)` thay cho phép `* 2` sẽ
     *         vọt
     *         hiệu suất lên nóc. Xét `remainder == 0` để tóm `true` cho answer.
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        // Cấp phát kích thước sẵn để ArrayList không phải "trở mình" cấp phát động nữa
        List<Boolean> answer = new ArrayList<>(nums.length);

        // Móc khóa Số dư tí hon
        int remainder = 0;

        for (int bit : nums) {
            // (remainder << 1) là nhẩm remainder * 2, tốc độ phần cứng
            remainder = ((remainder << 1) + bit) % 5;

            // Chia gọt xong dư 0 là qua cửa!
            if (remainder == 0) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 0, 1, 1 };
        System.out.println("Result 1: " + sol.prefixesDivBy5(nums1)); // expected [true,false,false]

        int[] nums2 = { 1, 1, 1 };
        System.out.println("Result 2: " + sol.prefixesDivBy5(nums2)); // expected [false,false,false]
    }
}
