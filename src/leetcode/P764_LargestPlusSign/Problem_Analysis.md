# 764. Largest Plus Sign / Dấu cộng Lớn nhất

## Problem Description / Mô tả bài toán
You are given an integer `n`. You have an `n x n` binary grid `grid` with all values initially 1. You are also given a 2D integer array `mines` where `mines[i] = [ri, ci]` represents `grid[ri][ci] = 0`.
Bạn được cho một số nguyên `n`. Bạn có một lưới nhị phân `n x n` với tất cả các giá trị ban đầu là 1. Bạn cũng được cho một mảng số nguyên 2D `mines` trong đó `mines[i] = [ri, ci]` biểu thị `grid[ri][ci] = 0`.

An **axis-aligned plus sign** of order `k` at `(r, c)` is a collection of `2k - 1` cells with value 1, forming four arms of length `k-1` in each direction.
Một **dấu cộng căn chỉnh theo trục** bậc `k` tại `(r, c)` là một tập hợp gồm `2k - 1` ô có giá trị 1, tạo thành bốn cánh tay dài `k-1` theo mỗi hướng.

Return the order of the largest plus sign in `grid`.
Trả về bậc của dấu cộng lớn nhất trong `grid`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Precomputed Directions / Quy hoạch Động
For each cell `(r, c)`, the order of the largest plus sign centered there is:
`min(left[r][c], right[r][c], up[r][c], down[r][c])`
where each term is the number of consecutive 1s in that direction starting from `(r, c)`.

Algorithm:
1. Initialize a 2D array `dp[n][n]` where each cell stores the order limit.
2. Conduct 4 passes across the grid:
   - Left-to-right (compute left arms).
   - Right-to-left (compute right arms).
   - Top-to-bottom (compute up arms).
   - Bottom-to-top (compute down arms).
3. The final value at `dp[r][c]` is the minimum of the four results.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or reused DP table.

---

## Analysis / Phân tích

### Approach: 4-Directional DP
We precalculate how many consecutive 1s extend in all four cardinal directions from every single cell. The bottleneck for each cell determines the max plus sign size.
Chúng ta tính toán trước có bao nhiêu số 1 liên tiếp kéo dài theo cả bốn hướng chính từ mỗi ô. Điểm nghẽn cho mỗi ô sẽ xác định kích thước dấu cộng tối đa.

---
