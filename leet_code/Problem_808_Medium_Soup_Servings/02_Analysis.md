# Analysis for Soup Servings
# *Phân tích cho bài toán Phục vụ Súp*

## 1. Problem Essence & Scaling
## *1. Bản chất vấn đề & Quy đổi đơn vị*

### The Challenge
### *Thách thức*
We have two quantities $A, B$ and 4 operations that reduce them. Each operation happens with $p=0.25$.
The quantities can be as large as $10^9$. A direct DP or recursion will likely fail due to state space.
*Chúng ta có hai đại lượng A, B và 4 phép toán làm giảm chúng với xác suất 0.25. Đại lượng có thể lên tới $10^9$. DP trực tiếp sẽ thất bại vì không gian trạng thái quá lớn.*

### Scaling
### *Quy đổi*
Since all operations are multiples of 25, we can divide $n$ by 25.
Let $N = \lceil n / 25 \rceil$.
Operations become decreasing (A, B) by: (4,0), (3,1), (2,2), (1,3).
*Vì tất cả các phép toán là bội số của 25, ta có thể chia n cho 25. Các phép toán trở thành giảm (A, B) đi: (4,0), (3,1), (2,2), (1,3).*

### Critical Insight: Convergence to 1
### *Ý tưởng quan trọng: Sự hội tụ về 1*
Note that on average, operation 1-4 reduces A more than B.
Avg reduction for A: $(4+3+2+1)/4 = 2.5$.
Avg reduction for B: $(0+1+2+3)/4 = 1.5$.
Since A is consumed faster on average, as $n$ becomes very large, the probability that A finishes first approaches 1.
Through experimentation or analysis, if $n > 5000$ (approx), the result is extremely close to 1 within the required precision ($10^{-5}$).
*Trung bình, A bị tiêu thụ nhanh hơn B (2.5 so với 1.5). Khi n rất lớn, xác suất A hết trước hội tụ về 1. Nếu $n > 5000$, ta có thể trả về ngay 1.0.*

---

## 2. Strategy: DP with Memoization
## *2. Chiến lược: DP với Lưu nhớ (Memoization)*

### Algorithm
### *Thuật toán*

1.  **Normalization:** If $n > 5000$, return `1.0`.
2.  **Conversion:** $N = (n + 24) / 25$.
3.  **Recursive Function `solve(a, b)`:**
    - If $a \le 0$ and $b \le 0$: Return `0.5` (A and B finish together).
    - If $a \le 0$: Return `1.0` (A finishes first).
    - If $b \le 0$: Return `0` (B finishes first).
    - Look up `memo[a][b]`.
    - `res = 0.25 * (solve(a-4, b) + solve(a-3, b-1) + solve(a-2, b-2) + solve(a-1, b-3))`.
    - Store and return.
*1. Chuẩn hóa: Nếu n > 5000, trả về 1.0. 2. Chuyển đổi N. 3. Đệ quy có lưu nhớ: Tính xác suất dựa trên 4 trường hợp.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M^2)$ where $M = 5000/25 = 200$. Since we capped $n$.
    *   **Độ phức tạp thời gian:** $O(M^2)$, với $M \approx 200$ (khoảng $200^2$ trạng thái).*
*   **Space Complexity:** $O(M^2)$ to store results.
    *   **Độ phức tạp không gian:** $O(M^2)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `n = 50`
1. $N = 2$.
2. `solve(2, 2)`:
   - `0.25 * solve(-2, 2)` -> `0.25 * 1.0`
   - `0.25 * solve(-1, 1)` -> `0.25 * 1.0`
   - `0.25 * solve(0, 0)` -> `0.25 * 0.5`
   - `0.25 * solve(1, -1)` -> `0.25 * 0`
3. Sum: $0.25 + 0.25 + 0.125 + 0 = 0.625$.
**Result:** 0.625.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Use the threshold $n > 5000$ to avoid TLE and use memoization for smaller $n$.
*Sử dụng ngưỡng n > 5000 để tránh TLE và dùng đệ quy có lưu nhớ cho n nhỏ hơn.*
