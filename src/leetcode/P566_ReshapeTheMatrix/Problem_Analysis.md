# 566. Reshape the Matrix / Định Hình Lại Ma Trận

## Problem Description / Mô tả bài toán
In MATLAB, there is a handy function called `reshape` which can reshape an `m x n` matrix into a new one with a different size `r x c` keeping its original data.
Trong MATLAB, có một hàm tiện dụng gọi là `reshape` có thể định hình lại một ma trận `m x n` thành một ma trận mới có kích thước khác `r x c` trong khi vẫn giữ nguyên dữ liệu gốc.

You are given an `m x n` matrix `mat` and two integers `r` and `c` representing the number of rows and the number of columns of the wanted reshaped matrix.
Bạn được cho một ma trận `m x n` `mat` và hai số nguyên `r` và `c` đại diện cho số hàng và số cột của ma trận được định hình lại mong muốn.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
Ma trận được định hình lại nên được điền với tất cả các phần tử của ma trận gốc theo cùng thứ tự duyệt hàng như cũ.

If the `reshape` operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
Nếu thao tác `reshape` với các tham số đã cho là khả thi và hợp lệ, hãy xuất ma trận được định hình lại mới; Ngược lại, hãy xuất ma trận gốc.

### Example 1:
```text
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Coordinate Transformation / Chuyển Đổi Tọa Độ
Total elements must match: `m * n == r * c`. If not, return original.
Mapping from 1D index `k` (0 to `m*n - 1`):
- Original: `mat[k / n][k % n]`
- New: `res[k / c][k % c]`

Algorithm:
1. Check if `m * n == r * c`. If not, return `mat`.
2. Create `res[r][c]`.
3. Use a loop `k` from 0 to `total - 1`, or nested loops with a counter.
   - `res[i][j] = mat[row][col]`.
   - Update indices.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) for the new matrix.

---

## Analysis / Phân tích

### Approach: Linear Mapping

**Algorithm**:
1.  Verify dimension compatibility (`r*c == m*n`).
2.  Iterate through source matrix elements linearly.
3.  Fill target matrix row by row.

---
