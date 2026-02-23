# Analysis for Coin Change II
# *Phân tích cho bài toán Đổi Tiền II*

## 1. Problem Essence & Unbounded Knapsack
## *1. Bản chất vấn đề & Bài toán Cái túi Không giới hạn*

### The Challenge
### *Thách thức*
Counting ways to sum to `amount` using unlimited coins.
- This is exactly **Unbounded Knapsack** (counting variants).

### Strategy: 1D DP
### *Chiến lược: DP 1 chiều*

1.  **State:** `dp[j]` = number of ways to make sum `j`.
2.  **Transition:** For each coin `c`:
    - `dp[j] += dp[j - c]` for `j` from `c` to `amount`.
    - Note: Outer loop MUST be coins to count *combinations* (order doesn't matter). If outer loop is amount, we count *permutations* (`1+2` and `2+1` distinction).

---

## 2. Approach: DP Iteration
## *2. Hướng tiếp cận: Lặp DP*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Space Efficient:** $O(Amount)$.
    *Hiệu quả không gian: $O(Amount)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot Amount)$.
    *Độ phức tạp thời gian: $O(N \cdot Amount)$.*
*   **Space Complexity:** $O(Amount)$.
    *Độ phức tạp không gian: $O(Amount)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `5`, `[1, 2, 5]`
1. `dp[0]=1`.
2. Coin 1: `dp[1]+=dp[0](1)`, `dp[2]+=dp[1](1)`... `dp` becomes `[1,1,1,1,1,1]`. (Only 1s).
3. Coin 2:
   - `j=2`: `dp[2]+=dp[0]=2`.
   - `j=3`: `dp[3]+=dp[1]=2`.
   - `j=4`: `dp[4]+=dp[2]=3`.
   - `j=5`: `dp[5]+=dp[3]=3`.
4. Coin 5:
   - `j=5`: `dp[5]+=dp[0]=4`.
Result: 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DP with outer loop over coins.
*DP với vòng lặp bên ngoài qua các đồng xu.*
---
*Tiền tệ (Coins) chỉ là công cụ, nhưng cách kết hợp chúng (Combinations) lại tạo ra vô vàn khả năng. Bằng cách xây dựng từ những đơn vị nhỏ nhất (Unbounded Knapsack), ta có thể tích lũy nên những giá trị to lớn (Amount) theo nhiều cách khác nhau.*
Currency (Coins) is just a tool, but how to combine them (Combinations) creates countless possibilities. By building from the smallest units (Unbounded Knapsack), we can accumulate huge values (Amount) in many different ways.
