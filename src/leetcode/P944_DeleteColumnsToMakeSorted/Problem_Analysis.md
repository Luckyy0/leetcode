# 944. Delete Columns to Make Sorted / Xóa Cột để làm cho được sắp xếp

## Problem Description / Mô tả bài toán
You are given an array of `n` strings `strs`, all of the same length. We want to delete the minimum number of columns such that every remaining column is **sorted** lexicographically.
Bạn được cho một mảng gồm `n` chuỗi `strs`, tất cả đều có cùng độ dài. Chúng ta muốn xóa số lượng cột ít nhất sao cho mỗi cột còn lại đều được **sắp xếp** theo thứ tự từ điển.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Column Scan / Quét cột Tham lam
Since columns are independent, we just need to check if each column satisfies the condition.
Vì các cột độc lập với nhau, chúng ta chỉ cần kiểm tra xem mỗi cột có thỏa mãn điều kiện hay không.

Algorithm:
1. For each column index `j`:
   - Iterate through strings `i` from 1 to `n-1`.
   - If `strs[i].charAt(j) < strs[i-1].charAt(j)`, the column is NOT sorted.
   - Increment `deleteCount` and move to the next column.

### Complexity / Độ phức tạp
- **Time**: O(N * L) where L is string length.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Independent Column Validation
The decision to delete a column is local and doesn't affect other columns. By iterating through each vertical slice of the character grid, we can identify and count those that violate the upward lexicographical trend.
Quyết định xóa một cột mang tính cục bộ và không ảnh hưởng đến các cột khác. Bằng cách lặp qua từng lát cắt dọc của lưới ký tự, chúng ta có thể xác định và đếm những cột vi phạm xu hướng từ điển tăng dần.

---
