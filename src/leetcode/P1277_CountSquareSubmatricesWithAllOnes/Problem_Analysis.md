# 1277. Count Square Submatrices with All Ones / Đếm Ma trận con Hình vuông có Tất cả số Một

## Problem Description / Mô tả bài toán
Given `m x n` binary matrix.
Count how many square submatrices have all ones.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][j]` = side length of largest square with all ones ending at `(i, j)`.
If `matrix[i][j] == 1`:
`dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`.
If `dp[i][j] = k`, it means there are squares of size 1, 2, ..., k ending at `(i, j)`.
So just sum up all `dp[i][j]`.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) or O(1) in-place.

---

## Analysis / Phân tích

### Approach: DP Accumulation
Use DP similar to finding the maximal square. Let `dp[i][j]` be the side length of the largest square of 1s ending at `(i, j)`. The number of squares ending at `(i, j)` is exactly `dp[i][j]` (since a square of size `k` implies existence of squares of size `1` to `k-1` ending at the same corner). Iterate through the matrix, compute `dp[i][j]`, and add it to the total count.
Sử dụng DP tương tự như tìm hình vuông lớn nhất. Gọi `dp[i][j]` là độ dài cạnh của hình vuông lớn nhất gồm các số 1 kết thúc tại `(i, j)`. Số lượng hình vuông kết thúc tại `(i, j)` chính xác là `dp[i][j]` (vì hình vuông kích thước `k` ngụ ý sự tồn tại của các hình vuông kích thước `1` đến `k-1` kết thúc tại cùng một góc). Lặp qua ma trận, tính `dp[i][j]` và cộng nó vào tổng số.

---
