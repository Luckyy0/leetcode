package leet_code.Problem_1035_Medium_Uncrossed_Lines;

/**
 * Problem 1035: Uncrossed Lines
 * https://leetcode.com/problems/uncrossed-lines/
 */
public class Solution {

    /**
     * Returns the maximum number of uncrossed lines connecting duplicate numbers.
     * Strategy: Dynamic Programming (Longest Common Subsequence - LCS)
     * 
     * @param nums1 The first integer array.
     * @param nums2 The second integer array.
     * @return The maximum number of uncrossed lines.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Đường Nối Không Giao Cắt - Thật ra là Bóng Ma Của Tượng Đài LCS":
     *         - Bài toán yêu cầu tìm các cặp số trùng nhau (1 ở mảng trên, 1 ở mảng
     *         dưới)
     *         rồi nối chúng lại. NGẶT NỖI: Các dây nối KẺ RA thì TUYỆT ĐỐI KHÔNG
     *         ĐƯỢC ĐÈ CHÉO CÁNH NHAU!
     *         - Tức là nếu bạn đã chọn Nối Thằng Đứng Trước Của Mảng 1 với Thằng
     *         Mảng 2,
     *         thì Về Sau (những thằng Đuôi của Mảng 1) chỉ được phép nối tiếp với
     *         những thằng Đứng Sau Cái Khúc bạn Vừa Xẻ Cắt Thôi! Nó chính là bài
     *         toán
     *         TÌM DÃY CON CHUNG LIÊN TIẾP DÀI NHẤT TRÙNG NHAU (LCS) kinh điển.
     * 
     *         2. Quy Hoạch Bảng Chiến Lược O(M * N) - Bottom Up Đáy Đẩy Lên:
     *         - Dựng một bảng DP 2 chiều `dp[i][j]` dư Lõi `(len1 + 1) x (len2 +
     *         1)`.
     *         - `dp[i][j]` chứa ĐÁP ÁN CAO NHẤT GÓI GỌN Nếu CHỈ Mang Đi cá cược cái
     *         Khúc
     *         Đầu Tới Cọng Thứ `i` Của Mảng 1 VÀ Tới Cọng Thứ `j` Của Mảng 2.
     * 
     *         3. Công Trình Ráp Thợ (Cách Bơm DP):
     *         - TRÚNG MÁNH TIẾNG SÉT ÁI TÌNH: Nếu Đoạn Cuối Ngang Gờ trùng Cốt
     *         (`nums1[i-1] == nums2[j-1]`).
     *         + Cắt băng khánh thành! Kẻ 1 Dây! Ăn Ngay Kỉ Lục Cũ Cắt Đầu (+1):
     *         `dp[i][j] = dp[i - 1][j - 1] + 1;`
     *         - ĐỨT GÁNH KHÔNG TÌNH NGHĨA (Tạch Đồng Khung Số):
     *         + Chịu Tang! Cố Tình Ném bỏ đi 1 Gành Đầu Mút (Bỏ Đỉnh Mảng 1
     *         Hoặc Bỏ Đỉnh Mảng 2), So đo Cú Ráp dp Nào Mập Hơn Từ Thời Ông Nội:
     *         `dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);`
     * 
     *         - Đại Kết Cục Cuối Bản Chóp Ô: Lát Đáy Góc Ruột Ma Trận `dp[m][n]`
     *         Mài Bật Ra Trái!
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Trải Thảm Bạt Ma Trận Kí Vong dp, Ô Số Không Giả Làm Lớp Đệm Khí Không Căng!
        int[][] dp = new int[m + 1][n + 1];

        // Quệt chổi chà Đi 2 vòng For chéo
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Tiếng Chảo Dội Sét (Phát hiện Cặp Song Sinh 2 Khung Song Song Có Giá Trị Khít
                // Nhau)
                if (nums1[i - 1] == nums2[j - 1]) {
                    // Cầu Cáp Nối Lát Xuống Dốc Đáy! Giựt 1 Giải Dây Khang Trang!
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Oái oăm Không Thủng Nhau! Cạo Rứt Ăn Chặn Đòi Đền Bù Đoạn Trống! (Thằng Nào
                    // To Tao Húp)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Trọn ổ rế kết luận Tối Cường
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1_1 = { 1, 4, 2 };
        int[] nums2_1 = { 1, 2, 4 };
        System.out.println("Result 1: " + sol.maxUncrossedLines(nums1_1, nums2_1)); // expected 2

        int[] nums1_2 = { 2, 5, 1, 2, 5 };
        int[] nums2_2 = { 10, 5, 2, 1, 5, 2 };
        System.out.println("Result 2: " + sol.maxUncrossedLines(nums1_2, nums2_2)); // expected 3

        int[] nums1_3 = { 1, 3, 7, 1, 7, 5 };
        int[] nums2_3 = { 1, 9, 2, 5, 1 };
        System.out.println("Result 3: " + sol.maxUncrossedLines(nums1_3, nums2_3)); // expected 2
    }
}
