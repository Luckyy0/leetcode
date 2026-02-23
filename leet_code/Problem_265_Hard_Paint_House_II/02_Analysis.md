# Analysis for Paint House II
# *Phân tích cho bài toán Sơn nhà II*

## 1. Problem Essence & Optimization
## *1. Bản chất vấn đề & Tối ưu hóa*

### The Naive DP
### *DP ngây thơ*
`dp[i][c] = costs[i][c] + min(dp[i-1][color])` where `color != c`.
Finding `min` takes $O(K)$. Total complexity $O(N \cdot K^2)$.
With large $K$, checking all other colors is slow.

### Optimization Strategy
### *Chiến lược tối ưu hóa*
For house `i`, we only need the **minimum** cost from house `i-1` and the **second minimum** cost.
Why?
- If the minimum cost at `i-1` used color `A`:
    - For house `i`, if we pick color `B (!= A)`, we can use `min_cost`.
    - If we pick color `A`, we MUST use `second_min_cost`.
- We don't need to know exactly which color every other option used, just these two scalar values.

Logic:
For each row `i`:
1.  Find `min1` (smallest cost) and `min2` (second smallest cost) of row `i-1`.
2.  Also track `min1_color`.
3.  For each color `c` in row `i`:
    - If `c != min1_color`: `costs[i][c] += min1`.
    - If `c == min1_color`: `costs[i][c] += min2`.
4.  Repeat.

---

## 2. Approach: DP with Min Tracking
## *2. Hướng tiếp cận: DP với Theo dõi Min*

### Logic
### *Logic*
1.  Initialize `min1`, `min2`, `min1_color` for row `-1` (base case: 0 cost).
    - Actually, easier to modify input in-place starting from row 0.
2.  Iterate `i` from 0 to `n-1`:
    - Calculate `m1`, `m2`, `idx1` for current row `costs[i]` (after adding previous costs).
    - Wait, we need `prev_m1`, `prev_m2` from `i-1` to update `costs[i]`.
3.  Algorithm refined:
    - Pre-calculate min1, min2 for first row.
    - Loop `i` from 1 to `n`:
        - New `curr_m1`, `curr_m2`.
        - For each `k`:
            - cost = `costs[i][k] + (k == prev_idx1 ? prev_m2 : prev_prev_m1)`
            - Update `curr_m1`, `curr_m2`.
        - `prev` = `curr`.
    - Return `prev_m1`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Dimensionality Reduction:** Instead of looking at $K$ values, we compress state to just 2 values.
    *Giảm chiều dữ liệu: Thay vì nhìn vào K giá trị, ta nén trạng thái chỉ còn 2 giá trị.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot K)$.
    *Độ phức tạp thời gian: $O(N \cdot K)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1,5,3], [2,9,4]]`
1.  **Row 0:**
    - Vals: 1, 5, 3.
    - Min1: 1 (Index 0). Min2: 3.
2.  **Row 1:**
    - Col 0 (Cost 2): Conflict with Index 0? Yes. Add Min2 (3). Total 5.
    - Col 1 (Cost 9): No conflict. Add Min1 (1). Total 10.
    - Col 2 (Cost 4): No conflict. Add Min1 (1). Total 5.
    - Row 1 becomes: `[5, 10, 5]`.
    - New Min1: 5.

Result: 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Key observation: Conflict only happens with the absolute best choice. Second best is the backup.
*Quan sát chính: Xung đột chỉ xảy ra với lựa chọn tốt nhất. Tốt nhì là phương án dự phòng.*
---
*Luôn chuẩn bị Kế hoạch B (min2). Khi con đường tốt nhất bị chặn (conflict), sự khác biệt giữa thành công và thất bại nằm ở việc phương án dự phòng tốt đến mức nào.*
Always have a Plan B (min2). When the best path is blocked (conflict), the difference between success and failure lies in how good the backup is.
