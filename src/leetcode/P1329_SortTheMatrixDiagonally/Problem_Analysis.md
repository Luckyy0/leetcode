# 1329. Sort the Matrix Diagonally / Sắp xếp Ma trận theo Đường chéo

## Problem Description / Mô tả bài toán
Matrix `m x n`. Sort each diagonal from top-left to bottom-right in ascending order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Diagonal Properties
A cell `(i, j)` belongs to diagonal defined by `i - j`.
Collect elements for each `i - j`, sort them, and put back.
`i - j` ranges from `-(n-1)` to `m-1`.

### Complexity / Độ phức tạp
- **Time**: O(M * N * log (min(M, N))).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: HashMap of PriorityQueues
Use a HashMap (or array with offset) to store elements for each diagonal key `i - j`.
Iterate through the matrix, add `mat[i][j]` to the collection for `i - j`.
Sort each collection (or use PriorityQueue implicitly).
Iterate through the matrix again, pop the smallest element from the `i - j` collection and place it in `mat[i][j]`.
Sử dụng HashMap (hoặc mảng có độ lệch) để lưu trữ các phần tử cho mỗi khóa đường chéo `i - j`.
Lặp qua ma trận, thêm `mat[i][j]` vào bộ sưu tập cho `i - j`.
Sắp xếp từng bộ sưu tập (hoặc sử dụng PriorityQueue một cách ngầm định).
Lặp lại qua ma trận một lần nữa, lấy phần tử nhỏ nhất từ bộ sưu tập `i - j` và đặt nó vào `mat[i][j]`.

---
