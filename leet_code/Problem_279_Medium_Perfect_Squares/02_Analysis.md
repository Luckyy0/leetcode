# Analysis for Perfect Squares
# *Phân tích cho bài toán Số chính phương hoàn hảo*

## 1. Problem Essence & DP/BFS/Math
## *1. Bản chất vấn đề & DP/BFS/Toán học*

### The Challenge
### *Thách thức*
$N = a^2 + b^2 + c^2 + ...$
Minimize count of terms.
Example: $12 = 4+4+4$ (3 terms). $12 = 9+1+1+1$ (4 terms).
Similar to Coin Change problem where coins are squares $\{1, 4, 9, 16, ...\}$.

### Strategies
### *Chiến lược*
1.  **Dynamic Programming:** `dp[i] = min(dp[i - j*j]) + 1`.
2.  **BFS:** Shortest path in graph where edges are squares. Level 1 (squares), Level 2 (sums of 2 squares), etc.
3.  **Mathematics (Lagrange's Four Square Theorem):**
    - Every natural number can be represented as sum of 4 squares.
    - Legendre's Theorem: Num is sum of 3 squares unless `n = 4^a(8b + 7)`.
    - So answer is 1, 2, 3, or 4.
    - Check 1: Is `n` perfect square?
    - Check 4: Is `n` form `4^a(8b + 7)`?
    - Check 2: Can `n` be written as $i^2 + j^2$? (Iterate $i$, check if $n - i^2$ is square).
    - Else 3.

---

## 2. Approach: Dynamic Programming
## *2. Hướng tiếp cận: Quy hoạch động*

### Logic
### *Logic*
1.  Array `dp` size `n + 1`. Fill with Infinity. `dp[0] = 0`.
2.  Iterate `i` from 1 to `n`:
    - Iterate `j` from 1 while `j*j <= i`:
        - `dp[i] = min(dp[i], dp[i - j*j] + 1)`
3.  Return `dp[n]`.

This is standard. $O(N \sqrt{N})$. With $N=10^4$: $10^4 \times 100 = 10^6$. Very fast.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Subproblem:** Optimal substructure property holds perfectly.
    *Bài toán con: Tính chất cấu trúc con tối ưu giữ nguyên hoàn hảo.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \sqrt{N})$.
    *Độ phức tạp thời gian: $O(N \cdot \sqrt{N})$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 12
- dp[0] = 0
- dp[1] = 1 ($1^2$)
- ...
- dp[4] = min(dp[3]+1, dp[0]+1) = 1.
- ...
- dp[8] = min(dp[7]+1, dp[4]+1) = 2 ($4+4$).
- ...
- dp[12] = min(dp[11]+1, dp[8]+1, dp[3]+1) = dp[8]+1 = 3 ($4+4+4$).
Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DP is easiest to implement and understand. Math solution is $O(\sqrt{N})$ but "magic" to interviewers.
*DP dễ cài đặt và hiểu nhất. Giải pháp toán học nhanh hơn nhưng giống "ma thuật".*
---
*Mọi con số, dù lớn đến đâu, đều được xây dựng từ những viên gạch vuông vức hoàn hảo. Việc tìm kiếm cấu trúc tối ưu chính là nghệ thuật đơn giản hóa.*
Every number, no matter how large, is built from perfect square blocks. Finding the optimal structure is the art of simplification.
