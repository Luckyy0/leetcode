# Analysis for House Robber
# *Phân tích cho bài toán Kẻ trộm nhà*

## 1. Problem Essence & Decision Making
## *1. Bản chất vấn đề & Ra quyết định*

### The Choice
### *Sự lựa chọn*
At every house `i`, we have two choices:
1.  **Rob it:** If we rob house `i`, we get `nums[i]`, but we CANNOT rob house `i-1`. Our total profit comes from `nums[i] + max_profit_at(i-2)`.
2.  **Skip it:** If we skip house `i`, our profit is the same as the maximum profit at house `i-1`.
*Tại mỗi ngôi nhà `i`, chúng ta có hai lựa chọn: 1. Trộm: Chúng ta nhận `nums[i]` nhưng không được trộm nhà `i-1`. Tổng lợi nhuận là `nums[i] + max_profit_at(i-2)`. 2. Bỏ qua: Lợi nhuận bằng với lợi nhuận tối đa tại nhà `i-1`.*

We want to maximize the outcome of these two choices.
*Chúng ta muốn tối đa hóa kết quả của hai lựa chọn này.*

---

## 2. Approach: Dynamic Programming
## *2. Hướng tiếp cận: Quy hoạch động*

### Recurrence Relation
### *Hệ thức truy hồi*
Let `dp[i]` be the maximum money we can rob from the first `i` houses (index 0 to i).
$$dp[i] = \max(dp[i-1], dp[i-2] + nums[i])$$
*Gọi `dp[i]` là số tiền tối đa có thể trộm từ `i` ngôi nhà đầu tiên. Công thức: `max(bỏ_qua_i, chọn_i + kết_quả_của_i-2)`.*

### Space Optimization
### *Tối ưu hóa không gian*
Notice that to calculate `dp[i]`, we only need `dp[i-1]` and `dp[i-2]`. We don't need the entire array.
We can simply maintain two variables:
- `prev2` (representing `dp[i-2]`)
- `prev1` (representing `dp[i-1]`)
And compute `current` (representing `dp[i]`).
*Để tính `dp[i]`, chúng ta chỉ cần hai trạng thái trước đó. Vì vậy, ta có thể tối ưu bộ nhớ $O(N)$ xuống $O(1)$.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Linear Scan:** We solve the problem in a single pass $O(N)$.
    *Quét tuyến tính: Giải quyết bài toán trong một lần duyệt.*
*   **Optimal Substructure:** The problem naturally breaks down into smaller, independent sub-problems, fulfilling the core requirement of Dynamic Programming.
    *Cấu trúc con tối ưu: Bài toán tự nhiên chia nhỏ thành các bài toán con độc lập.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Visit each house once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (Optimized) or $O(N)$ (Unoptimized).
    *Độ phức tạp không gian: $O(1)$ (Đã tối ưu).*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[2, 7, 9, 3, 1]`

1.  **Init:** `prev2 = 0`, `prev1 = 0`.
2.  **House 0 (2):** `cur = max(0, 0 + 2) = 2`. -> `prev2=0, prev1=2`.
3.  **House 1 (7):** `cur = max(2, 0 + 7) = 7`. -> `prev2=2, prev1=7`.
4.  **House 2 (9):** `cur = max(7, 2 + 9) = 11`. -> `prev2=7, prev1=11`.
5.  **House 3 (3):** `cur = max(11, 7 + 3) = 11`. -> `prev2=11, prev1=11`. (Better to keep previous max than stealing 3).
6.  **House 4 (1):** `cur = max(11, 11 + 1) = 12`. -> `prev2=11, prev1=12`.

**Result:** 12.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

House Robber is the "Hello World" of 1D Dynamic Programming. It teaches the fundamental concept of making a binary choice (Include/Exclude) at each step to build a global optimum. Mastering this problem opens the door to harder variants like "House Robber II" (Cyclic) and "House Robber III" (Tree).
*Kẻ trộm nhà là bài nhập môn "Hello World" của Quy hoạch động 1 chiều. Nó dạy khái niệm cơ bản về việc đưa ra lựa chọn nhị phân (Bao gồm/Loại trừ) tại mỗi bước. Thành thạo bài này sẽ mở ra cánh cửa cho các biến thể khó hơn như "Kẻ trộm nhà II" (Vòng tròn) và "Kẻ trộm nhà III" (Cây).*
---
*Đôi khi bước lùi (bỏ qua một ngôi nhà) lại là sự chuẩn bị cần thiết cho một bước tiến dài hơn về lợi nhuận.*
Sometimes stepping back (skipping a house) is the necessary preparation for a longer leap in profit.
