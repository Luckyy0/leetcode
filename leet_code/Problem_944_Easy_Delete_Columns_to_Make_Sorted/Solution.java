package leet_code.Problem_944_Easy_Delete_Columns_to_Make_Sorted;

/**
 * Problem 944: Delete Columns to Make Sorted
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */
public class Solution {

    /**
     * Counts the number of columns to delete to make each column sorted
     * lexicographically.
     * Strategy: Column-wise Scan.
     * 
     * @param strs Array of strings.
     * @return Number of deleted columns.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt qua từng chỉ số cột (từ 0 đến độ dài chuỗi - 1).
     *         2. Với mỗi cột, duyệt qua từng hàng (từ 0 đến n - 2) để kiểm tra tính
     *         chất sắp xếp.
     *         3. Nếu tìm thấy bất kỳ hàng `r` nào mà `strs[r].charAt(c) > strs[r +
     *         1].charAt(c)`,
     *         có nghĩa là cột `c` không được sắp xếp tăng dần theo thứ tự từ điển.
     *         -> Tăng biến đếm `deleteCount` và chuyển sang kiểm tra cột tiếp theo
     *         (break vòng lặp inner).
     *         4. Trả về tổng số cột không được sắp xếp.
     */
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int numRows = strs.length;
        int numCols = strs[0].length();
        int deleteCount = 0;

        // Iterate through each column
        for (int c = 0; c < numCols; c++) {
            // Check if column is sorted by iterating through rows
            for (int r = 0; r < numRows - 1; r++) {
                // Determine if the column is NOT sorted
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    deleteCount++;
                    break; // Move to the next column
                }
            }
        }

        return deleteCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] strs1 = { "cba", "daf", "ghi" };
        System.out.println("Result: " + sol.minDeletionSize(strs1)); // 1

        String[] strs2 = { "a", "b" };
        System.out.println("Result: " + sol.minDeletionSize(strs2)); // 0

        String[] strs3 = { "zyx", "wvu", "tsr" };
        System.out.println("Result: " + sol.minDeletionSize(strs3)); // 3
    }
}
