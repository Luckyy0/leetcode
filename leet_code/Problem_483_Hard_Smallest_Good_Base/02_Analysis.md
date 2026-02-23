# Analysis for Smallest Good Base
# *Phân tích cho bài toán Cơ số Tốt Nhỏ nhất*

## 1. Problem Essence & Geometric Series
## *1. Bản chất vấn đề & Cấp số nhân*

### The Challenge
### *Thách thức*
Finding minimal $k \ge 2$ such that $n = 1 + k + k^2 + ... + k^m$ for some integer $m \ge 1$.
- This formula is summing a geometric progression: $n = \frac{k^{m+1} - 1}{k - 1}$.

### Strategy: Iterate Length $m$
### *Chiến lược: Duyệt Độ dài $m$*

1.  **Bounds:**
    - Since $n \le 10^{18}$, $m$ can range from 1 to $\approx \log_2(10^{18}) \approx 60$.
    - $m=1$ means $n = 1 + k \implies k = n-1$. This is always a solution (base $n-1$ gives `11`). Since we want the **smallest** base, we prefer **larger** $m$. (Higher $m$ means $k$ is smaller).
2.  **Algorithm:**
    - Iterate $m$ from max possible ($\approx 60$) down to 2.
    - For a fixed $m$, we want to find $k$ such that $(k^{m+1}-1)/(k-1) = n$.
    - Note that $k \approx n^{1/m}$. We can use binary search or simple math roots to find candidate $k$.
    - Since $f(k) = \sum_{i=0}^m k^i$ is monotonic increasing, there is at most one integer $k$ for a given $m$.
    - Use binary search for $k$ in range $[2, n^{1/m}]$. Or just compute `k = (long) Math.pow(n, 1.0/m)` and check if it fits exactly.
3.  **Check:**
    - Calculate $val = \sum_{i=0}^m k^i$. Be careful of overflow.
    - If `val == n`, then $k$ is a good base. Return `k` immediately (because we iterate $m$ downwards, first valid $k$ corresponds to largest $m$, hence smallest $k$).

---

## 2. Approach: Binary Search for k
## *2. Hướng tiếp cận: Tìm kiếm nhị phân cho k*

### Logic
### *Logic*
(See above). The loop for $m$ is small (60). For each $m$, binary search takes $\log(n)$. Total complexity $O(\log^2 n)$.
Since we need `smallest` base, and $k$ decreases as $m$ increases, we start $m$ from max (62) down to 2. If no solution found for $m \ge 2$, return `n-1` (corresponding to $m=1$).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Bounded Search Space:** $m$ is very small.
    *Không gian tìm kiếm bị giới hạn: m rất nhỏ.*
*   **Monotonicity:** Function of $k$ allows binary search.
    *Tính đơn điệu: Hàm số theo k cho phép tìm kiếm nhị phân.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log n \cdot \log n)$ (Outer loop $\log n$, inner BS $\log n$). Or $O(\log n)$ if using `pow` approximation.
    *Độ phức tạp thời gian: $O(\log^2 n)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `n = 13`
1. Max $m \approx \log_2(13) = 3$.
2. Try $m=3$: Equation $1 + k + k^2 + k^3 = 13$.
   - $k \approx 13^{1/3} \approx 2$.
   - Check $k=2$: $1+2+4+8 = 15 > 13$. Too big.
3. Try $m=2$: Equation $1 + k + k^2 = 13$.
   - $k \approx 13^{1/2} \approx 3$.
   - Check $k=3$: $1+3+9 = 13$. Match!
   - Return "3".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterate $m$ from 60 down to 2, binary search for $k$.
*Duyệt $m$ từ 60 xuống 2, tìm kiếm nhị phân cho $k$.*
---
*Số hiệu tốt (good base) cũng giống như một góc nhìn đúng đắn. Cùng một thực thể (số n), nhưng nếu chọn sai hệ quy chiếu, nó trở nên phức tạp và khó hiểu. Nếu chọn đúng góc nhìn (hệ cơ số), mọi thứ trở nên đồng nhất và đơn giản tuyệt đối (toàn số 1). Việc tìm kiếm này đòi hỏi sự kiên nhẫn thử nghiệm từ những khả năng phức tạp nhất (m lớn) cho đến những điều hiển nhiên (n-1).*
A good number (Good Base) is like a right perspective. The same entity (number N), but if you choose the wrong reference system, it becomes complicated and difficult to understand. If choosing the right perspective (co -basis system), everything becomes absolutely uniform and simple (all 1). This search requires patience testing from the most complex capabilities (large M) to the obvious things (N-1).
