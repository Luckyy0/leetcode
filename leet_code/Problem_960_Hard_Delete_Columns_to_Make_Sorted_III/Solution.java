package leet_code.Problem_960_Hard_Delete_Columns_to_Make_Sorted_III;

import java.util.Arrays;

/**
 * Problem 960: Delete Columns to Make Sorted III
 * https://leetcode.com/problems/delete-columns-to-make-sorted-iii/
 */
public class Solution {

    /**
     * Calculates the minimum number of deleted columns so that every row is
     * lexicographically sorted.
     * Strategy: Longest Increasing Subsequence (LIS) Variation.
     * 
     * @param strs Array of strings.
     * @return Minimum number of deletions.
     * 
     *         Tóm tắt chiến lược:
     *         1. Bài toán yêu cầu xoá ít nhất số cột sao cho MỖI dòng đều có thứ tự
     *         tăng dần.
     *         Điều này tương đương với việc tìm tập hợp con các cột lớn nhất
     *         (Longest Subsequence of Columns)
     *         sao cho các cột này tạo thành thứ tự không giảm trên TẤT CẢ các dòng.
     *         2. Gọi `dp[i]` là độ dài dãy con tăng dài nhất CỦA CÁC CỘT kết thúc
     *         tại cột `i`.
     *         3. Khởi tạo `dp` với giá trị 1 (mỗi cột tự nó là một dãy con độ dài
     *         1).
     *         4. Duyệt `i` từ 0 đến `len - 1` (cột hiện tại).
     *         Duyệt `j` từ 0 đến `i - 1` (cột trước đó).
     *         5. Kiểm tra xem cột `j` có thể đứng trước cột `i` trong dãy con tăng
     *         hay không.
     *         Điều kiện là: Với mọi dòng `k`, `strs[k].charAt(j) <=
     *         strs[k].charAt(i)`.
     *         Nếu điều kiện thỏa mãn cho mọi dòng, nghĩa là ta có thể nối cột `i`
     *         vào sau dãy con kết thúc tại `j`.
     *         Cập nhật `dp[i] = max(dp[i], dp[j] + 1)`.
     *         6. Kết quả bài toán là: (Tổng số cột) - (Độ dài dãy con tăng dài nhất
     *         tìm được).
     */
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        // Iterate through each column as the potential end of an increasing subsequence
        for (int i = 0; i < cols; i++) {
            // Check all previous columns to extend the subsequence
            for (int j = 0; j < i; j++) {
                boolean valid = true;

                // Check if column j <= column i for ALL rows
                for (int k = 0; k < rows; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return cols - maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] s1 = { "babca", "bbazb" };
        System.out.println("Result: " + sol.minDeletionSize(s1)); // 3

        String[] s2 = { "edcba" };
        System.out.println("Result: " + sol.minDeletionSize(s2)); // 4

        String[] s3 = { "ghi", "def", "abc" };
        System.out.println("Result: " + sol.minDeletionSize(s3)); // 0
    }
}
