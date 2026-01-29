# 304. Range Sum Query 2D - Immutable / Truy Vấn Tổng Phạm Vi 2D - Bất Biến

## Problem Description / Mô tả bài toán
Given a 2D matrix `matrix`, handle multiple queries of the following type:
- Calculate the **sum** of the elements of `matrix` inside the rectangle defined by its **upper left corner** `(row1, col1)` and **lower right corner** `(row2, col2)`.
Cho một ma trận 2D `matrix`, xử lý nhiều truy vấn thuộc loại sau:
- Tính **tổng** các phần tử của `matrix` bên trong hình chữ nhật được xác định bởi **góc trên bên trái** `(row1, col1)` và **góc dưới bên phải** `(row2, col2)`.

Implement the `NumMatrix` class:
- `NumMatrix(int[][] matrix)` Initializes the object with the integer matrix `matrix`.
- `int sumRegion(int row1, int col1, int row2, int col2)` Returns the sum of the elements of `matrix` inside the rectangle defined by its upper left corner `(row1, col1)` and lower right corner `(row2, col2)`.

### Example 1:
```text
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8
numMatrix.sumRegion(1, 1, 2, 2); // return 11
numMatrix.sumRegion(1, 2, 2, 4); // return 12
```

## Constraints / Ràng buộc
- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 200`
- `-10^5 <= matrix[i][j] <= 10^5`
- `0 <= row1 <= row2 < m`
- `0 <= col1 <= col2 < n`
- At most `10^4` calls will be made to `sumRegion`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### 2D Prefix Sum / Tổng Tiền Tố 2D
Similar to 1D, we precompute a sum matrix `dp`.
`dp[i][j]` = Sum of rectangle from `(0,0)` to `(i-1, j-1)`. (Using 1-based indexing for dp helps avoid boundary checks).
Recurrence to build `dp`:
`dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]` (Principle of Inclusion-Exclusion).

To query sum of rectangle `(r1, c1)` to `(r2, c2)`:
`Sum = dp[r2+1][c2+1] - dp[r1][c2+1] - dp[r2+1][c1] + dp[r1][c1]`.
We subtract the areas above and to the left, and add back the top-left intersection which was subtracted twice.

### Complexity / Độ phức tạp
- **Time**: O(M*N) Initialization, O(1) per Query.
- **Space**: O(M*N) for `dp` table.

---

## Analysis / Phân tích

### Approach: 2D Prefix Sum

**Algorithm**:
1.  Init `dp[m+1][n+1]`.
2.  Fill `dp`: `dp[i][j] = matrix[i-1][j-1] + top + left - diag`.
3.  Query: Only 1 calculation.

---
