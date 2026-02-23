package leet_code.Problem_1010_Medium_Pairs_of_Songs_With_Total_Durations_Divisible_by_60;

/**
 * Problem 1010: Pairs of Songs With Total Durations Divisible by 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
public class Solution {

    /**
     * Calculates the number of pairs of songs that have a duration sum divisible by
     * 60.
     * Strategy: Optimal Frequency Array.
     * 
     * @param time The array of song durations.
     * @return The number of valid pairs.
     * 
     *         Tóm tắt chiến lược:
     *         1. Mục tiêu bài toán hoàn toàn xoay quanh tính toán phần dư của 60.
     *         Vì vậy `time[i]` hay `time[j]` không quan trọng bằng
     *         `time[i] % 60` và `time[j] % 60`.
     *         2. Hai bài hát gộp lại chia hết cho 60 khi tổng phần dư của chúng
     *         chia
     *         hết cho 60. Nếu ta biết một bài có dư `r = t % 60`, bài bổ khuyết để
     *         tạo ra cặp hoàn hảo phải có số dư là `(60 - r) % 60`.
     *         - Ghi chú `(60 - r) % 60` sẽ xử lý đẹp cả trường hợp bài r=0
     *         (bài chẵn vòng), nó sẽ tìm bài chẵn vòng khác: (60-0)%60 = 0.
     *         3. Cách ngây thơ nhất là lồng 2 vòng lặp (O(N^2)) tìm từng cặp thì
     *         sập
     *         server do giới hạn 6 * 10^4.
     *         4. Thay vào đó, ta thiết lập 1 mảng Mảng Tần Suất (Frequency Array)
     *         dài 60 ô chứa số đếm. (Giống kiểu quy tắc Hộp và Bi).
     *         5. Vừa đi vừa đếm: Gặp 1 bài hát, tự dóng sang ô `(60-r)%60` xem có
     *         bao bài hát sẵn sàng ghép đôi, vơ trọn cộng dồn vào `count`.
     *         6. Sau đó, ném cái `r` của thân mình vào ô chứa Tần Suất
     *         `remainders[r]++`
     *         để làm nguyên liệu cho bài hát khác.
     *         7. Tuyệt chiêu vơ-đếm-xếp-hàng O(N) hoàn mỹ.
     */
    public int numPairsDivisibleBy60(int[] time) {
        // Tủ đồ lưu 60 loại số dư khác nhau
        int[] remainders = new int[60];
        int count = 0;

        for (int t : time) {
            int r = t % 60;

            // Tìm "mảnh ghép còn thiếu" của mình (thủ thuật Modulo khép kín vòng tròn)
            int complement = (60 - r) % 60;

            // Nếu tủ đồ có mảnh ghép, lấy tất cả cộng vào kho điểm
            count += remainders[complement];

            // Ghi danh chính mình vào tủ để sau này đứa khác còn dùng ghép
            remainders[r]++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] time1 = { 30, 20, 150, 100, 40 };
        System.out.println("Result 1: " + sol.numPairsDivisibleBy60(time1)); // expected 3

        int[] time2 = { 60, 60, 60 };
        System.out.println("Result 2: " + sol.numPairsDivisibleBy60(time2)); // expected 3
    }
}
