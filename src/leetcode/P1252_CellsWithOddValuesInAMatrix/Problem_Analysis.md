# 1252. Cells with Odd Values in a Matrix / Các ô có Giá trị Lẻ trong Ma trận

## Problem Description / Mô tả bài toán
Matrix `m x n` initially zeros. Indices `indices` where `indices[i] = [r, c]`.
For each `[r, c]`, increment all cells in row `r` and column `c`.
Return number of cells with odd values.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Row/Col Counters
Instead of simulating full matrix:
`rows[r]` increments. `cols[c]` increments.
Cell `(r, c)` value = `rows[r] + cols[c]`.
Odd if `(rows[r] + cols[c]) % 2 != 0`.
This means one is even and other is odd.
Count odd rows `oddRows`. Count odd cols `oddCols`.
Odd cells = `oddRows * (n - oddCols) + (m - oddRows) * oddCols`.
(Rows that are odd combined with Cols that are even) + (Rows even combined with Cols odd).

### Complexity / Độ phức tạp
- **Time**: O(L + M + N) where L is indices length.
- **Space**: O(M + N).

---

## Analysis / Phân tích

### Approach: Counting Odd Rows and Columns
Maintain counters for how many times each row and each column has been incremented (`row_inc` and `col_inc`). A cell `(r, c)` is odd if `row_inc[r] + col_inc[c]` is odd. This happens if `row_inc[r]` is odd and `col_inc[c]` is even, or vice versa. Count total odd rows (`ro`) and odd columns (`co`). The total odd cells is `ro * (n - co) + (m - ro) * co`.
Duy trì bộ đếm số lần mỗi hàng và mỗi cột đã được tăng lên (`row_inc` và `col_inc`). Ô `(r, c)` là lẻ nếu `row_inc[r] + col_inc[c]` là lẻ. Điều này xảy ra nếu `row_inc[r]` là lẻ và `col_inc[c]` là chẵn, hoặc ngược lại. Đếm tổng số hàng lẻ (`ro`) và cột lẻ (`co`). Tổng số ô lẻ là `ro * (n - co) + (m - ro) * co`.

---
