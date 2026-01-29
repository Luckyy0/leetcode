# 1444. Number of Ways of Cutting a Pizza / Số Cách Cắt Pizza

## Problem Description / Mô tả bài toán
Pizza grid `k` rows x `c` cols. 'A' (apple) or '.'.
Cut horizontal or vertical. Give upper/left piece to person. Remaining is right/lower piece.
Piece must contain at least one apple.
Cut `k-1` times (k people). Last piece also must have apple.
Count ways mod 10^9 + 7.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming + Prefix Sum (2D)
`dp[k][row][col]`: Ways to cut remaining pizza `subgrid(row, col)` into `k` pieces.
To check apple existence efficiently: 2D Suffix Sums. `apples[r][c]` = number of apples in `subgrid(r, c)`.
Transition:
- Horizontal cut at `r` (between `row` and `r`):
  If `apples[row][col] - apples[r+1][col] > 0` (upper piece has apple) AND `apples[r+1][col] > 0` (remaining has apple):
    `ways += dp[k-1][r+1][col]`.
- Vertical cut at `c`:
  If `apples[row][col] - apples[row][c+1] > 0` (left piece has apple) AND `apples[row][c+1] > 0`:
    `ways += dp[k-1][row][c+1]`.
Base case: `k=1`. If `apples[row][col] > 0`, return 1. Else 0.

### Complexity / Độ phức tạp
- **Time**: O(K * M * N * (M + N)).
- **Space**: O(K * M * N).

---

## Analysis / Phân tích

### Approach: 3D DP with Memoization
Precompute apple counts using 2D suffix sums.
Define recursive function `solve(k, r, c)`: ways to cut pizza defined by top-left `(r, c)` into `k` pieces.
Memoize results.
Iterate splitting lines.
Tiền xử lý số lượng táo bằng tổng hậu tố 2D.
Xác định hàm đệ quy `solve(k, r, c)`: các cách cắt bánh pizza được xác định bởi trên cùng bên trái `(r, c)` thành `k` miếng.
Ghi nhớ kết quả.
Lặp lại các đường chia.

---
