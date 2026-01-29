# 322. Coin Change / Đổi Tiền Xu

## Problem Description / Mô tả bài toán
You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.
Bạn được cung cấp một mảng số nguyên `coins` đại diện cho các đồng xu có mệnh giá khác nhau và một số nguyên `amount` đại diện cho tổng số tiền.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return `-1`.
Trả về số lượng đồng xu ít nhất mà bạn cần để tạo nên số tiền đó. Nếu số tiền đó không thể được tạo thành, trả về `-1`.

You may assume that you have an infinite number of each kind of coin.

### Example 1:
```text
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
```

### Example 2:
```text
Input: coins = [2], amount = 3
Output: -1
```

### Example 3:
```text
Input: coins = [1], amount = 0
Output: 0
```

## Constraints / Ràng buộc
- `1 <= coins.length <= 12`
- `1 <= coins[i] <= 2^31 - 1`
- `0 <= amount <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming (Unbounded Knapsack) / Quy Hoạch Động
`dp[i]` = minimum coins to make amount `i`.
`dp[i] = min(dp[i - c] + 1)` for all `c` in `coins` where `i >= c`.
Base case: `dp[0] = 0`. Initialize others to infinity.

### Complexity / Độ phức tạp
- **Time**: O(Amount * Coins).
- **Space**: O(Amount).

---

## Analysis / Phân tích

### Approach: Bottom Up DP

**Algorithm**:
1.  `dp` array size `amount + 1`. Fill with `amount + 1` (as infinity).
2.  `dp[0] = 0`.
3.  Loop `i` from 1 to `amount`.
4.  Loop `c` in `coins`.
5.  If `i >= c`, `dp[i] = min(dp[i], dp[i-c] + 1)`.
6.  If `dp[amount] > amount`, return -1. Else return `dp[amount]`.

---
