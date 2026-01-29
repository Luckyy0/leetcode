# 668. Kth Smallest Number in Multiplication Table / Số Nhỏ thứ K trong Bảng Nhân

## Problem Description / Mô tả bài toán
Nearly everyone has used the Multiplication Table. The multiplication table of size `m x n` is an integer matrix `mat` where `mat[i][j] == i * j` (1-indexed).
Gần như mọi người đã sử dụng Bảng nhân. Bảng nhân kích thước `m x n` là một ma trận số nguyên `mat` trong đó `mat[i][j] == i * j` (bắt đầu từ 1).

Given three integers `m`, `n`, and `k`, return the kth smallest element in the multiplication table of size `m x n`.
Cho ba số nguyên `m`, `n` và `k`, hãy trả về phần tử nhỏ thứ k trong bảng nhân kích thước `m x n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Value Range / Tìm kiếm Nhị phân trên Phạm vi Giá trị
Since the multiplication table is sorted in rows and columns, we can use binary search on the range `[1, m * n]` to find the kth smallest value.
Vì bảng nhân được sắp xếp theo hàng và cột, chúng ta có thể sử dụng tìm kiếm nhị phân trên phạm vi `[1, m * n]` để tìm giá trị nhỏ thứ k.

For a chosen `mid`, we can efficiently count how many elements are `<= mid`:
`count = sum(min(mid / i, n))` for each row `i`.
`số_lượng = tổng(min(mid / i, n))` cho mỗi hàng `i`.

### Complexity / Độ phức tạp
- **Time**: O(M * log(M * N)) where M is the number of rows.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search on Answer
The answer is bounded by `1` and `m * n`. In each step of binary search, we verify if there are at least `k` elements smaller than or equal to `mid`.
Câu trả lời bị giới hạn bởi `1` và `m * n`. Trong mỗi bước của tìm kiếm nhị phân, chúng ta xác minh xem có ít nhất `k` phần tử nhỏ hơn hoặc bằng `mid` hay không.

---
