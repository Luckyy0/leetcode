# 533. Lonely Pixel II / Điểm Ảnh Cô Đơn II

## Problem Description / Mô tả bài toán
Given an `m x n` picture consisting of black `'B'` and white `'W'` pixels, and an integer target `N`, return the number of black lonely pixels.
Cho một bức tranh `m x n` bao gồm các pixel đen `'B'` và trắng `'W'`, và một số nguyên mục tiêu `N`, hãy trả về số lượng pixel đen cô đơn.

A black lonely pixel is a character `'B'` that located at a specific position `(r, c)` where:
Một pixel đen cô đơn là một ký tự `'B'` nằm tại vị trí cụ thể `(r, c)` trong đó:

1. `picture[r][c] == 'B'`
2. The number of black pixels in the row `r` is `N`. / Số lượng pixel đen trong hàng `r` là `N`.
3. The number of black pixels in the column `c` is `N`. / Số lượng pixel đen trong cột `c` là `N`.
4. All rows that contain a 'B' in column `c` must be identical to row `r`. / Tất cả các hàng chứa 'B' trong cột `c` phải giống hệt hàng `r`.

### Constraints / Ràng buộc
- `1 <= picture.length, picture[0].length <= 200`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### String Signature + Counting / Chữ ký Chuỗi + Đếm
Rule 4 is stringent. It implies that if a column has 'B's in rows `r1`, `r2`, ... then `row[r1] == row[r2] == ...`.
Combined with Rule 3 (col count is N), this means there are exactly `N` identical rows containing 'B' at column `c`.

Algorithm:
1. Count 'B's in each col -> `colCount`.
2. Map each row string to its frequency -> `rowStrMap`.
3. Iterate through valid rows (where # of 'B's == N):
   - Get the row string `s`.
   - If `rowStrMap.get(s) == N` (meaning there are exactly N such identical rows):
     - For each column `j` where `picture[i][j] == 'B'`:
       - Check if `colCount[j] == N`.
       - If yes, add `N` to result (or handle logic to not overcount; actually we iterate each row, so just add `1` for each valid cell, or analyze group wise).
       - Note: If `rowStrMap.get(s) == N`, it means there are N identical rows. For a specific column `j` having 'B', `colCount[j]` must be `N` (contributed by these N rows). If `colCount[j] == N`, then all `N` rows contribute. So we can add `N` to the answer for this column `j` once for the group of rows.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) for map keys.

---
