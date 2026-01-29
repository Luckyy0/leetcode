# 1476. Subrectangle Queries / Truy vấn Hình chữ nhật Con

## Problem Description / Mô tả bài toán
Class `SubrectangleQueries`.
- `updateSubrectangle(row1, col1, row2, col2, newValue)`: Set all cells in rect to `newValue`.
- `getValue(row, col)`: Return value at `(row, col)`.
Constraints: 500 ops. Matrix 100x100.
Optimized for frequent specific value queries? Or frequent updates? "There will be at most 500 operations".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### History Log vs Brute Force Update
Since ops are small (500) and matrix is small (100x100).
Brute Force Update: Iterate and update matrix. Max cost $500 \times 100 \times 100 = 5 \times 10^6$. Perfectly fine.
Smart Approach (if matrix huge but queries few): Store updates in a list `(r1, c1, r2, c2, val)`.
`getValue` iterates updates from newest to oldest. If `(row, col)` inside update rect, return val.
This is O(1) update and O(K) query (K ops).
Given constraints, history method is O(1) update and O(K) get. Matrix method is O(M*N) update and O(1) get.
Since 500 ops, history method is extremely fast.

### Complexity / Độ phức tạp
- **Time**: Update O(1), Get O(K).
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Update Log (History)
Store updates in a List.
`getValue`: Check updates in reverse order. Return first match.
Default to initial matrix value.
Lưu trữ cập nhật trong danh sách.
`getValue`: Kiểm tra cập nhật theo thứ tự ngược lại. Trả về kết quả khớp đầu tiên.
Mặc định là giá trị ma trận ban đầu.

---
