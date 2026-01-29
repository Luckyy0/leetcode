# 375. Guess Number Higher or Lower II / Đoán Số Cao Hơn Hay Thấp Hơn II

## Problem Description / Mô tả bài toán
We are playing the Guessing Game. The game will work as follows:
1.  I pick a number between `1` and `n`.
2.  You guess a number.
3.  If you guess the right number, you win the game.
4.  If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
5.  Every time you guess a wrong number `x`, you will pay `x` dollars. If you run out of money, you lose the game.

Given a particular `n`, return the **minimum amount of money you need to guarantee a win regardless of what number I pick**.
Cho `n`, trả về số tiền tối thiểu bạn cần để **đảm bảo thắng** bất kể tôi chọn số nào.
Guaranteed win means minimizing the maximum cost. Use Minimax strategy.

### Example 1:
```text
Input: n = 10
Output: 16
Explanation: The winning strategy is as follows:
- The range is [1, 10]. Guess 7.
    - If this is my number, your total is $0.
    - If my number is higher, the range is [8, 10]. Guess 9.
        - If this is my number, your total is $7.
        - If my number is higher, it must be 10. Your total is $7 + $9 = $16.
        - If my number is lower, it must be 8. Your total is $7 + $9 = $16.
    - If my number is lower, the range is [1, 6]. Guess 3.
        - If this is my number, your total is $7.
        - If my number is higher, the range is [4, 6]. Guess 5.
            - If this is my number, your total is $7 + $3 = $10.
            - If my number is higher, it must be 6. Total $7 + $3 + $5 = $15.
            - If my number is lower, it must be 4. Total $7 + $3 + $5 = $15.
        - If my number is lower, the range is [1, 2]. Guess 1.
            - If this is my number, total $7 + $3 = $10.
            - If my number is higher, it must be 2. Total $7 + $3 + $1 = $11.
The worst case in all these scenarios is $16.
```

## Constraints / Ràng buộc
- `1 <= n <= 200`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming (Minimax) / Quy Hoạch Động (Minimax)
Let `dp[i][j]` be the min cost to guarantee win in range `[i, j]`.
Target: `dp[1][n]`.
Base case: `dp[i][i] = 0` (No cost to guess single number).
Recurrence:
For range `[i, j]`, try every split point `k` (`i <= k <= j`).
If we guess `k`:
- If match: Cost 0 (but we consider worst case path, so cost is sum of wrong guesses. Match ends game, but worst case means we pay for k and move on).
    - Actually, cost is `k` + worst case of branches. Match case stops cost accumulation. But since we need guaranteed win, we assume we might be wrong.
    - If guess `k`, worst case is `max(dp[i][k-1], dp[k+1][j])`.
    - Total cost if picking `k` first: `k + max(dp[i][k-1], dp[k+1][j])`.
We want to minimize this total cost by choosing optimal `k` in `[i, j]`.
`dp[i][j] = min(k + max(dp[i][k-1], dp[k+1][j]))` for all `k`.

### Complexity / Độ phức tạp
- **Time**: O(N^3). N states * N split points.
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Interval DP

**Algorithm**:
1.  `dp[n+2][n+2]`. `dp[i][j]` stores cost for range i to j.
2.  Iterate `len` from 2 to `n`.
3.  Iterate `i` from 1 to `n - len + 1`.
4.  `j = i + len - 1`.
5.  `dp[i][j] = MAX`.
6.  Loop `k` from `i` to `j`:
    - `cost = k + max(dp[i][k-1], dp[k+1][j])`.
    - `dp[i][j] = min(dp[i][j], cost)`.
    - Optimization: `k` can start from `(i+j)/2`. Smaller guesses unlikely to be optimal.

---
