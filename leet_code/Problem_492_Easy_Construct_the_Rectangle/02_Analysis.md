# Analysis for Construct the Rectangle
# *Phân tích cho bài toán Xây dựng Hình chữ nhật*

## 1. Problem Essence & Closest Factors
## *1. Bản chất vấn đề & Thừa số Gần nhất*

### The Challenge
### *Thách thức*
Finding two integers $L, W$ such that $L \times W = \text{area}$, $L \ge W$, and $L - W$ is minimized. Minimizing the difference implies maximizing $W$ (since $W$ is bounded by $\sqrt{\text{area}}$).

### Strategy: Search from Square Root Downwards
### *Chiến lược: Tìm kiếm từ Căn bậc hai xuống*

1.  **Start:** Initialize $W = \lfloor\sqrt{\text{area}}\rfloor$.
2.  **Iterate:** Check if `area % W == 0`.
    - If yes, `L = area / W`. Since we started from $\sqrt{\text{area}}$ and go down, this is the largest possible $W \le \sqrt{\text{area}}$, ensuring $L \ge W$ and smallest difference. Return `[L, W]`.
    - If no, decrement $W$.
3.  **Termination:** Since $W=1$ always works, loop terminates guaranteed.

---

## 2. Approach: Math
## *2. Hướng tiếp cận: Toán học*

### Logic
### *Logic*
(See above). The first factor we find going downwards from $\sqrt{\text{area}}$ is the optimal width.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Start:** Starting near the square root is the most efficient way to minimize $L-W$.
    *Khởi đầu tối ưu: Bắt đầu gần căn bậc hai là cách hiệu quả nhất để giảm thiểu L-W.*
*   **Simple Logic:** No complex algorithms needed.
    *Logic đơn giản: Không cần thuật toán phức tạp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sqrt{N})$. In worst case (prime number), we iterate down to 1.
    *Độ phức tạp thời gian: $O(\sqrt{N})$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `area = 12`
1. $\sqrt{12} \approx 3$. Try $W=3$.
2. $12 \% 3 == 0$. Yes.
3. $L = 4$.
Result: `[4, 3]`.

**Input:** `area = 37`
1. $\sqrt{37} \approx 6$.
2. `37 % 6 != 0`. $W=5$... no. $W=4$... no... $W=1$.
Result: `[37, 1]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Start search for Width at `sqrt(area)` and decrement.
*Bắt đầu tìm kiếm Chiều rộng tại `sqrt(area)` và giảm dần.*
---
*Sự cân đối hoàn hảo luôn nằm ở điểm giữa (square root). Để tìm ra một hình chữ nhật hài hòa nhất (minimal difference), ta không nên bắt đầu từ những cực đoan (1 vs Area), mà hãy bắt đầu từ sự cân bằng lý tưởng rồi từ đó điều chỉnh dần. Giải pháp tối ưu thường nằm ngay sát ranh giới của sự hoàn hảo.*
Perfect balance is always in the middle (Square Root). To find the most harmonious rectangle (minimal difference), we should not start from extremes (1 vs Area), but start from the ideal balance and then adjust gradually. The optimal solution is usually right close to the boundary of perfection.
