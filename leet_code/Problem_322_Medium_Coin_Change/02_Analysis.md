# Analysis for Coin Change
# *Phân tích cho bài toán Đổi Tiền*

## 1. Problem Essence & Unbounded Knapsack
## *1. Bản chất vấn đề & Bài toán Cai túi Không giới hạn*

### The Challenge
### *Thách thức*
Find min items to sum to T. Infinite supply.
Greedy fails (e.g., coins [1, 3, 4], amount 6. Greedy: 4, 1, 1 (3 coins). Optimal: 3, 3 (2 coins)).
Must use DP.

### Strategy: DP Bottom-Up
### *Chiến lược: DP Từ dưới lên*
`dp[i]`: Min coins for amount `i`.
Transitions: `dp[i] = min(dp[i], dp[i - coin] + 1)` for each coin.
Space Optimization: 1D array is sufficient.

---

## 2. Approach: DP
## *2. Hướng tiếp cận: DP*

### Logic
### *Logic*
1.  `dp` array size `amount + 1`. Fill with `amount + 1` (Sentinal Max).
2.  `dp[0] = 0`.
3.  Loop `i` from 1 to `amount`:
    - Loop `c` in `coins`:
        - If `c <= i`: `dp[i] = min(dp[i], dp[i-c] + 1)`.
4.  If `dp[amount] > amount`, return -1. Else return `dp[amount]`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Substructure:** Solution for `S` relies on `S - coin`.
    *Cấu trúc con tối ưu: Giải pháp cho `S` dựa vào `S - coin`.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(Amount \cdot K)$. $10^4 \cdot 12 \approx 10^5$. Very fast.
    *Độ phức tạp thời gian: $O(Amount \cdot K)$.*
*   **Space Complexity:** $O(Amount)$.
    *Độ phức tạp không gian: $O(Amount)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** [1, 2, 5], 11.
`dp`: [0, inf, ...]
1: min(inf, dp[0]+1) = 1.
2: min(inf, dp[1]+1(2), dp[0]+1(1)) = 1.
3: min(inf, dp[2]+1(2), dp[1]+1(2)) = 2.
...
11: min(..., dp[6]+1(5+1=2? No dp[6] is 2 (3,3)). dp[10]+1(2+1=3)). Result 3.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic DP.
*DP kinh điển.*
---
*Giá trị nhỏ nhất (lowest cost) thường được xây dựng từ những bước tích lũy nhỏ bé (small coins). Không có con đường tắt (greedy) nào đảm bảo thành công trong mọi hoàn cảnh.*
The lowest cost is often built from small cumulative steps (small coins). No shortcut (greedy) guarantees success in every circumstance.
