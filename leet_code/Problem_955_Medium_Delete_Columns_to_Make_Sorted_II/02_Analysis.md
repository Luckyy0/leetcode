# Analysis for Delete Columns to Make Sorted II
# *Phân tích cho bài toán Xóa Cột để Thực hiện Sắp xếp II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find minimum deletions so rows are lexicographically sorted.
*Tìm số lượng cột xóa ít nhất để các hàng được sắp xếp theo thứ tự từ điển.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Similar to problem 944, but here sorting depends on previous columns.
- We process columns from left to right.
- Maintain a state for each adjacent pair of rows `(i, i+1)`. Is `row[i] < row[i+1]` already satisfied by previous columns?
- Let `sorted[i]` be true if `row[i] < row[i+1]` based on kept columns so far.
- For current column `j`:
  - Check if keeping this column violates order for any pair `(i, i+1)` where `!sorted[i]`.
  - Violation condition: `!sorted[i]` AND `strs[i][j] > strs[i+1][j]`.
  - If violation exists: Delete this column (increment answer). Do not update `sorted`.
  - If no violation: Keep this column. Update `sorted[i]` for all `i`.
    - If `strs[i][j] < strs[i+1][j]`, then `sorted[i]` becomes true.
- Greedy works because we process left to right. A column that sorts rows now is valuable. A column that breaks order must be deleted.
*Xử lý từng cột. Duy trì trạng thái `sorted` cho các cặp hàng liền kề. Nếu cột hiện tại gây vi phạm thứ tự cho cặp chưa sắp xếp -> Xóa. Nếu không -> Giữ và cập nhật trạng thái `sorted`.*

---

## 2. Strategy: Greedy with State Array
## *2. Chiến lược: Tham lam với Mảng Trạng thái*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `sorted` boolean array of size `N-1`. All false initially. `deletions = 0`.
    *   **Khởi tạo:** Mảng `sorted`.*

2.  **Iterate Columns:** `j` from 0 to `L-1`.
    *   **Duyệt Cột:** `j` từ 0 đến `L-1`.*

3.  **Check Column:**
    - Iterate `i` from 0 to `N-2`.
    - If `!sorted[i]` and `strs[i][j] > strs[i+1][j]`:
      - Kept column creates bad order. Must delete.
      - `deletions++`.
      - `delete_this_col = true`. Break loop.
    *   **Kiểm tra:** Nếu vi phạm -> xóa.*

4.  **Update State:**
    - If `!delete_this_col`:
      - Iterate `i` from 0 to `N-2` again.
      - If `strs[i][j] < strs[i+1][j]`: `sorted[i] = true`.
    *   **Cập nhật:** Nếu giữ cột, cập nhật `sorted`.*

5.  **Return:** `deletions`.
    *   **Trả về:** `deletions`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        boolean[] sorted = new boolean[n - 1]; // sorted[i] means row i < row i+1
        int deletions = 0;
        
        for (int j = 0; j < len; j++) {
            boolean deleteThisCol = false;
            
            // Check if keeping this column causes unsorted order
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    deleteThisCol = true;
                    deletions++;
                    break;
                }
            }
            
            // If we keep this column, update the sorted state
            if (!deleteThisCol) {
                for (int i = 0; i < n - 1; i++) {
                    if (strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        sorted[i] = true;
                    }
                }
            }
        }
        
        return deletions;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$.
    *   **Độ phức tạp thời gian:** $O(N \cdot L)$.*
*   **Space Complexity:** $O(N)$ for `sorted` array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Greedy approach column by column, maintaining "already sorted" state for row pairs, is optimal.
*Cách tiếp cận tham lam theo từng cột, duy trì trạng thái "đã sắp xếp" cho các cặp hàng, là tối ưu.*
