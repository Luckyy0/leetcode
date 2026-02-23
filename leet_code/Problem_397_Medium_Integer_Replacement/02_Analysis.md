# Analysis for Integer Replacement
# *Phân tích cho bài toán Thay thế Số nguyên*

## 1. Problem Essence & Greedy Strategy
## *1. Bản chất vấn đề & Chiến lược Tham lam*

### The Challenge
### *Thách thức*
Finding the shortest path to 1. For even numbers, there's only one choice ($n/2$). The decision point is at odd numbers: should we choose $n+1$ or $n-1$?

### Strategy: Bit Analysis (Greedy)
### *Chiến lược: Phân tích Bit (Tham lam)*
The goal is to reach a number that can be divided by 2 as many times as possible (i.e., has many trailing zeros in binary).
1.  **If `n` is even:** $n >>= 1$.
2.  **If `n` is odd:**
    - Look at the last two bits:
        - If `n % 4 == 1` (binary ends in `01`): $n-1$ yields a number divisible by 4.
        - If `n % 4 == 3` (binary ends in `11`): $n+1$ yields a number divisible by at least 4.
    - **Special Case:** If $n = 3$, $n-1$ is better because it reaches 1 in 2 steps. ($3 \to 2 \to 1$). If we did $n+1$, it would take 3 steps ($3 \to 4 \to 2 \to 1$).

---

## 2. Approach: Iterative Greedy
## *2. Hướng tiếp cận: Tham lam Lặp*

### Logic
### *Logic*
(See above). We use `long` to avoid overflow when `n = 2^31 - 1` and we do `n + 1`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(log N) Complexity:** Every two steps at most, we divide the number by 2.
    *Hiệu quả O(log N): Cứ ít nhất hai bước, chúng ta lại chia số cho 2.*
*   **Optimal Result:** The greedy choice based on trailing zeros is proven to be optimal for this specific transformation rule.
    *Kết quả tối ưu: Lựa chọn tham lam dựa trên số lượng số 0 ở cuối đã được chứng minh là tối ưu.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$.
    *Độ phức tạp thời gian: $O(\log N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**n = 7 (Binary 0111)**
1. `rem 4 == 3`: $n \to n+1 = 8$. (Binary 1000). 1 step.
2. `even`: $8 \to 4$. 2 steps.
3. `even`: $4 \to 2$. 3 steps.
4. `even`: $2 \to 1$. 4 steps.
Result: 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Greedy bitwise approach ($n \% 4$ check).
*Tiếp cận tham lam bitwise (kiểm tra n % 4).*
---
*Mục tiêu tối thượng (1) đôi khi yêu cầu chúng ta phải đi đường vòng (n+1) thay vì chọn con đường có vẻ gần hơn (n-1). Bằng cách nhìn vào bản chất sâu xa của vấn đề (binary bits), ta có thể chọn ra bước đi sáng suốt nhất để rút ngắn hành trình đến đích.*
The ultimate goal (1) sometimes requires us to take a detour (n+1) instead of choosing the path that seems closer (n-1). By looking at the deep nature of the problem (binary bits), we can choose the most insightful step to shorten the journey to the destination.
