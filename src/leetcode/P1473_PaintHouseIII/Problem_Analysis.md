# 1473. Paint House III / Sơn nhà III

## Problem Description / Mô tả bài toán
Row of `m` houses. `n` colors.
Some painted (`houses[i] != 0`), some empty (0).
`cost[i][j]` to paint house `i` with color `j+1`.
Target: exactly `target` neighborhoods (contiguous blocks of same color).
Min cost.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (3D)
`dp[i][last_color][neighborhoods]`
`i`: House index (0 to m-1).
`last_color`: Color of house `i` (1 to n).
`neighborhoods`: Count of neighborhoods so far.
Transitions:
House `i`.
Case 1: `houses[i] != 0` (Already painted).
  Color is fixed `c = houses[i]`.
  Prev color `prev`.
  If `c != prev`, neighborhoods++.
  `dp[i][c][new_nb] = min(dp[i][c][new_nb], dp[i-1][prev][nb])`.
Case 2: `houses[i] == 0`.
  Try painting color `k` (1 to n). Cost `cost[i][k-1]`.
  Prev color `prev`.
  Update neighborhoods.
  `dp[i][k][new_nb] = min(..., dp[i-1][prev][nb] + cost[i][k-1])`.

### Complexity / Độ phức tạp
- **Time**: O(M * N^2 * Target). N=20, Target=100, M=100. $20^2 * 100 * 100 = 4,000,000$. OK.
- **Space**: O(M * N * Target).

---

## Analysis / Phân tích

### Approach: 3D DP
Initialize `dp` with infinity. `dp[-1][0][0] = 0` (conceptual).
Actually `dp[house_idx][color][count]`.
Iterate `i` (0 to m-1).
  Iterate `c` (1 to n).
    If `houses[i]` fixed and `houses[i] != c`, skip.
    Iterate `prev_c` (0 to n). (0 for start).
    Iterate `nb` (1 to target).
      `new_nb = nb + (c != prev_c ? 1 : 0)`.
      If valid, update `dp[i][c][new_nb]`.
Space Optimization: `dp[color][count]` is enough for current and previous row.
Cẩn thận với trạng thái màu trước đó 0 (cho ngôi nhà đầu tiên).

---
