package leet_code.Problem_1024_Medium_Video_Stitching;

/**
 * Problem 1024: Video Stitching
 * https://leetcode.com/problems/video-stitching/
 */
public class Solution {

    /**
     * Finds the minimum number of clips needed to cover [0, time].
     * Strategy: Greedy Interval Jumps (similar to Jump Game II).
     * 
     * @param clips The array of available video clips.
     * @param time  The target duration to cover.
     * @return The minimum number of clips, or -1 if impossible.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Che phủ một khoảng thời gian bằng ít đoạn phim nhất có thể".
     *         Bài này nếu giải bằng Quy Hoạch Động (DP) O(N*Time) thì vẫn qua
     *         do rào cản N nhỏ, nhưng cách giải tham lam "Cóc Nhảy" (Greedy Jump)
     *         mới là đẳng cấp thời đại O(N + Time).
     *         2. Chuyển đổi Khái niệm Lắp ghép = Trò Chơi Ếch Nhảy Cóc:
     *         - Gói gọn mục tiêu: Làm sao để con ếch nhảy từ Cột Mốc 0 đến
     *         Cột Mốc `time` với Số lần Nhảy là ÍT NHẤT.
     *         - Nước đi Siêu Cấp: Ở MỖI BƯỚC CHÂN TỪ 0 ĐẾN `time`, ta phải luôn
     *         chọn cuộn phim nào vắt sải cánh DÀI NHẤT VỀ PHÍA BÊN PHẢI.
     *         3. Cách Thiết lập Mạng Lưới Nhảy Cóc:
     *         - Có 100 Cuộn phim hỗn độn. Đi lọc Cặn bã: Lập một mảng `maxJump`.
     *         Tại cột mốc Start thứ `X`, nếu có 3 Cuộn phim cùng vạch xuất phát tại
     *         `X`,
     *         thì ta MẶC XÁC 2 cuộn phim cùi bắp, CHỈ GHI NHẬN LƯU VÀO ĐẦU Cuộn
     *         Phim
     *         Có chiều dài Đuôi Kết Thúc KHỦNG BỐ NHẤT! Khát máu vứt rác dài yếu
     *         kém.
     *         4. Chiến Lược Nhảy:
     *         - Duy trì "Tầm Nhìn Xa Nhất" (`farthest`) mà ta có thể Lụm được của
     *         Các Cuộn Phim nằm trong tay áo.
     *         - Duy trì "Biên Giới Chính Thức" (`currentEnd`) là ranh giới thực MÁU
     *         THỊT của cuộn phim Cầm Trịch hiện tại.
     *         - Đi lướt dọc từ 0 đến `time`.
     *         -> Hễ vấp trúng một Tầm Nhìn `maxJump` nào ngon, cập nhật Nhãn quan
     *         `farthest` Dài hơn!
     *         -> Lúc bước chân đạp mòn lết tới bờ vực "Biên Giới Chính Thức"
     *         (`currentEnd`),
     *         Buộc Lòng PHẢI TIÊU TỐN 1 MẠNG VÀ CẮT 1 CUỘN PHIM RÁP LÊN ĐỂ ĐI TẾP!
     *         Khắc cốt ghi tâm: Cuộn Phim được Ráp chắp đó CHÍNH LÀ cuộn phim sở
     *         hữu cái
     *         Thị Lực Tinh Anh Nhất `farthest` mà nãy giờ mình lụm được ghim trong
     *         đầu!
     *         Ráp nó vô, dời Biên Giới Chính Thức lên mốc `farthest`.
     *         -> Trớ trêu Kỹ thuật Ngã Lầu chết: Chưa Cắt được cuộn phim nào vắt
     *         qua nổi Vực
     *         mà Chân đã đạp đúng bờ vực hụt (Tức là mốc vị trí chôn chân `i ==
     *         farthest`).
     *         Tuyệt Nọc, sập hầm, thiếu cảnh trả -1.
     */
    public int videoStitching(int[][] clips, int time) {
        // Mảng Trinh Sát: Từ tọa độ `X`, chảo Đuôi Xa Nhất Của Cuộn Phim Xuất Phát tại
        // đây là bao nhiêu?
        int[] maxJump = new int[time + 1];

        // Lọc rác: Tích tụ Độ Sải Chân Dài nhất cho mọi điểm Start
        for (int[] clip : clips) {
            int start = clip[0];
            int end = clip[1];
            // Không quan tâm Cuộn Phim vớt xuất phát tít ngoài ranh giới Mục tiêu
            if (start <= time) {
                maxJump[start] = Math.max(maxJump[start], end);
            }
        }

        int jumpsCount = 0; // Giá Máu: Số Cuộn Phim phải cúng
        int currentEnd = 0; // Mốc Thắng Cảnh Chính Thức Cứng
        int farthest = 0; // Sải Cánh Mộng Mơ Cuộn Dự Bị

        // Đếm lùi dòng đời, dừng khựng trước Mốc `time` (Vì tới đó là xong Game k cần
        // Nhảy Thêm)
        for (int i = 0; i < time; i++) {

            // Xăm xoi Cuộn Át Chủ Bài Ngâm Tiêu Điểm: Ai có Sải Dài hơn?
            farthest = Math.max(farthest, maxJump[i]);

            // Tai Ách Mù Đường: Đứng ngay cái đỉnh Cuộn Xịn Nhất rồi mà còn đéo dài nổi
            // nách đi tiếp! -> THIẾU PHIM.
            if (i == farthest) {
                return -1;
            }

            // Gãy Mép Phim: Mòn Gót rồi Thưa Đại Vương, RÚT CUỘN XỊN NHẤT PHỦ LÊN LÓT ĐƯỜNG
            // ĐI TIẾP!
            if (i == currentEnd) {
                jumpsCount++; // Trả phí bóc phim mới
                currentEnd = farthest; // Nới Tường Gạch ra đỉnh
            }
        }

        return jumpsCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] clips1 = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
        System.out.println("Result 1: " + sol.videoStitching(clips1, 10)); // expected 3

        int[][] clips2 = { { 0, 1 }, { 1, 2 } };
        System.out.println("Result 2: " + sol.videoStitching(clips2, 5)); // expected -1

        int[][] clips3 = {
                { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 },
                { 4, 7 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 }
        };
        System.out.println("Result 3: " + sol.videoStitching(clips3, 9)); // expected 3
    }
}
