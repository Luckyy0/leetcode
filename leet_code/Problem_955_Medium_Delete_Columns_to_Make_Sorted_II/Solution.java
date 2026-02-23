package leet_code.Problem_955_Medium_Delete_Columns_to_Make_Sorted_II;

/**
 * Problem 955: Delete Columns to Make Sorted II
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class Solution {

    /**
     * Finds the minimum deletions required to make rows lexicographically sorted.
     * Strategy: Greedy with State Tracking.
     * 
     * @param strs Array of strings.
     * @return Minimum number of deleted columns.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt qua từng cột từ trái sang phải.
     *         2. Duy trì một mảng trạng thái `sorted` cho các cặp hàng liền kề `(i,
     *         i+1)`.
     *         `sorted[i]` là true nếu `row[i]` đã nhỏ hơn `row[i+1]` dựa trên các
     *         cột ĐÃ GIỮ trước đó.
     *         Nếu `sorted[i]` là true, ta không cần quan tâm đến cột hiện tại cho
     *         cặp này nữa.
     *         3. Với mỗi cột `j`:
     *         - Kiểm tra xem cột này có phá vỡ thứ tự từ điển của bất kỳ cặp hàng
     *         nào chưa được sắp xếp không (`!sorted[i]`).
     *         Điều kiện phá vỡ: `strs[i].charAt(j) > strs[i+1].charAt(j)`.
     *         - Nếu có ít nhất một cặp bị phá vỡ => Cột này BẮT BUỘC phải xóa. Tăng
     *         `deletions` và bỏ qua cột này.
     *         - Nếu không có cặp nào bị phá vỡ => Cột này an toàn để giữ lại.
     *         Sau khi quyết định giữ lại, ta cập nhật trạng thái `sorted`:
     *         Nếu `strs[i].charAt(j) < strs[i+1].charAt(j)`, thì cặp hàng `(i,
     *         i+1)` giờ đây đã được phân biệt rõ ràng,
     *         nên gán `sorted[i] = true`.
     */
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0)
            return 0;

        int n = strs.length;
        int len = strs[0].length();
        // sorted[i] indicates if strs[i] is already lexicographically smaller than
        // strs[i+1]
        // based on previous columns kept.
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        for (int j = 0; j < len; j++) {
            boolean deleteThisCol = false;

            // Phase 1: Check if keeping this column causes unsorted order for any unsorted
            // pair
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    // Violation found in this column for rows i and i+1
                    deleteThisCol = true;
                    // Once decided to delete, no need to check further rows for deletion decision
                    break;
                }
            }

            if (deleteThisCol) {
                // Must delete this column
                deletions++;
            } else {
                // Keep this column, so update the sorted status for all pairs
                for (int i = 0; i < n - 1; i++) {
                    if (!sorted[i] && strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        // This column distinguishes row i and i+1 correctly
                        sorted[i] = true;
                    }
                }
            }
        }

        return deletions;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] s1 = { "ca", "bb", "ac" };
        System.out.println("Result: " + sol.minDeletionSize(s1)); // 1

        String[] s2 = { "xc", "yb", "za" };
        System.out.println("Result: " + sol.minDeletionSize(s2)); // 0

        String[] s3 = { "zyx", "wvu", "tsr" };
        System.out.println("Result: " + sol.minDeletionSize(s3)); // 3
    }
}
