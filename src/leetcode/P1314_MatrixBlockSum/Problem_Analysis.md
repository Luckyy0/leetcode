# 1314. Matrix Block Sum / Tổng Khối Ma trận

## Problem Description / Mô tả bài toán
Matrix `mat`. Return matrix `answer` where `answer[i][j]` is sum of `mat[r][c]` for `i-k <= r <= i+k` and `j-k <= c <= j+k`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### 2D Prefix Sum / Tổng Tiền tố 2D
Compute 2D prefix sum.
`Sum(r1, c1, r2, c2)`.
For each `(i, j)`, define bounds:
`r1 = max(0, i-k), r2 = min(m-1, i+k)`
`c1 = max(0, j-k), c2 = min(n-1, j+k)`
Compute sum using prefix sums.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: 2D Prefix Sum
Construct a 2D prefix sum array `P` such that `P[i][j]` stores the sum of the submatrix from `(0,0)` to `(i,j)`. Use the inclusion-exclusion principle to calculate the sum of any query rectangle in O(1) time. Iterate through each cell of the `answer` matrix, determine the boundaries of the k-neighborhood, and query the prefix sum array.
Xây dựng mảng tổng tiền tố 2D `P` sao cho `P[i][j]` lưu trữ tổng của ma trận con từ `(0,0)` đến `(i,j)`. Sử dụng nguyên lý bao hàm-loại trừ để tính tổng của bất kỳ hình chữ nhật truy vấn nào trong thời gian O(1). Lặp qua từng ô của ma trận `answer`, xác định ranh giới của vùng lân cận k và truy vấn mảng tổng tiền tố.

---
