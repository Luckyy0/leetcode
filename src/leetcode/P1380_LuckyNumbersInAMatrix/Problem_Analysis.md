# 1380. Lucky Numbers in a Matrix / Số May mắn trong Ma trận

## Problem Description / Mô tả bài toán
Matrix `matrix`. Lucky number:
- Min in its row.
- Max in its column.
Return all lucky numbers.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Min-Max Check
For each row, find min value and its column index.
Check if that value is max in that column.
Alternatively:
1. Find min of each row -> `minRow[i]`.
2. Find max of each column -> `maxCol[j]`.
3. Iterate `(i, j)`. If `matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]`, it's lucky.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M + N).

---

## Analysis / Phân tích

### Approach: Precompute Extremes
Compute an array `minRow` storing the minimum of each row. Compute an array `maxCol` storing the maximum of each column. Iterate through the matrix; if an element equals both its row minimum and column maximum, add it to the result list.
Tính toán một mảng `minRow` lưu trữ giá trị nhỏ nhất của mỗi hàng. Tính toán một mảng `maxCol` lưu trữ giá trị lớn nhất của mỗi cột. Lặp qua ma trận; nếu một phần tử bằng cả giá trị nhỏ nhất của hàng và giá trị lớn nhất của cột, hãy thêm nó vào danh sách kết quả.

---
