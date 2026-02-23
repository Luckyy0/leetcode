package leet_code.Problem_1037_Easy_Valid_Boomerang;

/**
 * Problem 1037: Valid Boomerang
 * https://leetcode.com/problems/valid-boomerang/
 */
public class Solution {

    /**
     * Checks if the 3 points form a valid boomerang (not collinear).
     * Strategy: Cross-Product Area Deduction (O(1) time).
     * 
     * @param points An array of 3 points where points[i] = [xi, yi].
     * @return true if the points form a valid boomerang, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Boomerang Gãy Góc - Cốt Tủy Thẳng Hàng":
     *         - Gồm 3 điểm nằm cách biệt, nếu chúng ta phóng bút nối 3 điểm mà
     *         chúng
     *         Nằm bẹp dí trên Cùng 1 Đường Thẳng -> Vứt xó (Biến thành cây Đũa
     *         thẳng
     *         rồi, lấy gì Phi về Boomerang?).
     *         - Tóm lại: Bài toán trắc nghiệm xem 3 ĐIỂM CÓ THẲNG HÀNG HAY KHÔNG.
     *         Nếu
     *         không thẳng hàng tức là tạo thành Tam giác cong vút -> Trả về TRUE.
     * 
     *         2. "Luật Tính Diện Tích Tam Giác Cross-Product Trừ Khử Số Thực":
     *         - Công thức toán học sơ cấp tính Hệ số góc k = (y2 - y1) / (x2 - x1).
     *         Nếu Hệ số Góc Đường AB = Hệ số góc Đường AC -> Tức là Tụi nó Cắm
     *         chung OXY -> False.
     *         Nhưng NHƯỢC ĐIỂM CỘT TỬ là Dính Phép Chia (Sợ x2 - x1 = 0, chia Cho 0
     *         nát bét Báo Lỗi Máy Tính).
     *         - PHÁ BỎ BỆNH CHIA: Ép thành NHÂN CHÉO OXY (Cross Product Không Gian
     *         2D Vector):
     *         Giả sử Vector Lưỡi Cưa AB = (x2 - x1, y2 - y1)
     *         Vector Lưỡi Cưa AC = (x3 - x1, y3 - y1)
     *         Lấy Tréo: Cành X của AB nhân cành Y của AC ---> TRỪ đi <--- Cành Y
     *         của AB nhân cành X của AC.
     *         => Nếu Kết quả = 0 : Diện tích bị đè bẹp dí -> Thẳng Hàng -> False.
     *         => Lót Lỗ Khác 0 : Tam Giác Bụng Bầu Răng Rắc Nở Ngực Ra -> Boomerang
     *         Hoàn Hảo -> True!
     */
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        // Mài Gươm Đâm Chéo Bụng Diện Tích (Phép Nhân Hóa Cốt Kỉ Tiệt Nhiên Triệt Để
        // Nạn Chia Float 0 Nát CPU)
        int crossProductArea = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);

        // Ẵm Cục Chóp Bụng (Nếu bụng rỗng tuếch = 0 Tức Boomerang xẹp lép, Nếu Bầu To
        // != 0 LÀ CHUẨN XỊN TAM GIÁC)
        return crossProductArea != 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points1 = { { 1, 1 }, { 2, 3 }, { 3, 2 } };
        System.out.println("Result 1: " + sol.isBoomerang(points1)); // expected true

        int[][] points2 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println("Result 2: " + sol.isBoomerang(points2)); // expected false

        int[][] points3 = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
        System.out.println("Result 3: " + sol.isBoomerang(points3)); // expected false (All same points)

        int[][] points4 = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println("Result 4: " + sol.isBoomerang(points4)); // expected false (Collinear on X axis)
    }
}
