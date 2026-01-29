# 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold / Độ dài Cạnh Tối đa của Hình vuông có Tổng Nhỏ hơn hoặc Bằng Ngưỡng

## Problem Description / Mô tả bài toán
Matrix `m x n`. Return max side length of square submatrix such that sum <= threshold.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### 2D Prefix Sum + Binary Search / Sliding Window
1. Compute 2D Prefix Sum `P[i][j]`.
   `Sum(r1, c1, r2, c2) = P[r2][c2] - P[r1-1][c2] - P[r2][c1-1] + P[r1-1][c1-1]`.
2. Binary Search for side length `k` from 0 to `min(m, n)`.
   - `check(k)`: Iterate all top-left `(i, j)`, calculate sum of `k x k`. If any <= threshold, return true.
3. Optimization: Start searching `k` from previous found `k` (or increase `k` incrementally).
   - If we found valid `k`, try `k+1` in next positions. 
   - Actually simpler: Iterate grid. Track `currentMax`. If we can extend to `currentMax + 1` at current cell, increment.
   - At `(i, j)`, check if square of size `len` fits and sum OK.
   - Sliding window approach is more complex in 2D.
   - Binary Search is O(MN log(min(MN))).

### Complexity / Độ phức tạp
- **Time**: O(M * N * log(min(M, N))).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: 2D Prefix Sum and Optimized Search
First, calculate the 2D prefix sum array `P` to allow O(1) calculation of any submatrix sum. To find the maximum side length `k`, we can either binary search for `k` or iterate through the grid. An optimized approach iterates through the grid `(i, j)` and maintains a variable `res` (current max valid side found). At each step, we try to see if a square of size `res + 1` ending at `(i, j)` has a sum $\le$ threshold. If so, we increment `res` (and inherently check larger squares in future steps). This effectively avoids re-checking smaller sizes.
Đầu tiên, tính mảng tổng tiền tố 2D `P` để cho phép tính tổng bất kỳ ma trận con nào trong O(1). Để tìm độ dài cạnh tối đa `k`, chúng ta có thể tìm kiếm nhị phân cho `k` hoặc lặp qua lưới. Một cách tiếp cận tối ưu lặp qua lưới `(i, j)` và duy trì một biến `res` (cạnh hợp lệ tối đa hiện tại được tìm thấy). Ở mỗi bước, chúng ta cố gắng xem liệu một hình vuông có kích thước `res + 1` kết thúc tại `(i, j)` có tổng $\le$ ngưỡng hay không. Nếu có, chúng ta tăng `res` (và vốn dĩ kiểm tra các hình vuông lớn hơn trong các bước trong tương lai). Điều này tránh việc kiểm tra lại các kích thước nhỏ hơn một cách hiệu quả.

---
