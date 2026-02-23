# Analysis for Ones and Zeroes
# *Phân tích cho bài toán Số Một và Số Không*

## 1. Problem Essence & Multi-dimensional Knapsack
## *1. Bản chất vấn đề & Bài toán Cái túi Đa chiều*

### The Challenge
### *Thách thức*
Picking the maximum number of items (strings) such that the total cost of `0`s doesn't exceed `m` and `1`s doesn't exceed `n`. This is exactly the **0/1 Knapsack Problem**, but with **two** weight dimensions (count of 0s, count of 1s).

### Strategy: 2D Dynamic Programming
### *Chiến lược: Quy hoạch động 2 Chiều*

1.  **State Definition:** `dp[i][j]` represents the max number of strings we can pick with at most `i` zeros and `j` ones.
2.  **Transition:** 
    - For each string `s` in `strs`:
        - Count its zeros (`zeros`) and ones (`ones`).
        - Update the DP table: `dp[i][j] = max(dp[i][j], 1 + dp[i - zeros][j - ones])`.
        - The update must be done **backwards** (from `m` down to `zeros`, `n` down to `ones`) to avoid reusing the same string multiple times in one step (standard knapsack space optimization).
3.  **Initialization:** `dp[0][0] = 0`, all others effectively 0 (since we maximize).

---

## 2. Approach: Iterative DP
## *2. Hướng tiếp cận: DP Lặp*

### Logic
### *Logic*
(See above). The outer loop iterates through available items. Inner loops iterate through capacities.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Space Optimization:** Reduces 3D DP (`dp[k][i][j]` where k is index in strs) to 2D `dp[i][j]`.
    *Tối ưu hóa không gian: Giảm DP 3 chiều xuống 2 chiều.*
*   **Simplicity:** Standard template for knapsack problems adapted for extra dimension.
    *Sự đơn giản: Mẫu chuẩn cho bài toán cái túi được điều chỉnh cho thêm một chiều.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(L \cdot m \cdot n)$, where $L$ is `strs.length`. With constraints $600 \cdot 100 \cdot 100 \approx 6 \times 10^6$, perfectly feasible.
    *Độ phức tạp thời gian: $O(L \cdot m \cdot n)$.*
*   **Space Complexity:** $O(m \cdot n)$.
    *Độ phức tạp không gian: $O(m \cdot n)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["10", "1"], m=1, n=1`
1. `dp` size `[2][2]` (indices 0..1), init 0.
2. String `"10"`: zeros=1, ones=1.
   - Update `dp[1][1]`: `max(0, 1 + dp[0][0])` = 1.
3. String `"1"`: zeros=0, ones=1.
   - Update `dp[1][1]`: `max(1, 1 + dp[1][0])` = 1? No. Wait. `dp[1][0]` was 0?
   - Let's check `dp[1][0]`. For "10", `i=1, j=0`: `1-1=0, 0-1=-1` (invalid). Unchanged.
   - For "1" update `dp[1][1]`:
     - `prev_dp[1][0]` (from "10" step) was 0? No, `dp[1][0]` wasn't updated by "10".
     - Actually:
       - Process "10": `dp[1][1]=1`.
       - Process "1":
         - `dp[1][1] = max(1, 1 + dp[1][0])` (dp[1][0] is 0) -> 1.
         - `dp[0][1] = max(0, 1 + dp[0][0])` -> 1.
Result: `dp[m][n]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

2D Knapsack DP iterating backwards.
*Quy hoạch động Cái túi 2 chiều duyệt ngược.*
---
*Cuộc sống là một bài toán tối ưu hóa với nhiều ràng buộc (multi-dimensional constraints). Ta không chỉ giới hạn bởi tiền bạc (zeros), mà còn bởi thời gian (ones). Để đạt được nhiều thành tựu nhất (max subset), ta phải cân nhắc cái giá của mỗi lựa chọn xem nó tiêu tốn bao nhiêu nguồn lực kép này. Quy hoạch từng bước một, thận trọng lùi lại để nhìn nhận (backwards iteration), giúp ta không bao giờ tham lam quá mức cho một lựa chọn duy nhất.*
Life is an optimization problem with many constraints (multi-dimensional constraints). We are not only limited by money (zeros), but also by time (ones). To achieve the most achievements (max subset), we must consider the price of each choice to see how much of this double resource it consumes. Planning step by step, carefully stepping back to perceive (Backwards iteration), helps us never be excessive greedy for a single choice.
