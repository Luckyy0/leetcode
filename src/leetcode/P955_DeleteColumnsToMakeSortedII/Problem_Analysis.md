# 955. Delete Columns to Make Sorted II / Xóa Cột để làm cho được sắp xếp II

## Problem Description / Mô tả bài toán
Similar to P944, but here we want to delete the minimum number of columns such that the whole strings (formed by the remaining columns) are sorted lexicographically.
Tương tự như P944, nhưng ở đây chúng ta muốn xóa số lượng cột ít nhất sao cho toàn bộ các chuỗi (được tạo bởi các cột còn lại) được sắp xếp theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Tie-breaking State / Tham lam với Trạng thái phá vỡ ràng buộc
We need to know at any point which strings are already "strictly less" than their next neighbors.
Chúng ta cần biết tại bất kỳ thời điểm nào những chuỗi nào đã "nhỏ hơn nghiêm ngặt" so với những người hàng xóm tiếp theo của chúng.

Algorithm:
1. `isSorted[i]` = true if `strs[i]` is already strictly less than `strs[i+1]`.
2. For each column `j`:
   - Check if the column is valid: for all `i`:
     - If `!isSorted[i]` and `strs[i][j] > strs[i+1][j]`, column must be deleted.
   - If column wasn't deleted:
     - Update `isSorted`: if `strs[i][j] < strs[i+1][j]`, set `isSorted[i] = true`.

### Complexity / Độ phức tạp
- **Time**: O(N * L).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Incremental Sorting Verification
Process columns one by one. A column is kept only if it doesn't violate existing alphabetical orders. Once a character in a column definitively establishes the relative order between two adjacent strings, that pair is marked as resolved, freeing future columns from having to maintain their ordering.
Xử lý từng cột một. Một cột chỉ được giữ lại nếu nó không vi phạm các thứ tự bảng chữ cái hiện có. Khi một ký tự trong một cột thiết lập chắc chắn thứ tự tương đối giữa hai chuỗi liền kề, cặp đó được đánh dấu là đã giải quyết, giúp các cột sau này không cần phải duy trì thứ tự cho họ nữa.

---
