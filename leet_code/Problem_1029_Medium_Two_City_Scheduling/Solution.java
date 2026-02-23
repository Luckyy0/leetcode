package leet_code.Problem_1029_Medium_Two_City_Scheduling;

import java.util.Arrays;

/**
 * Problem 1029: Two City Scheduling
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class Solution {

    /**
     * Calculates the minimum cost to fly `n` people to city A and `n` people to
     * city B.
     * Strategy: Greedy Sorted by Refund Margin (Cost A - Cost B) (O(N log N) time).
     * 
     * @param costs The 2D array of flight costs for each person to city A and city
     *              B.
     * @return The exact mathematical minimum cost to achieve half-and-half
     *         splitting.
     * 
     *         Tóm tắt chiến lược:
     *         1. Nhiệm vụ: Xẻ đôi $2N$ người. Buộc N đứa sang A, N đứa sang B với
     *         Giá Vé Rẻ nhất.
     *         2. Cách Quy hoạch Động O(N^3) chậm chạp và thừa thãi bộ nhớ, vì đây
     *         hoàn
     *         toàn có thể dùng Đầu óc Cáo Già của Lái Buôn để giải Quyết bằng Thuật
     *         "THAM LAM".
     *         3. TRÒ CHƠI "BỒI HOÀN CHÊNH LỆCH" TỐI ƯU CỰC ĐẠI:
     *         - Giả vờ Công ty phóng túng, BẮT TOÀN BỘ sinh mạng $2N$ người Bay
     *         thẳng
     *         tồn khói xe Về Thành Phố A (cho êm xuôi gọn lẹ, chưa quan tâm luật).
     *         - Lúc này, Luật bắt buộc phải có Phân nửa ($N$) người BỊ ĐÁ SANG
     *         Thành Phố B.
     *         - Ai sẽ bị Đá? Ai phải tình nguyện hi sinh đổi vé Bay B?
     *         - Nếu 1 Thằng phải Bỏ Vé A ($costA$) để Mua Vé B ($costB$), công ty
     *         sẽ Chịu Một Khoản Hao Hụt gọi là ĐỘ LỆCH GIÁ: `Diff = costA - costB`.
     *         + Nếu Khoản Lệch Quá ÂM (VD: Đổi vé mất -990 đô, do Vé A Rẻ thối 10$
     *         mà Vé B Tận 1000$): THẰNG NÀY SỐNG CHẾT PHẢI BAY A KẺO PHÁ SẢN!
     *         + Nếu Khoản Lệch Dương Mập Mạp (VD: Lời 990 đô, do Vé A giá Cắt cổ
     *         1000$
     *         mà Vé B Cực Rẻ 10$): LÒNG THAM THỨC GIẤC, ĐÁ CÚ LỪA NÓ BAY SANG B GẤP
     *         ĐỂ NÉ PHÍ!
     *         4. Hạ Nhát Đao:
     *         - Dùng Mảng `Arrays.sort` băm Vỏ Hành: Thằng có Độ Lệch Bé Âm Khủng
     *         (-990)
     *         nhấn chìm Trôi lên chóp Đầu Mảng Cờ. (Nên Bù lót cho bay A).
     *         Thằng Lệch Mập Dương (+990) bị đạp Trôi Tuột xuống Xó Đáy Mảng. (Bắt
     *         ép bay B).
     *         - Cưa mảng làm đôi. Móc $N$ đứa Xịn Ưu tú đầu mảng Bơm Vé Bay A. Móc
     *         rác
     *         $N$ mống dạt đáy đục Ép cấp Vé Bay B. Kết Toán Giá vốn Tiền!
     */
    public int twoCitySchedCost(int[][] costs) {
        // Nạp Thần Chú Băm Hành Arrays.sort: Cưa nhau xâu xé ăn thua ĐỘ LỆCH VÉ (Cost A
        // - Cost B)
        // Số bé nhọt Âm Thâm Sâu thì rúc Đầu, Số Lớn Dương Ngất Ngưởng đạp Xuống Cặn
        Arrays.sort(costs, (nguoi1, nguoi2) -> {
            int venhHao1 = nguoi1[0] - nguoi1[1];
            int venhHao2 = nguoi2[0] - nguoi2[1];
            return Integer.compare(venhHao1, venhHao2);
        });

        int totalMinCost = 0;
        int halfN = costs.length / 2;

        for (int i = 0; i < halfN; i++) {
            // Nửa Trên mảng: Tuyệt Đỉnh Nhan Sắc (A Siêu Rẻ so với B) -> Cho nó lên Tàu đi
            // A Vén Tưởng
            totalMinCost += costs[i][0];

            // Nửa Cặn bã Dát Đáy dưới (A Cắt Cổ đắt xắt ra miếng với B) -> Hất Hủi Đẩy Gánh
            // Phận Đi B!
            totalMinCost += costs[i + halfN][1];
        }

        return totalMinCost;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] costs1 = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
        System.out.println("Result 1: " + sol.twoCitySchedCost(costs1)); // expected 110

        int[][] costs2 = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
        System.out.println("Result 2: " + sol.twoCitySchedCost(costs2)); // expected 1859

        int[][] costs3 = { { 515, 563 }, { 451, 713 }, { 537, 709 }, { 343, 819 }, { 855, 779 }, { 457, 60 },
                { 650, 359 }, { 631, 42 } };
        System.out.println("Result 3: " + sol.twoCitySchedCost(costs3)); // expected 3086
    }
}
