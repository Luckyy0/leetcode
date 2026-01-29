# 518. Coin Change II / Đổi Tiền II

## Problem Description / Mô tả bài toán
You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.
Cho một mảng số nguyên `coins` biểu thị các đồng tiền có mệnh giá khác nhau và một số nguyên `amount` biểu thị tổng số tiền.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return `0`.
Hãy trả về số lượng các kết hợp tạo nên số tiền đó. Nếu số tiền đó không thể được tạo ra bởi bất kỳ sự kết hợp nào của các đồng tiền, hãy trả về `0`.

You may assume that you have an infinite number of each kind of coin.
Bạn có thể giả định rằng mình có số lượng vô hạn cho mỗi loại tiền.

### Example 1:
```text
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
```

## Constraints / Ràng buộc
- `1 <= coins.length <= 300`
- `1 <= coins[i] <= 5000`
- `0 <= amount <= 5000`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Unbounded Knapsack) / Quy hoạch động (Cái túi không giới hạn)
This is a variation of the change-making problem where we want the **number of combinations**, not the minimum coins.

Algorithm:
1. Initialize a `dp` array of size `amount + 1` with 0s. Set `dp[0] = 1`.
2. For each `coin` in `coins`:
   - Iterate `i` from `coin` to `amount`:
     - `dp[i] += dp[i - coin]`.
     - This means the number of ways to get sum `i` includes all the ways to get sum `i - coin` (by adding one more `coin`).
3. Return `dp[amount]`.

*Note*: The order of loops is important. By iterating through each coin first, we ensure that we don't count permutations (like `1+2` and `2+1`) as distinct combinations.

### Complexity / Độ phức tạp
- **Time**: O(N * A) where N is the number of coins and A is the amount.
- **Space**: O(A).

---

## Analysis / Phân tích

### Approach: Bottom-up DP for Combination Counts

**Algorithm**:
1.  Initialize DP array.
2.  Iterate through coins one by one.
3.  Accumulate ways for each reachable amount.
4.  Result is `dp[amount]`.

---
