# Analysis for Paint House
# *Phân tích cho bài toán Sơn nhà*

## 1. Problem Essence & Dynamic Programming
## *1. Bản chất vấn đề & Quy hoạch động*

### The Choice
### *Sự lựa chọn*
For house `i`, we can pick Red, Blue, or Green.
If we pick Red for `i`, house `i-1` MUST be Blue or Green.
This dependency suggests Dynamic Programming.

### State Definition
### *Định nghĩa trạng thái*
`dp[i][color]` = Minimum cost to paint houses `0...i` ending with house `i` painted `color`.
Colors: 0 (Red), 1 (Blue), 2 (Green).

### Recurrence Relation
### *Công thức truy hồi*
- `dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2])`
- `dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2])`
- `dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1])`

Result: `min(dp[n-1][0], dp[n-1][1], dp[n-1][2])`.

---

## 2. Approach: In-Place DP (Optimization)
## *2. Hướng tiếp cận: DP tại chỗ (Tối ưu hóa)*

### Logic
### *Logic*
We only need the previous row `i-1` to calculate row `i`.
We can modify the `costs` matrix directly or use 3 simple variables.
Modifying input is space $O(1)$ (extra).

Algorithm:
Loop `i` from 1 to `n-1`:
- `costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);`
- `costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);`
- `costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);`
Return min of last row.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **No History:** Decisions purely local to `i` and `i-1`.
    *Không có lịch sử: Quyết định hoàn toàn cục bộ giữa i và i-1.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ (specifically $3N$).
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ if modifying input, or $O(N)$/$O(3)$ normally.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[17,2,17], [16,16,5], [14,3,19]]`

1.  **Row 1 (House 1):**
    - Red (`16`): `16 + min(2, 17) = 18`.
    - Blue (`16`): `16 + min(17, 17) = 33`.
    - Green (`5`): `5 + min(17, 2) = 7`.
    - Costs now: `[[17,2,17], [18,33,7], [14,3,19]]`.

2.  **Row 2 (House 2):**
    - Red (`14`): `14 + min(33, 7) = 21`.
    - Blue (`3`): `3 + min(18, 7) = 10`.
    - Green (`19`): `19 + min(18, 33) = 37`.
    - Costs now: `[..., [21, 10, 37]]`.

Result: `min(21, 10, 37) = 10`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic strict dependency DP.
*DP phụ thuộc nghiêm ngặt kinh điển.*
---
*Màu sắc của hiện tại không được trùng lặp với quá khứ. Sự thay đổi liên tục tạo nên bức tranh (ngôi nhà) đẹp nhất với chi phí tối ưu.*
The color of the present must not clash with the past. Constant change creates the most beautiful picture (house) at optimal cost.
