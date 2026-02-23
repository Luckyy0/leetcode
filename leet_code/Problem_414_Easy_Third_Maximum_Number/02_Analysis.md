# Analysis for Third Maximum Number
# *Phân tích cho bài toán Số lớn thứ Ba*

## 1. Problem Essence & Multi-level Sorting
## *1. Bản chất vấn đề & Phân cấp Sắp xếp*

### The Challenge
### *Thách thức*
Identifying the 3rd largest distinct number. The complexity lies in handling duplicates and the case where fewer than 3 distinct numbers exist. Also, `Integer.MIN_VALUE` is a valid input, necessitating careful initialization.

### Strategy: Three Maximum Variables
### *Chiến lược: Ba biến cực đại*
1.  Maintain three variables: `max1`, `max2`, and `max3` initialized to `null` (using `Integer` wrapper) or a very small number like `Long.MIN_VALUE`.
2.  Iterate through the array:
    - If current `num` is equal to any of the three maxes, skip it (distinct requirement).
    - If `num > max1`:
        - Shift: `max3 = max2`, `max2 = max1`, `max1 = num`.
    - Else if `num > max2`:
        - Shift: `max3 = max2`, `max2 = num`.
    - Else if `num > max3`:
        - `max3 = num`.
3.  **Result:** If `max3` is still empty, return `max1`. Otherwise, return `max3`.

---

## 2. Approach: Single Pass Tracking
## *2. Hướng tiếp cận: Theo dõi trong một lần duyệt*

### Logic
### *Logic*
(See above). Using `Integer` wrappers and checking `null` is a clean way to handle the cases where `Integer.MIN_VALUE` might be one of the top 3 maxes.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Efficiency:** Single walk through the array.
    *Hiệu quả O(N): Duyệt qua mảng một lần.*
*   **Distinct Management:** Explicit comparison prevents duplicates from occupying multiple "max" spots.
    *Quản lý sự khác biệt: So sánh rõ ràng giúp ngăn các giá trị trùng lặp chiếm giữ nhiều vị trí cực đại.*

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

**Input:** `[2, 2, 3, 1]`
1. `num = 2`: `max1 = 2`.
2. `num = 2`: Exists. Skip.
3. `num = 3`: `3 > max1`. `max2 = 2, max1 = 3`.
4. `num = 1`: `1 < max2`. `max3 = 1`.
Result: `max3` exists, return 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Three-variable tracking with distinct checks.
*Theo dõi ba biến với kiểm tra giá trị khác biệt.*
---
*Đỉnh cao của thành công (max1) thường thu hút mọi sự chú ý, nhưng sự kiên định của những người đứng sau (max2, max3) mới thực sự tạo nên chiều sâu cho một cộng đồng. Bằng cách quan sát cẩn thận từng bậc thang giá trị và tôn trọng sự khác biệt (distinct), ta sẽ tìm thấy những nỗ lực thầm lặng (third maximum) mà nếu thiếu chúng, bức tranh tổng thể sẽ mất đi sự cân bằng.*
The peak of success (max1) often attracts all attention, but the persistence of those behind (max2, max3) truly creates depth for a community. By carefully observing each step of value and respecting difference (distinct), we will find the quiet efforts (third maximum) without which the overall picture would lose its balance.
