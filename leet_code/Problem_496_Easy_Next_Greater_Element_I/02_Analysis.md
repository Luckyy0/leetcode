# Analysis for Next Greater Element I
# *Phân tích cho bài toán Phần tử Lớn hơn Tiếp theo I*

## 1. Problem Essence & Monotonic Stack
## *1. Bản chất vấn đề & Ngăn xếp Đơn điệu*

### The Challenge
### *Thách thức*
Finding the next greater element for a subset of numbers. Brute force is $O(N \cdot M)$. We want $O(N+M)$.

### Strategy: Monotonic Decreasing Stack
### *Chiến lược: Ngăn xếp Giảm dần Đơn điệu*

1.  **Pre-process `nums2`:** We can find the "next greater element" for *all* elements in `nums2` in a single pass using a stack.
2.  **Stack Logic:**
    - Iterate `num` in `nums2`.
    - While the stack is not empty and `stack.peek() < num`:
        - The element `stack.pop()` has found its next greater element: `num`.
        - Map `pop()` $\to$ `num`.
    - Push `num` onto stack.
3.  **Result Construction:** iterate `nums1`, look up the result in the map.

---

## 2. Approach: Stack + HashMap
## *2. Hướng tiếp cận: Ngăn xếp + HashMap*

### Logic
### *Logic*
(See above). The stack maintains elements we haven't found a greater element for yet. When we see a larger number, it resolves the "next greater" query for the smaller elements on top of the stack.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Preprocessing:** Efficiently solves the problem for the superset.
    *Tiền xử lý O(N): Giải quyết hiệu quả vấn đề cho tập siêu.*
*   **O(1) Lookup:** HashMap allows instant retrieval for queries.
    *Tra cứu O(1): HashMap cho phép truy xuất tức thì cho các truy vấn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + M)$ relating to lengths of `nums1` and `nums2`.
    *Độ phức tạp thời gian: $O(N + M)$.*
*   **Space Complexity:** $O(N)$ for stack and map.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums2 = [1, 3, 4, 2]`
1. Stack `[]`. Map `{}`.
2. `1`: Push `1`. Stack `[1]`.
3. `3`: `3 > 1`. Pop `1`. Map `{1: 3}`. Push `3`. Stack `[3]`.
4. `4`: `4 > 3`. Pop `3`. Map `{1: 3, 3: 4}`. Push `4`. Stack `[4]`.
5. `2`: `2 < 4`. Push `2`. Stack `[4, 2]`.
6. End loop. Map has `{1: 3, 3: 4}`.
Query `nums1`: `[4, 1, 2]`.
- `4`: Not in map -> -1.
- `1`: In map -> 3.
- `2`: Not in map -> -1.
Result: `[-1, 3, -1]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Monotonic stack to pre-calculate next greater map.
*Ngăn xếp đơn điệu để tính trước bản đồ phần tử lớn hơn tiếp theo.*
---
*Ai cũng đang chờ đợi một cơ hội lớn hơn (next greater). Thay vì tìm kiếm ngẫu nhiên, ta hãy kiên nhẫn tích lũy (stack) những giá trị hiện tại. Khi cơ hội thực sự (larger number) xuất hiện, nó sẽ giải phóng tất cả những tiềm năng đang chờ đợi (pop stack), chắp cánh cho những ước mơ nhỏ bé vươn lên tầm cao mới.*
Everyone is waiting for a greater opportunity (Next Greater). Instead of searching randomly, let's patiently verify the current values (Stack). When the real opportunity (Larger Number) appears, it will release all the waiting potential (POP Stack), giving wings to small dreams to reach new heights.
