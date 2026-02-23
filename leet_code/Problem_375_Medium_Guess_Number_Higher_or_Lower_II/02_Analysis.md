# Analysis for Guess Number Higher or Lower II
# *Phân tích cho bài toán Đoán số Cao hơn hay Thấp hơn II*

## 1. Problem Essence & Minimax DP
## *1. Bản chất vấn đề & Quy hoạch động Minimax*

### The Challenge
### *Thách thức*
We want the *minimum* cost to guarantee success against the *worst* possible scenario (maximum cost). This is a classic minimax problem.

### Strategy: Interval DP
### *Chiến lược: DP trên Khoảng*
Let `dp[i][j]` be the minimum cost to guarantee a win for the range $[i, j]$.
1.  **Base Cases:**
    - If $i \ge j$: `dp[i][j] = 0` (only one number or no numbers, no money needed).
2.  **Recursive Step:**
    To find `dp[i][j]`, we can try guessing every number $k$ between $i$ and $j$.
    - If we guess $k$:
        - Worst case cost for this guess: `k + max(dp[i][k-1], dp[k+1][j])`.
    - We want the best guess:
        - `dp[i][j] = min_{k=i..j} (k + max(dp[i][k-1], dp[k+1][j]))`.

---

## 2. Approach: Iterative DP (Bottom-up)
## *2. Hướng tiếp cận: DP Lặp (Dưới lên)*

### Logic
### *Logic*
Iterate through the length of the interval from 1 to $n$. For each length, slide the window across all possible start positions.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Guarantee:** Correctly models the "Min-Max" relationship.
    *Đảm bảo tối ưu: Mô hình hóa chính xác mối quan hệ Min-Max.*
*   **Reusability:** Smaller intervals are solved first and used to solve larger ones.
    *Tính tái sử dụng: Các khoảng nhỏ được giải quyết trước và được sử dụng để giải các khoảng lớn hơn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^3)$ (three nested loops: length, start, and guess $k$).
    *Độ phức tạp thời gian: $O(N^3)$.*
*   **Space Complexity:** $O(N^2)$ to store the DP table.
    *Độ phức tạp không gian: $O(N^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**n = 3**
1. `dp[1][1], dp[2][2], dp[3][3] = 0`.
2. `dp[1][2]`: Guess 1 ($1 + \max(0, 0) = 1$) or Guess 2 ($2 + \max(0, 0) = 2$). Min is 1.
3. `dp[2][3]`: Guess 2 ($2 + \max(0, 0) = 2$) or Guess 3 ($3 + \max(0, 0) = 3$). Min is 2.
4. `dp[1][3]`:
   - Guess 1: $1 + \max(0, dp[2][3]) = 1 + 2 = 3$.
   - Guess 2: $2 + \max(dp[1][1], dp[3][3]) = 2 + 0 = 2$.
   - Guess 3: $3 + \max(dp[1][2], 0) = 3 + 1 = 4$.
   - Min is 2.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

$O(N^3)$ Minimax Dynamic Programming.
*Quy hoạch động Minimax O(N^3).*
---
*Trong cuộc chơi sòng phẳng với sự không chắc chắn (worst case), đôi khi cách tốt nhất để tiết kiệm (minimum cost) là luôn chuẩn bị sẵn sàng cho kịch bản tồi tệ nhất (maximum scenario). Sự dự phòng khôn ngoan (DP) sẽ giúp ta luôn làm chủ tình thế.*
In a fair play with uncertainty (worst case), sometimes the best way to save (minimum cost) is to always be prepared for the worst scenario (maximum scenario). Wise contingency (DP) will help us always master the situation.
