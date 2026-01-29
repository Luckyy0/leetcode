# 1406. Stone Game III / Trò chơi Đá III

## Problem Description / Mô tả bài toán
Array `stoneValue`. Alice and Bob take turns.
Alice starts.
Take 1, 2, or 3 stones from beginning.
Score = sum of taken stones.
Game ends when no stones.
Winner has higher score. return "Alice", "Bob", "Tie".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Minimax)
`dp[i]` = max score difference (MyScore - OpponentScore) starting from index `i`.
Alice wants to maximize this difference.
Options:
1. Take `stones[i]`: diff = `stones[i] - dp[i+1]`.
2. Take `stones[i], stones[i+1]`: diff = `(s[i]+s[i+1]) - dp[i+2]`.
3. Take `stones[i]...stones[i+2]`: diff = `(s[i]+s[i+1]+s[i+2]) - dp[i+3]`.
`dp[i] = max(option1, option2, option3)`.
Base case: `dp[n] = 0`.
Result based on `dp[0]`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Linear DP
Compute from `n-1` down to `0`. `dp[i]` represents maximum relative score (current player - opponent) from index `i`.
`dp[i] = max(take1 - dp[i+1], take2 - dp[i+2], take3 - dp[i+3])`.
Handle boundary conditions (at end of array).
If `dp[0] > 0` Alice wins. `dp[0] < 0` Bob wins. "Tie" otherwise.
Tính toán từ `n-1` xuống `0`. `dp[i]` đại diện cho điểm số tương đối tối đa (người chơi hiện tại - đối thủ) từ chỉ số `i`.
`dp[i] = max(take1 - dp[i+1], take2 - dp[i+2], take3 - dp[i+3])`.
Xử lý các điều kiện biên.
Nếu `dp[0] > 0` Alice thắng. `dp[0] < 0` Bob thắng.

---
