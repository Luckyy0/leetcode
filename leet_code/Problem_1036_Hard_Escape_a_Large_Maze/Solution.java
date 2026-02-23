package leet_code.Problem_1036_Hard_Escape_a_Large_Maze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Problem 1036: Escape a Large Maze
 * https://leetcode.com/problems/escape-a-large-maze/
 */
public class Solution {

    // Nắp Chặn Biển Địa Ngục Lưới Lớn (1 Triệu)
    private static final int MAX_BOUNDARY = 1000000;

    // Mánh Khóe "Vòng Kim Cô Mở Rộng 20,000" Bơm Oxi Dập Giải Khát
    private static final int MAX_STEPS = 20000;

    /**
     * Determines whether it's possible to escape the blocked maze and reach target.
     * Strategy: Bi-Directional Bounded BFS (Maximum Area Enclosure Theorem).
     * 
     * @param blocked The array of blocked cells.
     * @param source  The starting coordinates [sr, sc].
     * @param target  The destination coordinates [tr, tc].
     * @return true if escape is possible, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Khổng Lồ $1 Triệu x 1 Triệu$ - Nỗi Khiếp TLE/MLE":
     *         - Nếu bạn rúc đầu vào húc BFS loang lỗ mò đường nguyên bản, bạn sẽ bị
     *         Ngộp Thở mà chết bởi Màn đêm 1 Triệu x 1 Triệu. Tràn Bộ Nhớ Siêu To!!
     * 
     *         2. "Cú Lừa Rùng Rợn Nghịch Lý Blocked Cells":
     *         - Mày có 1 Triệu dặm đất, mà Tụi Nó (Mảng Blocked) chỉ được thả Kịch
     *         kim Toàn
     *         mạng vỏn vẹn Dưới 200 Viên Đá!!
     *         - Chơi Xếp Hình Quây Đá Chặn Kiểu Gì Khốn Nạn Nhất Để Bít Đường Mày?
     *         => Hãy dàn 200 viên đá Thụt Lùi Tựa Lưng Vào Góc Tường Cụt (Tạo Hàng
     *         Rào
     *         Cắt Góc Khuất Tam Giác Bầu Phẳng).
     *         => Hệ Phương Trình Toán Siêu Khí: Diện tích Số Ô Cực Cắn Cụt tối đa
     *         mà
     *         200 viên đá quây thắt được Cổ mày là = `200 * 199 / 2 = 19,900` Lỗ
     *         Trống!
     * 
     *         3. "Bẻ Cổ O(N) Xoáy Giáp Tường Bằng Dây Hãm Quét (20,000 Bước)":
     *         - NỘI CÔNG TÂM PHÁP: Nếu Cục Đầu Source Bùng Nổ Loang Vết BFS (Càng
     *         quét)
     *         rút trúng nhích Vượt Quá 20.000 Bước Mà Nó Nào Có Hết Đường Cụt Lề.
     *         Tức Là NÓ ĐÃ THOÁT RA BIỂN LỚN MÊNH MÔNG TỈ Ô RỒI! BỌN 200 ĐÁ ÉO Giam
     *         Nổi Mày Chút Nào Nữa!
     *         - LƯU Ý GAI DI ĐỘNG: Lỡ thằng Đích (Target) Bị Nhốt Ếch Trong Ly Khác
     *         Thì Răng?
     *         => Đánh 2 Đầu Đuôi Đối Lưu: Kiểm Tra Cả `Source Chạy Ra Target` LẪN
     *         `Target
     *         Chạy Ngược Ra Source`. Bùng Vượt Xa 20.000 Cả 2 Đứa Thằng LÀ Thắng
     *         Bàn (True).
     *         - Dùng Đúc Hash (R x 1Triệu + C) thay Vì Sờ Mảng Tỉ Chiều Tốn RAM Mù
     *         Quáng Nát Gáo!
     */
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(hash(b[0], b[1]));
        }

        // Kẹp Cuống Họng Từ Hai Cực Phân Chia! Ép Bụng Tách Cánh
        return bfsCheckBounded(source, target, blockedSet) && bfsCheckBounded(target, source, blockedSet);
    }

    private boolean bfsCheckBounded(int[] start, int[] end, Set<Long> blockedSet) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(hash(start[0], start[1])); // Trị Nứt Da Bỏ Mã Lỗi Trùng

        long endHash = hash(end[0], end[1]);
        int steps = 0; // Nghệ Thuật Kéo Cột Chốt Đồng Hồ Phanh

        // Cần Gạt Đẩy Rã Băng Bốn Góc Mũi Tên: Lên, Xuống, Trái, Bờ Phải
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // Xủi Nghẽo? Sương Mù Mở Lói Thấy Đứa Nó Yêu! Đội Mồ Sống Khít (Trúng Đích Bất
            // Ngờ)
            if (current[0] == end[0] && current[1] == end[1]) {
                return true;
            }

            steps++;
            // BÃO TRÀN BỌC ÁO! Nước Chảy Bò Ra Tới 20.000 Đứa Con Trai Mở Mắt! Biển Chờ Ta
            // Dạng Rộng!
            if (steps > MAX_STEPS) {
                return true;
            }

            for (int[] dir : directions) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];

                // Mắc Vấp Thành Vách Triệu Trùng Tường Bản Đồ Rõ Dậy
                if (r >= 0 && r < MAX_BOUNDARY && c >= 0 && c < MAX_BOUNDARY) {
                    long currentHash = hash(r, c);
                    // Rớt Ném Bóng: Không Bị Mìn Nổ Tử Và Khác Miễn Chết Xưa Cũ Đã Lướt Qua
                    if (!blockedSet.contains(currentHash) && !visited.contains(currentHash)) {
                        visited.add(currentHash);
                        queue.offer(new int[] { r, c });
                    }
                }
            }
        }

        // Buốt Giá Rùng Rợn! Vét cạn róc khô Chưa Đầy 20,000 Oxi Mà Đã Bóp Cỏ Cứt Nước
        // Lọt Lỗ! MẶC KẸT!! Lồng Bẫy Oan Nghiệt!
        return false;
    }

    // Biển Ảo ID Đúc Rễ: Row * $1 Lố Triệu$ + Column -> Tuyệt Đối Unique Mã Vạch
    // Lõi Dẹp Gãy String "r,c" rác Ram Tái Sinh Cùi Chỏ
    private long hash(int r, int c) {
        return (long) r * MAX_BOUNDARY + c;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] blocked1 = { { 0, 1 }, { 1, 0 } };
        int[] source1 = { 0, 0 };
        int[] target1 = { 0, 2 };
        System.out.println("Result 1: " + sol.isEscapePossible(blocked1, source1, target1)); // expected false

        int[][] blocked2 = {};
        int[] source2 = { 0, 0 };
        int[] target2 = { 999999, 999999 };
        System.out.println("Result 2: " + sol.isEscapePossible(blocked2, source2, target2)); // expected true
    }
}
