# 308. Range Sum Query 2D - Mutable / Truy Vấn Tổng Phạm Vi 2D - Có Thể Thay Đổi

## Problem Description / Mô tả bài toán
Design a 2D data structure to optimally handle the following two types of operations:
1.  **Update**: Update the value of a cell in the matrix.
2.  **Calculate Sum**: Calculate the sum of the elements inside a rectangle defined by its upper left corner `(row1, col1)` and lower right corner `(row2, col2)`.

Implement the `NumMatrix` class:
- `NumMatrix(int[][] matrix)` Initializes the object with the integer matrix `matrix`.
- `void update(int row, int col, int val)` Updates the value of `matrix[row][col]` to be `val`.
- `int sumRegion(int row1, int col1, int row2, int col2)` Returns the sum of the elements of `matrix` inside the rectangle defined by its upper left corner `(row1, col1)` and lower right corner `(row2, col2)`.

### Example 1:
```text
Input
["NumMatrix", "sumRegion", "update", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [3, 2, 2], [2, 1, 4, 3]]
Output
[null, 8, null, 10]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8
numMatrix.update(3, 2, 2);       // matrix[3][2] = 2
numMatrix.sumRegion(2, 1, 4, 3); // return 10
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 200`
- `-10^5 <= matrix[i][j] <= 10^5`
- `0 <= row < m`, `0 <= col < n`, `-10^5 <= val <= 10^5`
- `0 <= row1 <= row2 < m`, `0 <= col1 <= col2 < n`
- At most `10^4` calls will be made to `sumRegion` and `update`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### 2D Binary Indexed Tree / Cây Chỉ Số Nhị Phân 2D
Similar to 1D BIT, but with nested loops.
- `bit[i][j]` stores sum of a rectangular region.
- `update(row, col, delta)`:
  - `i = row+1`.
  - `while i <= m`:
    - `j = col+1`.
    - `while j <= n`:
      - `bit[i][j] += delta`
      - `j += j & -j`
    - `i += i & -i`

- `query(row, col)` (Sum from (0,0) to (row, col)):
  - `sum = 0`.
  - `i = row+1`.
  - `while i > 0`:
    - `j = col+1`.
    - `while j > 0`:
      - `sum += bit[i][j]`
      - `j -= j & -j`
    - `i -= i & -i`
  - `return sum`.

- `sumRegion(r1, c1, r2, c2)`:
  - `query(r2, c2) - query(r1-1, c2) - query(r2, c1-1) + query(r1-1, c1-1)`.

### Complexity / Độ phức tạp
- **Time**: O(log M * log N) per update/query. Init: O(MN log M log N).
- **Space**: O(MN).

---

## Analysis / Phân tích

### Approach: 2D BIT

**Algorithm**:
1.  Initialize `bit[m+1][n+1]`.
2.  Store original `matrix` to calculate delta for updates.
3.  Perform updates for initialization (or build in-place if careful).

---
