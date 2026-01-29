# 779. K-th Symbol in Grammar / Ký hiệu thứ K trong Ngữ pháp

## Problem Description / Mô tả bài toán
We build a table of `n` rows (1-indexed). We start with `0` in the first row. In each subsequent row, we replace every occurrence of `0` with `01` and every occurrence of `1` with `10`.
Chúng ta xây dựng một bảng gồm `n` hàng (bắt đầu từ 1). Chúng ta bắt đầu với `0` ở hàng đầu tiên. Trong mỗi hàng tiếp theo, chúng ta thay thế mọi lần xuất hiện của `0` bằng `01` và mọi lần xuất hiện của `1` bằng `10`.

Given `n` and `k`, return the `kth` (1-indexed) symbol in the `nth` row.
Cho `n` và `k`, hãy trả về ký tự thứ `k` (bắt đầu từ 1) ở hàng thứ `n`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Binary Tree / Cây Nhị phân Đệ quy
The rows form a binary tree structure.
Các hàng tạo thành màu cấu trúc cây nhị phân.

- Row 1: `0`
- Row 2: `0 1` (from 0)
- Row 3: `0 1 1 0` (from 0 and 1)

Key observations:
1. The left half of row `n` is identical to row `n-1`.
2. The right half of row `n` is the complement of row `n-1`.

Algorithm:
- If `k` is in the first half (`k <= length/2`), return `solve(n-1, k)`.
- If `k` is in the second half, return `1 - solve(n-1, k - length/2)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) recursion stack.

---

## Analysis / Phân tích

### Approach: Recursive Complement
Using the symmetry and growth rules of the sequence, we reduce the problem size by half at each recursive step.
Sử dụng các quy tắc đối xứng và phát triển của chuỗi, chúng ta giảm kích thước vấn đề đi một nửa sau mỗi bước đệ quy.

---
