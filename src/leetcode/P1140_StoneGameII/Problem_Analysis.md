# 1140. Stone Game II / Trò chơi Đá II

## Problem Description / Mô tả bài toán
Two players, Alice and Bob, play a game with piles of stones. `piles[i]` is the number of stones in the `i-th` pile.
Alice takes first. Initially `M = 1`.
On each turn, the current player can take all the stones in the first `X` remaining piles, where `1 <= X <= 2M`.
Then, we set `M = max(M, X)`.
The game continues until all stones are taken.
Return the maximum number of stones Alice can get.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Memoization / DP với Memoization
State: `(index, M, isAlice)`.
`dp[i][m]` = Max stones current player can get from `piles[i:]` given `M`.
Total stones from `i` to `n-1` is `suffixSum[i]`.
If current player takes `X` piles (getting sum `S`), the next player will get `dp[i+X][max(m, X)]`.
Current player gets `suffixSum[i] - dp[i+X][max(m, x)]` (Total available - what opponent gets).
We maximize this over `1 <= X <= 2M`.

Algorithm:
1. Compute suffix sums.
2. Memoization table `memo[i][m]`.
3. `solve(i, m)`:
   - Base case: `i >= n`, return 0.
   - If `i + 2*m >= n`, we can take all remaining. Return `suffixSum[i]`.
   - Iterate `x` from 1 to `2*m`.
   - `opponentVal = solve(i + x, max(m, x))`.
   - `myVal = suffixSum[i] - opponentVal`.
   - Maximize `myVal`.

### Complexity / Độ phức tạp
- **Time**: O(N^3). States N*N, loop N. Actually `M` grows but limited by N effectively since `X <= 2M`, `M` can reach `N`.
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Min-Max DP (Game Theory)
Use Dynamic Programming to simulate optimal play. The state is defined by the current index `i` and the current `M` value. Since this is a zero-sum game (or fixed-sum game), maximizing one's gain is equivalent to minimizing the opponent's gain. `DP[i][m]` represents the maximum stones the current player can secure from the remaining piles. The transition involves trying all valid moves $X \in [1, 2M]$ and subtracting the opponent's optimal response from the total remaining stones.
Sử dụng Quy hoạch Động để mô phỏng cách chơi tối ưu. Trạng thái được xác định bởi chỉ số hiện tại `i` và giá trị `M` hiện tại. Vì đây là trò chơi có tổng bằng không (hoặc tổng cố định), việc tối đa hóa lợi ích của một người tương đương với việc giảm thiểu lợi ích của đối thủ. `DP[i][m]` đại diện cho số đá tối đa mà người chơi hiện tại có thể bảo đảm từ các đống còn lại. Quá trình chuyển đổi bao gồm thử tất cả các nước đi hợp lệ $X \in [1, 2M]$ và trừ đi phản ứng tối ưu của đối thủ từ tổng số đá còn lại.

---
