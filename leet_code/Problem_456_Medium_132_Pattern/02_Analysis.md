# Analysis for 132 Pattern
# *Phân tích cho bài toán Mẫu hình 132*

## 1. Problem Essence & Relative Ordering
## *1. Bản chất vấn đề & Thứ tự Tương đối*

### The Challenge
### *Thách thức*
Finding a subsequence $(i, j, k)$ with $i < j < k$ such that $nums[i] < nums[k] < nums[j]$. 
- `nums[j]` is the largest (the "3").
- `nums[k]` is the second largest (the "2").
- `nums[i]` is the smallest (the "1").

### Strategy: Backward Monotonic Stack
### *Chiến lược: Ngăn xếp Đơn điệu Ngược*

1.  **Objective:** We want to find a potential `nums[k]` (the "2") which has a larger `nums[j]` (the "3") to its left, and then check for an even smaller `nums[i]` (the "1") even further left.
2.  **Tracking "2":** Let's maintain a variable `ak` representing the largest possible value for `nums[k]` that we have found so far that has a larger `nums[j]` to its left.
3.  **Monotonic Stack:**
    - Iterate through the array from **right to left**.
    - If `nums[i] < ak`, we have found our "1", "3", "2" pattern. Return `true`.
    - Otherwise, while `nums[i] > stack.top()`, pop the top and update `ak` to that popped value. (The popped value becomes the new "2", and current `nums[i]` is potentially the "3").
    - Push `nums[i]` onto the stack.

---

## 2. Approach: Optimal Filtering
## *2. Hướng tiếp cận: Lọc Tối ưu*

### Logic
### *Logic*
(See above). By going backward, the stack stores potential `nums[j]` values. When we pop a smaller value from the stack because the current `nums[i]` is larger, that popped value becomes a viable `nums[k]` (the "2") because it is to the right of the current `nums[j]` (the "3").

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Single pass with stack operations.
    *Hiệu quả O(N): Duyệt một lần kết hợp các thao tác ngăn xếp.*
*   **Logical Rigor:** Guarantees that at any point `ak` is effectively the largest value to the right of some larger value.
    *Sự chặt chẽ logic: Đảm bảo tại mọi điểm ak là giá trị lớn nhất nằm bên phải của một giá trị còn lớn hơn thế.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, each element is pushed and popped at most once.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(N)$ for the stack.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [3, 1, 4, 2]`
1. `ak = -inf, stack = []`.
2. `i = 3 (2)`: `stack = [2]`.
3. `i = 2 (4)`: `4 > 2`. Pop `2`, `ak = 2`. `stack = [4]`.
4. `i = 1 (1)`: `1 < ak(2)`. **MATCH FOUND!** (1 < 2 < 4).
Result: `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Backward traversal with a monotonic stack to track the "2" value.
*Duyệt ngược với ngăn xếp đơn điệu để theo dõi giá trị "2".*
---
*Cuộc đời không phải lúc nào cũng là một biểu đồ đi lên hay đi xuống đơn điệu. Đôi khi, một mẫu hình nhấp nhô (132 pattern) — vươn tới đỉnh cao (3) rồi lùi lại một bước (2) trước khi bắt đầu từ khởi điểm thấp nhất (1) — mới là điều ta tìm kiếm. Bằng cách quan sát từ tương lai về quá khứ (backward), ta có thể nhận diện được những nấc thang của cơ hội.*
Life is not always a monotone up or down chart. Sometimes, a undulating pattern (132 pattern) — reaching the peak (3) and then take a step back (2) before starting from the lowest starting point (1) — is what we look for. By observing from the future to the past (backward), we can identify the ladders of opportunity.
