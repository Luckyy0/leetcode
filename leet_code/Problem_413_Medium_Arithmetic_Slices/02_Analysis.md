# Analysis for Arithmetic Slices
# *Phân tích cho bài toán Các mảng con Cấp số cộng*

## 1. Problem Essence & Local Arithmetic Discovery
## *1. Bản chất vấn đề & Tìm kiếm Cấp số cộng tại chỗ*

### The Challenge
### *Thách thức*
Counting all contiguous subarrays that form an arithmetic progression (AP). An AP is defined by a constant difference between consecutive terms.

### Strategy: Dynamic Programming / Iterative Counting
### *Chiến lược: Quy hoạch động / Đếm lặp*
1.  **Observation:** If `nums[i] - nums[i-1] == nums[i-1] - nums[i-2]`, then the element `nums[i]` extends any arithmetic slice that ended at `nums[i-1]`.
2.  **State:** Let `dp[i]` be the number of arithmetic slices ending exactly at index `i`.
3.  **Transition:**
    - If `nums[i] - nums[i-1] == nums[i-1] - nums[i-2]`:
        - `dp[i] = dp[i-1] + 1` (The `+1` is for the new 3-element slice `[i-2, i-1, i]`. The `dp[i-1]` part covers existing slices that were extended).
    - Else:
        - `dp[i] = 0`.
4.  **Result:** The total number of slices is the sum of all `dp[i]`.

---

## 2. Approach: Space-Optimized DP
## *2. Hướng tiếp cận: Quy hoạch động Tối ưu Không gian*

### Logic
### *Logic*
(See above). We only need the previous state `dp[i-1]`, so we can use a single variable `count` instead of a full array.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear pass through the array.
    *Hiệu quả O(N): Duyệt qua mảng một lần.*
*   **Constant Space:** Only basic variables needed.
    *Không gian hằng số: Chỉ cần các biến cơ bản.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of elements.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [1, 2, 3, 4, 5]`
1. `i = 2 (val 3)`: 3-2 == 2-1? Yes. `count = 1`. Total = 1.
2. `i = 3 (val 4)`: 4-3 == 3-2? Yes. `count = 1 + 1 = 2`. Total = 1 + 2 = 3.
3. `i = 4 (val 5)`: 5-4 == 4-3? Yes. `count = 2 + 1 = 3`. Total = 3 + 3 = 6.
Result: 6.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Iterative counting of extensions.
*Đếm lặp các phần mở rộng.*
---
*Cấp số cộng (arithmetic progression) là sự liên tục của những bước đi đều đặn. Trong một dãy số, khi ta nhận ra sự nhịp nhàng đã được thiết lập (constant difference), mỗi bước đi tiếp theo không chỉ tạo thêm một nhịp mới mà còn kéo dài mọi sự kết nối đã tồn tại trước đó. Sự tích lũy (total sum) chính là thước đo cho sự hài hòa bền bỉ.*
Arithmetic progression is the continuity of steady steps. In a sequence, when we recognize that rhythm has been established (constant difference), each next step not only creates a new beat but also extends all previously existing connections. Accumulation (total sum) is the measure of persistent harmony.
