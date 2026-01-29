# 1230. Toss Strange Coins / Tung Đồng xu Kỳ lạ

## Problem Description / Mô tả bài toán
Given `prob` array where `prob[i]` is probability that `i-th` coin heads.
Return probability that number of heads is exactly `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][k]` = prob using first `i` coins having `k` heads.
`dp[i][k] = dp[i-1][k] * (1 - p) + dp[i-1][k-1] * p`.
Base case: `dp[0][0] = 1`.

### Complexity / Độ phức tạp
- **Time**: O(N * Target).
- **Space**: O(Target) (space optimized).

---

## Analysis / Phân tích

### Approach: DP Probability
Use dynamic programming where `dp[k]` represents the probability of getting exactly `k` heads after considering the current set of coins. When processing a coin with probability `p` of being heads:
`new_dp[k] = dp[k] * (1 - p)` (coin was tails) `+ dp[k-1] * p` (coin was heads).
Iterate updates carefully (e.g., backwards from `target` to 0) to reuse the 1D array.
Sử dụng quy hoạch động trong đó `dp[k]` đại diện cho xác suất nhận được chính xác `k` mặt ngửa sau khi xem xét tập hợp đồng xu hiện tại. Khi xử lý một đồng xu có xác suất `p` là mặt ngửa:
`new_dp[k] = dp[k] * (1 - p)` (đồng xu là mặt sấp) `+ dp[k-1] * p` (đồng xu là mặt ngửa).
Lặp lại các bản cập nhật một cách cẩn thận (ví dụ: ngược từ `target` về 0) để sử dụng lại mảng 1D.

---
