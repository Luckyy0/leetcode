package leet_code.Problem_956_Hard_Tallest_Billboard;

import java.util.*;

/**
 * Problem 956: Tallest Billboard
 * https://leetcode.com/problems/tallest-billboard/
 */
public class Solution {

    /**
     * Calculates the largest possible height of the billboard.
     * Strategy: Dynamic Programming on Difference.
     * 
     * @param rods Array of rod lengths.
     * @return Max height of one side of the billboard.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán yêu cầu tìm hai tập hợp con có tổng bằng nhau.
     *         2. Đặt `dp[d]` là chiều cao lớn nhất của cột CAO HƠN trong hai cột
     *         khi chênh lệch chiều cao giữa chúng là `d`.
     *         Giả sử hai cột có chiều cao `h1` và `h2` với `h1 >= h2`, thì `d = h1
     *         - h2`.
     *         `dp[d]` sẽ lưu giá trị `h1`. Lúc này `h2 = h1 - d`.
     *         3. Khởi tạo `dp[0] = 0` (hai cột cao 0, chênh lệch 0). Các trạng thái
     *         khác chưa tồn tại.
     *         4. Duyệt qua từng thanh `rod` có độ dài `r`:
     *         Với mỗi trạng thái `(diff, h1)` hiện có trong `dp`:
     *         - Cách 1: Thêm `r` vào cột cao hơn (`h1`).
     *         Chiều cao mới: `h1 + r`. Chênh lệch mới: `diff + r`.
     *         Cập nhật `dp[diff + r]`.
     *         - Cách 2: Thêm `r` vào cột thấp hơn (`h2`).
     *         Chiều cao cột thấp cũ là `h2 = h1 - diff`.
     *         Chiều cao cột thấp mới là `h2 + r`.
     *         Cặp chiều cao mới là `(h1, h2 + r)`.
     *         Chiều cao cột cao hơn mới = `max(h1, h2 + r)`.
     *         Chênh lệch mới = `abs(h1 - (h2 + r))`.
     *         Cập nhật `dp[new_diff]`.
     *         - Cách 3: Không dùng thanh `r` (giữ nguyên trạng thái cũ - đã được
     *         bao gồm trong việc copy `dp`).
     *         5. Kết quả cuối cùng là `dp[0]`, tức là chiều cao lớn nhất khi chênh
     *         lệch bằng 0.
     */
    public int tallestBillboard(int[] rods) {
        // dp stores mapping: difference -> max height of the taller support
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for (int r : rods) {
            // Create a copy of the current DP state to iterate over
            Map<Integer, Integer> cur = new HashMap<>(dp);

            for (Map.Entry<Integer, Integer> entry : cur.entrySet()) {
                int diff = entry.getKey();
                int h1 = entry.getValue(); // Height of taller support
                int h2 = h1 - diff; // Height of shorter support

                // Option 1: Add rod 'r' to the taller support
                // New heights: (h1 + r), h2
                // New diff: (h1 + r) - h2 = diff + r
                // New taller height: h1 + r
                int newDiff1 = diff + r;
                int newH1_1 = h1 + r;
                dp.put(newDiff1, Math.max(dp.getOrDefault(newDiff1, 0), newH1_1));

                // Option 2: Add rod 'r' to the shorter support
                // New heights: h1, (h2 + r)
                // New diff: abs(h1 - (h2 + r))
                // New taller height: max(h1, h2 + r)
                int newDiff2 = Math.abs(h1 - (h2 + r));
                int newH1_2 = Math.max(h1, h2 + r);
                dp.put(newDiff2, Math.max(dp.getOrDefault(newDiff2, 0), newH1_2));
            }
        }

        return dp.getOrDefault(0, 0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] r1 = { 1, 2, 3, 6 };
        System.out.println("Result: " + sol.tallestBillboard(r1)); // 6

        int[] r2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Result: " + sol.tallestBillboard(r2)); // 10

        int[] r3 = { 1, 2 };
        System.out.println("Result: " + sol.tallestBillboard(r3)); // 0
    }
}
