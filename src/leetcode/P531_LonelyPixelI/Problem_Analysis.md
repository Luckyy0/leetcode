# 531. Lonely Pixel I / Điểm Ảnh Cô Đơn I

## Problem Description / Mô tả bài toán
Given an `m x n` `picture` consisting of black `'B'` and white `'W'` pixels, return the number of **black** lonely pixels.
Cho một `picture` kích thước `m x n` bao gồm các pixel đen `'B'` và trắng `'W'`, hãy trả về số lượng pixel đen **cô đơn**.

A black lonely pixel is a character `'B'` that located at a specific position `(r, c)` where:
Một pixel đen cô đơn là một ký tự `'B'` nằm tại vị trí cụ thể `(r, c)` trong đó:

- `picture[r][c] == 'B'`
- The number of black pixels in the row `r` is `1`. / Số lượng pixel đen trong hàng `r` là `1`.
- The number of black pixels in the column `c` is `1`. / Số lượng pixel đen trong cột `c` là `1`.

### Constraints / Ràng buộc
- `m == picture.length`
- `n == picture[i].length`
- `1 <= m, n <= 500`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pre-computation / Tính toán trước
We can count the number of 'B's in each row and each column first.

Algorithm:
1. Initialize `rowCount` and `colCount` arrays.
2. Iterate through the grid to fill counts.
3. Iterate through the grid again:
   - If `picture[i][j] == 'B'` AND `rowCount[i] == 1` AND `colCount[j] == 1`:
     - Increment result.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M + N).

---

## Analysis / Phân tích

### Approach: Two-Pass Counting

**Algorithm**:
1.  Compute row and column frequency of 'B'.
2.  Traverse matrix to check 'B' cells.
3.  Verify isolation conditions using precomputed counts.

---
