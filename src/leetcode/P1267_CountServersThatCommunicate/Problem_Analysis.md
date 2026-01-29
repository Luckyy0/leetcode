# 1267. Count Servers that Communicate / Đếm Máy chủ Giao tiếp

## Problem Description / Mô tả bài toán
Grid `m x n` with servers (1).
Two servers communicate if they are on same row or same col.
Count servers that can communicate with at least one other server.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Row/Column Counts
Count servers in each row `rowCount[i]` and column `colCount[j]`.
Iterate grid. If `grid[i][j] == 1` and (`rowCount[i] > 1` OR `colCount[j] > 1`), increment answer.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M + N).

---

## Analysis / Phân tích

### Approach: Precompute Counts
First pass: iterate through the grid to populate `rowCount` and `colCount` arrays, counting the number of servers in each row and column.
Second pass: iterate through the grid again. For every server at `(i, j)`, check if `rowCount[i] > 1` or `colCount[j] > 1`. If so, this server is not isolated (it communicates with another server in the same row or column); add it to the total count.
Lượt đầu tiên: lặp qua lưới để điền vào mảng `rowCount` và `colCount`, đếm số lượng máy chủ trong mỗi hàng và cột.
Lượt thứ hai: lặp lại qua lưới một lần nữa. Đối với mọi máy chủ tại `(i, j)`, hãy kiểm tra xem `rowCount[i] > 1` hay `colCount[j] > 1`. Nếu vậy, máy chủ này không bị cô lập (nó giao tiếp với máy chủ khác trong cùng một hàng hoặc cột); thêm nó vào tổng số đếm.

---
