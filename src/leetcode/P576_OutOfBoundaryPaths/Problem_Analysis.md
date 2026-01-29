# 576. Out of Boundary Paths / Các Đường Dẫn Ra Ngoài Biên

## Problem Description / Mô tả bài toán
There is an `m x n` grid with a ball. The ball is initially at the position `[startRow, startColumn]`. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply **at most** `maxMove` moves to the ball.
Có một lưới `m x n` với một quả bóng. Quả bóng ban đầu ở vị trí `[startRow, startColumn]`. Bạn được phép di chuyển quả bóng đến một trong bốn ô liền kề trong lưới (có thể ra khỏi lưới vượt qua biên giới của lưới). Bạn có thể áp dụng **tối đa** `maxMove` bước di chuyển cho quả bóng.

Given the five integers `m`, `n`, `maxMove`, `startRow`, `startColumn`, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo `10^9 + 7`.
Cho năm số nguyên `m`, `n`, `maxMove`, `startRow`, `startColumn`, hãy trả về số lượng đường dẫn để di chuyển quả bóng ra khỏi biên giới lưới. Vì câu trả lời có thể rất lớn, hãy trả về nó theo modulo `10^9 + 7`.

### Example 1:
```text
Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch động
We need to count paths of length `k` (where `1 <= k <= maxMove`) that end outside the grid.
State: `dp[k][i][j]` = Number of valid paths of length `k` ending at `(i, j)`.
But actually, it's easier to track paths remaining INSIDE.
Or directly track paths leading OUT.
A path leads out if we are at boundary and move outwards.

Let `dp[i][j]` be the number of ways to reach cell `(i, j)` in `steps`.
Initially `dp[startRow][startColumn] = 1`.
For each step `s` from 1 to `maxMove`:
- Create `temp` grid.
- For each cell `(r, c)` with `count > 0`:
  - Try 4 directions.
  - If neighbor is OUT, add `count` to `totalPaths`.
  - If neighbor is IN, add `count` to `temp[nr][nc]`.
- Update `dp = temp`.

### Complexity / Độ phức tạp
- **Time**: O(maxMove * m * n).
- **Space**: O(m * n).

---

## Analysis / Phân tích

### Approach: 3D or 2D Dynamic Programming

**Algorithm**:
1.  Initialize DP Grid with start position having 1 path.
2.  Iterate `N` moves.
3.  Propagate path counts to neighbors.
4.  Accumulate counts that fall off the grid edge into the result.
5.  Apply modulo at each addition.

---
