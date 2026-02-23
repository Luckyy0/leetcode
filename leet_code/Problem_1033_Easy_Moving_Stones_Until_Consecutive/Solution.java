package leet_code.Problem_1033_Easy_Moving_Stones_Until_Consecutive;

import java.util.Arrays;

/**
 * Problem 1033: Moving Stones Until Consecutive
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 */
public class Solution {

    /**
     * Determines the minimum and maximum number of moves to make 3 stones
     * consecutive.
     * Strategy: Optimal Mathematical Logical Deduction (O(1) time).
     * 
     * @param a The position of the first stone.
     * @param b The position of the second stone.
     * @param c The position of the third stone.
     * @return An array of length 2 containing [min_moves, max_moves].
     * 
     *         Tóm tắt chiến lược:
     *         1. "Ép 3 cục đá Về Rọ Liên Ngang Cạnh Nhau": Dù nó nằm rải rác cách
     *         nhau
     *         mấy chục ngàn dặm trên trục toạ độ, Trò chơi chỉ dừng lại khi 3 mống
     *         Tụ lại Khít Khịt (Ví dụ: [4, 5, 6]).
     *         2. Bài toán BẮT BUỘC TRẢ VỀ:
     *         - MIN_MOVES: Số bước Căng Não Giải Cứu NHANH NHẤT (ít bước nhất).
     *         - MAX_MOVES: Số bước Ngu Ngơ Đi Lòng Vòng Chậm Chạp (nhiều bước
     *         nhất).
     * 
     *         3. Cách Giải Cực Trị Bằng Não Khỉ Đột Toán Học O(1):
     *         - Đem 3 thông số Gốc đôn thóp Lên Bàn Cân Sắp Xếp Trật Tự Tự Nhiên:
     *         `x < y < z`.
     *         - TRUY TÌM SỐ BƯỚC MAX DÂY DƯA (max_moves):
     *         Lòng đất Rỗng (khoảng trống lọt khe) giữa X và Z là bao trùm toàn bộ
     *         sự Cù Nhây!
     *         Thằng Y đã Ngáng đường ở Giữa ăn cắp 1 Slot. Nên Bãi Đất Trống Bao La
     *         Tận Cùng
     *         LÀ CÔNG THỨC: `(z - y - 1) + (y - x - 1) = z - x - 2`.
     *         => Đây chính xác là Số Bước Max Ném Từng Ô Một Rù Rì Cho Tới Sát
     *         Nhau.
     * 
     *         - TRUY TÌM CÚ CẮN MIN SIÊU TỐC (min_moves):
     *         + NẾU Khít Khịt Sẵn Ráp Từ Bẩm Sinh: `z - x == 2` -> Mừng Rớt Nước
     *         Mắt, 0 BƯỚC.
     *         + NẾU Hở Trúng 1 Khe Hở Tuyệt Đối Giữa `X với Y` hoặc `Y với Z`:
     *         (Ví dụ Khe `[1, 3] _> Nhét móng tay Vô giữa Bụng Rốn 2 Thằng` là `y -
     *         x == 2`).
     *         Ta nhấc Cục còn lại Vút Lép Xéo Rụng Mẹ Xuống Lỗ Kim Chọi Đứt Ruột
     *         Khít Ngang 0!
     *         -> Tuyệt Phẩm Cứu Cánh 1 BƯỚC DUY NHẤT.
     *         + CÒN LẠI NGOÀI RA: (Ví dụ 1, 10, 20 xa lắc cùi chỏ).
     *         Luôn luôn có thể Nhúp Cục Z bay Cái Rụp Lót ổ Giáp Lưng Thằng Y (Phía
     *         Cánh Phải).
     *         Và Nhúp Tương Nhát Xẹt Cục X nhét cắm Trạm Thu Phí Giáp Vế Chống
     *         (Phía Cánh Trái).
     *         -> Luật Định Sinh Tồn Rọ Đá MAX Luôn Là 2 BƯỚC CHẤM CHẾT BÀN!
     */
    public int[] numMovesStones(int a, int b, int c) {
        // Gom bi nhét bát vào đôn Quỹ sắp xếp trật tự Vị Danh Tông Môn `x < y < z`
        int[] stones = { a, b, c };
        Arrays.sort(stones);
        int x = stones[0];
        int y = stones[1];
        int z = stones[2];

        // Hố Khổng Lồ Tận Cùng Cho Sự Dây Dưa Nát Game (z - x - 2)
        int max_moves = z - x - 2;

        int min_moves = 2; // Bậc Thềm Cuối Cùng Rách Lưới Trời cũng Ép Buộc Xong Ngay Nấc 2 Nhát Cắm

        // Trúng Số Độc Đắc Móng Dính Bụng Nhau (Tức Z Mút Đầu rớt Đít X Vỏn Vẹn Khác
        // Phân Nhau 2 Xải Tay)
        if (z - x == 2) {
            min_moves = 0; // Nghỉ Chơi Rinh Cúp
        }
        // Khe Sắt Thở Thiếu Gió Nhập Răng Lọt Đúng Cọng Tóc 1 Bước (Cách Nhau 2)
        else if (y - x <= 2 || z - y <= 2) {
            // VD 1, 3, 7: Nhúp 7 ném Rơi Vô Mão số 2 Ngay Trái Cữa Lầu thằng (3). Ép 1, 2,
            // 3 Nát Bét Xong Bàn 1 Bước!
            min_moves = 1;
        }

        return new int[] { min_moves, max_moves };
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] res1 = sol.numMovesStones(1, 2, 5);
        System.out.println("Result 1: [" + res1[0] + ", " + res1[1] + "]"); // expected [1, 2]

        int[] res2 = sol.numMovesStones(4, 3, 2);
        System.out.println("Result 2: [" + res2[0] + ", " + res2[1] + "]"); // expected [0, 0]

        int[] res3 = sol.numMovesStones(3, 5, 1);
        System.out.println("Result 3: [" + res3[0] + ", " + res3[1] + "]"); // expected [1, 2]

        int[] res4 = sol.numMovesStones(1, 3, 7);
        System.out.println("Result 4: [" + res4[0] + ", " + res4[1] + "]"); // expected [1, 4]
    }
}
