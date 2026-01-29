# 1510. Stone Game IV / Trò chơi Đá IV

## Problem Description / Mô tả bài toán
`n` stones. Alice & Bob take turns removing square number of stones ($k^2 > 0$).
Can't move -> lose. Return true if Alice wins.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Game Theory)
`dp[i]` = true if current player can win starting with `i` stones.
`dp[i] = OR ( !dp[i - k*k] )` for all $k^2 \le i$.
i.e., if there exists a move to a losing state for the opponent, then current state is winning.

### Complexity / Độ phức tạp
- **Time**: O(N * sqrt(N)).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Iterative DP
Iterate `i` from 1 to `n`.
Iterate `k` s.t. `k*k <= i`.
If `!dp[i - k*k]`: `dp[i] = true`, break.
Lặp lại `i` từ 1 đến `n`.
Lặp lại `k` sao cho `k*k <= i`.
Nếu `!dp[i - k*k]`: `dp[i] = true`, ngắt.

---
