# 598. Range Addition II / Cộng Phạm Vi II

## Problem Description / Mô tả bài toán
You are given an `m x n` matrix `M` initialized with all `0`'s and an array of operations `ops`, where `ops[i] = [ai, bi]` means `M[x][y]` should be incremented by one for all `0 <= x < ai` and `0 <= y < bi`.
Bạn được cho một ma trận `m x n` `M` được khởi tạo với tất cả các số `0` và một mảng các thao tác `ops`, trong đó `ops[i] = [ai, bi]` có nghĩa là `M[x][y]` nên được tăng thêm một cho tất cả `0 <= x < ai` và `0 <= y < bi`.

Count and return the number of maximum integers in the matrix after performing all the operations.
Đếm và trả về số lượng số nguyên tối đa trong ma trận sau khi thực hiện tất cả các thao tác.

### Example 1:
```text
Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: M becomes:
[[2,2,1],
 [2,2,1],
 [1,1,1]]
The max int is 2, and there are 4 of them.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Intersection of Rectangles / Giao Của Các Hình Chữ Nhật
Each operation increments a rectangle from `(0,0)` to `(ai-1, bi-1)`.
The cell with the maximum value will be the one that is covered by the **most** operations.
Since all operations start at `(0,0)`, the maximum value is always at `(0,0)` and extends to the intersection of all operation rectangles.
The intersection is a rectangle from `(0,0)` to `(min_a - 1, min_b - 1)`.
The number of such cells is `min_a * min_b`.

Algorithm:
1. Initialize `min_row = m`, `min_col = n`.
2. Iterate through ops:
   - `min_row = Math.min(min_row, op[0])`
   - `min_col = Math.min(min_col, op[1])`
3. Return `min_row * min_col`.

### Complexity / Độ phức tạp
- **Time**: O(K) where K is number of ops.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Logic Deduction (Intersection)

**Algorithm**:
1.  Find the minimum row range `a`.
2.  Find the minimum col range `b`.
3.  The area `a * b` contains the max values.

---
