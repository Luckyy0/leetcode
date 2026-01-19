# 240. Search a 2D Matrix II / Tìm Kiếm trong Ma Trận 2D II

## Problem Description / Mô tả bài toán
Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix `matrix`. This matrix has the following properties:
Viết một thuật toán hiệu quả để tìm kiếm giá trị `target` trong ma trận số nguyên `m x n`. Ma trận này có các thuộc tính sau:

- Integers in each row are sorted in ascending from left to right.
- Các số nguyên trong mỗi hàng được sắp xếp tăng dần từ trái sang phải.
- Integers in each column are sorted in ascending from top to bottom.
- Các số nguyên trong mỗi cột được sắp xếp tăng dần từ trên xuống dưới.

### Example 1:
```text
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
```

### Example 2:
```text
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= n, m <= 300`
- `-10^9 <= matrix[i][j] <= 10^9`
- All the integers in each row are **sorted** in ascending order.
- All the integers in each column are **sorted** in ascending order.
- `-10^9 <= target <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Staircase Search (Search from Top-Right or Bottom-Left) / Tìm kiếm Bậc Thang
We can visualize the search space reduction.
Start at the **Top-Right** corner `(0, n-1)`.
Let current element be `x`.

1.  If `x == target`: Found. Return `true`.
2.  If `x > target`:
    - Since the column is sorted, everything below `x` is also greater than `x`, which is greater than `target`.
    - So, the `target` cannot be in the current column.
    - Move **Left** (`col--`).
3.  If `x < target`:
    - Since the row is sorted, everything to the left of `x` is also smaller than `x`, which is smaller than `target`.
    - So, the `target` cannot be in the current row.
    - Move **Down** (`row++`).

Repeat until found or out of bounds.

(Alternatively, start at Bottom-Left corner: If `x > target` go Up, if `x < target` go Right).

### Complexity / Độ phức tạp
- **Time**: O(M + N) - In each step we eliminate either a row or a column. Max steps = M + N.
- **Space**: O(1) - Constant extra space.

---

## Analysis / Phân tích

### Approach: Top-Right Linear Search

**Algorithm**:
1.  Initialize `row = 0`, `col = n - 1`.
2.  While `row < m` and `col >= 0`:
    - `val = matrix[row][col]`.
    - If `val == target`: return `true`.
    - If `val > target`: `col--` (Eliminate column).
    - Else `val < target`: `row++` (Eliminate row).
3.  Return `false`.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Matrix**: Handle `null` or empty `[]`.
2.  **Target smaller/larger than any element**: Loop terminates quickly.
3.  **1x1 Matrix**: Loop runs once.
