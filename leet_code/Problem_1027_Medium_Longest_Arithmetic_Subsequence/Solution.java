package leet_code.Problem_1027_Medium_Longest_Arithmetic_Subsequence;

/**
 * Problem 1027: Longest Arithmetic Subsequence
 * https://leetcode.com/problems/longest-arithmetic-subsequence/
 */
public class Solution {

    /**
     * Finds the length of the longest arithmetic subsequence in given array.
     * Strategy: Optimal Dynamic Programming with Gap Offset mapping.
     * 
     * @param nums The integer array.
     * @return The length of the longest arithmetic subsequence.
     * 
     *         Tóm tắt chiến lược:
     *         1. Chuỗi (Subsequence) khác với Dãy con liền kề (Subarray).
     *         Subsequence
     *         nghĩa là gắp từng phần tử rải rác nhưng không được xáo trộn thứ tự
     *         ban đầu.
     *         2. Cách Ngây Thơ (Naive): Ép cố định 2 con chữ đầu tiên (tạo ra
     *         Khoảng
     *         Cách Bước Công Sai Diệu Kỳ `d`). Sau đó chạy vòng lặp thứ 3 lùng sục
     *         cái
     *         mảng đuôi bên phải xem có Bắt dính được nấc thứ 3, thứ 4... theo Bước
     *         Nhảy
     *         đó không. Độ Phức Tạp 3 vòng lồng O(N^3) -> Nát bép (TLE) giới hạn
     *         mảng 1000.
     *         3. Cách Vô Địch (Dynamic Programming - Quy Hoạch Động O(N^2)):
     *         - Tưởng tượng mình đứng ở Điểm Cuối `i`. Mình nhìn giật lùi về từng
     *         cái
     *         Gốc Rễ `j` nằm bên trái mình.
     *         - Gốc Rễ `j` nói: Ê, Nãy có thằng nào nhảy tới tao bằng Bước Nhảy `X`
     *         ko?
     *         - Ta tính thử: Nhịp Bước `diff = nums[i] - nums[j]`.
     *         Trùng hợp quá! Cặp `i` và `j` Mới Đẻ lại tạo ra Bước Nhảy y chang
     *         `diff`.
     *         - Vậy thì NGAM MỌNG lôi cái Móc Câu đính sẵn ở `j`, Gắn thằng `i` làm
     *         Khoang
     *         Tàu mới cho Đoàn Tàu kéo dài ra!
     *         => CÔNG THỨC: dp[i][diff] = dp[j][diff] + 1 (Khoang tàu `i` nối
     *         nghiệp `j`).
     *         4. Điểm Chết Hóc Xương: Nhịp Bước `diff` CÓ THỂ MANG SỐ ÂM (ví dụ
     *         nhảy lùi).
     *         Mảng Vật Lý 2D trong Java KỊ MẶT Cột Bảng mang CHỈ SỐ ÂM!
     *         - Làm Phép Thâu Tóm Vũ Trụ: Mảng quy định `0 <= nums[i] <= 500`. Vậy
     *         Bước
     *         Nhảy Bể Nát Lùi Sâu Nhất có thể sinh ra là `-500`.
     *         - Gán áo giáp `OFFSET = +500` vào Nhịp Bước: Tức là `diff + 500`.
     *         Giờ Mảng Vật Lý tự tin ôm cột Bảng dương từ `0` đến `1000` hoàn mỹ,
     *         chạy DP!
     */
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;

        // Bảng Động DP (DP Table): dp[Chỉ_Danh_Cuốc_Tàu_i][Độ_Rộng_Bậc_Thang_Cố_Định]
        // Vì Độ Rộng d trải dải [-500, 500], Mặc giáp bù Offset 500 đẩy nó vào dải
        // Dương [0, 1000]
        int[][] dp = new int[n][1001];

        // Mặc định cứ nhặt Bừa 2 hạt Gạo là đút túi chiều dài bằng 2, nên Kỷ Lục Ít
        // Nhất 2!
        int maxLength = 2;

        for (int i = 0; i < n; i++) {
            // Nhìn Đau Đáu Về Phía Các Cụ Tổ Tiên bên Trái (j)
            for (int j = 0; j < i; j++) {

                // Móc đo Khoảng Cách "Cống Sai" giữa i và j (j là điểm đứng cũ)
                int diff = nums[i] - nums[j];

                // Đóng Áo GIÁP Né Lỗi Mảng mốc Chỉ số Âm (-)
                int diffOffset = diff + 500;

                // Nếu cụ Tổ Tiên j trước đó đã Dọn Sẵn 1 Đoàn Tàu nối nghiệp nhịp bước
                // `diffOffset` này:
                if (dp[j][diffOffset] > 0) {
                    // Móc Khoang `i` nối vào Đuôi
                    dp[i][diffOffset] = dp[j][diffOffset] + 1;
                } else {
                    // Cụ Tổ Tiên j hoàn toàn chưa có Tàu Cũ nào, Hai Ta
                    // i và j Tự Dựa Lưng Nhau Khởi Nghiệp Lập Chuỗi Khởi Nguồn, Vốn = 2 khoang.
                    dp[i][diffOffset] = 2;
                }

                // Chết Ấn Ghi Danh Kỷ Lục Đứt Ruột Khủng Nhất Toàn Mảng
                maxLength = Math.max(maxLength, dp[i][diffOffset]);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 3, 6, 9, 12 };
        System.out.println("Result 1: " + sol.longestArithSeqLength(nums1)); // expected 4

        int[] nums2 = { 9, 4, 7, 2, 10 };
        System.out.println("Result 2: " + sol.longestArithSeqLength(nums2)); // expected 3 (4, 7, 10)

        int[] nums3 = { 20, 1, 15, 3, 10, 5, 8 };
        System.out.println("Result 3: " + sol.longestArithSeqLength(nums3)); // expected 4 (20, 15, 10, 5)
    }
}
