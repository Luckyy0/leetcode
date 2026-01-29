# 1478. Allocate Mailboxes / Phân bổ Hộp thư

## Problem Description / Mô tả bài toán
Array `houses` (positions). Integer `k` (mailboxes).
Assign each house to nearest mailbox.
Minimize total distance.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Interval DP)
`dp[k][i]`: Min distance to cover houses `0...i` using `k` mailboxes.
Transition:
`dp[k][i] = min(dp[k-1][j] + cost(j+1, i))` for `j < i`.
`cost(j+1, i)`: Cost to cover houses `j+1` to `i` with ONE mailbox.
Optimal location for 1 mailbox covering a range of houses is the MEDIAN house.
Cost is sum of distances to median.

### Complexity / Độ phức tạp
- **Time**: O(K * N^2) or O(N^3). N=100. $100^3 = 10^6$. OK.
- **Space**: O(N^2) for precomputed costs.

---

## Analysis / Phân tích

### Approach: DP with Precomputed Costs
1. Sort houses.
2. Precompute `costs[i][j]`: cost to cover houses `i..j` with 1 mailbox.
   - Mailbox at `houses[(i+j)/2]`.
   - Sum distances.
3. DP: `dp[k][i]` min cost for first `i+1` houses with `k` mailboxes.
   - Iterate split point `p`: `dp[k][i] = min(dp[k-1][p] + costs[p+1][i])`.
   - `p` goes from `k-2` to `i-1`. (Need at least `k-1` houses for `k-1` mailboxes).
   - Actually simpler: `dp[i][k]`.

1. Sắp xếp các ngôi nhà.
2. Tính trước `costs[i][j]`: chi phí để bao phủ các ngôi nhà `i..j` bằng 1 hộp thư. (Hộp thư tại trung vị).
3. DP: `dp[k][i] = min(dp[k-1][p] + costs[p+1][i])`.

---
