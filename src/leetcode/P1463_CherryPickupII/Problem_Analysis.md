# 1463. Cherry Pickup II / Thu thập Cherry II

## Problem Description / Mô tả bài toán
Grid `grid`. Robot 1 start (0, 0). Robot 2 start (0, cols-1).
Move down to (next row, col-1/col/col+1).
Collect sum of cherries. Meeting at same cell only counts once.
Maximize total.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (3D)
`dp[row][c1][c2]`: Max cherries at row `row` with robot 1 at `c1` and robot 2 at `c2`.
Since both robots move down simultaneously, they are always at same row.
Transition:
`dp[row][c1][c2] = cherries(row, c1, c2) + max(dp[row-1][prevC1][prevC2])`.
`prevC1` in `c1-1, c1, c1+1`. `prevC2` in `c2-1, c2, c2+1`. (9 combinations).
Cherries: `grid[row][c1]` + `grid[row][c2]`. If `c1 == c2`, only add once.
Base case: `dp[0][0][cols-1] = grid[0][0] + grid[0][cols-1]`. All other `dp[0]` are -Infinity.

### Complexity / Độ phức tạp
- **Time**: O(M * N^2). M rows, N cols. N <= 70. 70 rows. $70^3 = 343000$. OK.
- **Space**: O(N^2) (using 2 layers) or O(M * N^2).

---

## Analysis / Phân tích

### Approach: 3D DP / 2D Layer Optimization
Create `dp[c1][c2]` initialized to -1. `dp[0][n-1] = startVal`.
Iterate each row `r`.
Create `next_dp`.
For each `c1`, `c2`:
- Find max from `dp` considering moves `[-1, 0, 1]` for both.
- If reachable, add current cherries.
Swap `dp` and `next_dp`.
Result is `max(dp)`.
Tạo `dp[c1][c2]`. Lặp lại từng hàng `r`.
Tạo `next_dp`.
Đối với mỗi `c1`, `c2`: Tìm max từ `dp`.
Nếu có thể truy cập, hãy thêm quả anh đào hiện tại.
Trao đổi `dp` và `next_dp`.

---
