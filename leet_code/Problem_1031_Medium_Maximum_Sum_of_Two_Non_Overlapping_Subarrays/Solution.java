package leet_code.Problem_1031_Medium_Maximum_Sum_of_Two_Non_Overlapping_Subarrays;

/**
 * Problem 1031: Maximum Sum of Two Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class Solution {

    /**
     * Finds the maximum sum of two non-overlapping subarrays of lengths firstLen
     * and secondLen.
     * Strategy: Optimal Sliding Dual Windows with Left Max History Log (O(N) time).
     * 
     * @param nums      The array of integers.
     * @param firstLen  The required length of the first subarray.
     * @param secondLen The required length of the second subarray.
     * @return The maximum combined sum.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Móc Ruột Non Hai Khối": Có một mảng bự, bạn phải gắp ra 2 khúc
     *         ruột
     *         không được lấn vạch nhau (rạch ròi L1 và L2), sao cho TỔNG 2 khúc là
     *         To nhất.
     *         - Lưu ý sinh tử cực hóc môn: Việc "Khúc L1 nằm bên trái Khúc L2" hay
     *         ngược
     *         lại "Khúc L2 đứng đằng trước che Khúc L1" ĐỀU HỢP LỆ! Hệ phương trình
     *         vật lý
     *         cần được thử nghiệm ĐẢO NGƯỢC 2 CA ĐỘC LẬP Tách Biệt!
     *         2. Cách Gà Cờ Chóp (Naive): Chạy Prefix Sum (Mảng Cộng Dồn). Gắn 2
     *         For chạy
     *         lăn tăn L1, xong rồi L2 chạy tà tà theo sau nó. O(N^2) Tốn não cồng
     *         kềnh.
     *         3. Cách Hoàng Kim Chóp Vô Địch - Thuật Hai Ô Cửa Sổ Trượt Bám Màng
     *         Lịch Sử O(N):
     *         - Xét CA ĐỘC LẬP: Mảng L đứng trước che đầu mảng M.
     *         - Khi Mảng Rắn `M` Trượt Lọt Xoáy Lên 1 Nấc Sang Cánh Đuôi Phía Tay
     *         Phải.
     *         - Tự Mảnh Rắn `L` Cánh Tay Trái Cũng Rướn Lên 1 Nấc Lên Bờ Ngực.
     *         - BÍ QUYẾT TÍNH ĐIỂM: Khúc `L` Cánh Trái Lết tới đâu, ta KIỂM TOÁN VÀ
     *         LƯU VÔ SỔ
     *         CHUYÊN TRÁCH CÁI KỶ LỤC TỐT NHẤT CỦA CÁC ĐỜI CHÚ `L` CŨ! (`maxL`).
     *         Khúc `M` thì
     *         chỉ cần rúc mũi tính Hiện Tại Thực Tiễn nó ăn được Mấy điểm Chóp
     *         `sumM`.
     *         - Cuối cùng Ụp Cặp Ghép Khối: `Kỷ Lục Cũ MaxL + Cái Tảng Măng Hiện
     *         Tại sumM` ->
     *         Tuyệt Phẩm Global Chóp Mới Tanh!
     *         - Làm Hàm Lặp O(N) Một Chạm chạy 1 cái rột nát tan Chuỗi. Rồi tái
     *         kích hoạt
     *         Đảo Chiều L, M => M, L. Bốc Chóp Cân Nhau Hoàn Hảo. Không Rác Bộ Nhớ
     *         Mảng O(1)!
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // Áp Triệt Pháp Ép Kép Đảo Chiều
        return Math.max(
                findMaxSlidingWindowOffset(nums, firstLen, secondLen),
                findMaxSlidingWindowOffset(nums, secondLen, firstLen));
    }

    // Độc Đạo O(N): Cuộc chơi Trượt Cửa Sổ L (Đứng Trái) vs Cửa Sổ M (Hứng Cánh
    // Phải Đít)
    private int findMaxSlidingWindowOffset(int[] nums, int L, int M) {
        int n = nums.length;

        // Cụm đầu Cột L: Ép Vú Nuôi Rắn L Lớn Chờ Thời (Từ 0 đến L)
        int sumL = 0;
        for (int i = 0; i < L; i++) {
            sumL += nums[i];
        }
        int maxL = sumL; // Tích lũy Lịch sử Tinh Hoa Giao Kiếm Cánh Trái

        // Đong Quãng M ngậm nọc nối ngay Rìa đít Thằng L Cũ
        int sumM = 0;
        for (int i = L; i < L + M; i++) {
            sumM += nums[i];
        }

        // Mở Màn Vinh Quang: Dốc Túi Hiện Tại của Đôi Trẻ Thơ
        int globalMax = maxL + sumM;

        // Xả Dốc Cần Máy Máy Trượt (Vắt Mũi Khâu Sợi Chỉ tới Đáy Mảng Chót)
        for (int i = L + M; i < n; i++) {
            // Sợi trái (L) Bò Cạp rướn tới 1 mốc. Bốc Móc Đầu Chặn Mới (i - M), rỗng túi
            // Nứt Gãy Rỉ Đuôi Cũ Cặn Bã (i - M - L)
            sumL += nums[i - M] - nums[i - M - L];

            // Xó Sổ Báo Danh: Bắp Cải Nảy Mầm Vinh Quang của Dãy L TỪ TRƯỚC TỚI GIỜ LÀ GÌ?
            maxL = Math.max(maxL, sumL);

            // Dòng Biển Khơi Phải (M) Lê Lết Nước Lự, Nghênh rước Giọt Hiện Tại (i) Vứt Dấu
            // Giọt Xưa Ngàm Nứt Cứt (i - M)
            sumM += nums[i] - nums[i - M];

            // Chập Gộp Thành Quả Chắn Kín 2 Rìa Cắt Đứt
            globalMax = Math.max(globalMax, maxL + sumM);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 0, 6, 5, 2, 2, 5, 1, 9, 4 };
        System.out.println("Result 1: " + sol.maxSumTwoNoOverlap(nums1, 1, 2)); // expected 20 (9 + 6+5)

        int[] nums2 = { 3, 8, 1, 3, 2, 1, 8, 9, 0 };
        System.out.println("Result 2: " + sol.maxSumTwoNoOverlap(nums2, 3, 2)); // expected 29 (3+8+1 + 8+9)

        int[] nums3 = { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 };
        System.out.println("Result 3: " + sol.maxSumTwoNoOverlap(nums3, 4, 3)); // expected 31 (5+6+0+9 + 3+8+0 ?)
    }
}
