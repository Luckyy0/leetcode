# Analysis for Fibonacci Number
# *Phân tích cho bài toán Số Fibonacci*

## 1. Problem Essence & Recurrence
## *1. Bản chất vấn đề & Truy hồi*

### The Challenge
### *Thách thức*
Computing $F(n)$.
- Recursive definition leads to exponential time $O(2^N)$ if unoptimized.
- DP or Iterative approach gives $O(N)$.
- Matrix Exponentiation gives $O(\log N)$.
- Given $N \le 30$, $O(N)$ is practically instantaneous.

### Strategy: Iterative Optimization
### *Chiến lược: Tối ưu Lặp*

1.  **Iterative:** Maintain two variables `a` (representing $F(i-2)$) and `b` (representing $F(i-1)$). Update them.
2.  **Base Cases:** $F(0)=0, F(1)=1$.

---

## 2. Approach: Iterative
## *2. Hướng tiếp cận: Lặp*

### Logic
### *Logic*
(See above). Loop from 2 to N.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Memory:** No array needed, just two vars.
    *Bộ nhớ O(1): Không cần mảng, chỉ cần 2 biến.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `3`
1. `a=0, b=1`.
2. $i=2$: `sum = 1`. `a=1, b=1`.
3. $i=3$: `sum = 2`. `a=1, b=2`.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterative loop.
*Vòng lặp.*
---
*Một bước tiến nhỏ hôm nay (Iterative Step) cộng hưởng với thành quả của hôm qua (Previous Value) sẽ tạo nên tương lai (Next Value). Không có đường tắt (Recursion) nào bền vững bằng việc từng bước xây dựng nền móng chắc chắn.*
A small step today (Iterative Step) resonates with the results of yesterday (Previous Value) will create the future (Next Value). There is no shortcut (recursion) as sustainable as step by step building a solid foundation.
