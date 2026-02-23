# Analysis for Range Addition
# *Phân tích cho bài toán Cộng dồn Khoảng*

## 1. Problem Essence & Difference Array
## *1. Bản chất vấn đề & Mảng Hiệu (Difference Array)*

### The Challenge
### *Thách thức*
Performing range updates $[start, end] += inc$ many times.
A naive approach would take $O(K \times N)$ where $K$ is number of updates.
We need a way to apply updates efficiently, ideally $O(K + N)$.

### Strategy: Difference Array (Prefix Sum Trick)
### *Chiến lược: Mảng Hiệu (Mẹo Tổng tiền tố)*
Instead of updating every element in the range, we only update the **boundaries**.
1.  For an update `[start, end, inc]`:
    - `arr[start] += inc`
    - If `end + 1 < length`, `arr[end + 1] -= inc`
2.  After all updates, the final value of each element is the **prefix sum** of the boundary-updated array.
    - $arr[i] = \sum_{j=0}^{i} arr_{diff}[j]$.

---

## 2. Approach: Boundary Updates + Prefix Sum
## *2. Hướng tiếp cận: Cập nhật Biên + Tổng tiền tố*

### Logic
### *Logic*
(See Strategy above). This technique is a fundamental optimization for range queries/updates.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(K + N) Efficiency:** The most optimal time complexity for this problem.
    *Hiệu quả O(K + N): Độ phức tạp thời gian tối ưu nhất cho bài toán này.*
*   **Simplicity:** Minimal logic, no complex data structures like Segment Trees needed.
    *Đơn giản: Logic tối giản, không cần cấu trúc phức tạp như Cây phân khúc.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(K + N)$ where $K$ is number of updates and $N$ is array length.
    *Độ phức tạp thời gian: $O(K + N)$.*
*   **Space Complexity:** $O(N)$ for the result array.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `L=5, updates = [[1,3,2]]`
1. Difference Array (init 0): `[0, 2, 0, 0, -2]` (inc at index 1, dec at index 3+1=4).
2. Prefix Sum calculation:
   - `i=0`: 0.
   - `i=1`: 0 + 2 = 2.
   - `i=2`: 2 + 0 = 2.
   - `i=3`: 2 + 0 = 2.
   - `i=4`: 2 + (-2) = 0.
Result: `[0, 2, 2, 2, 0]`. Correct.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Difference Array technique.
*Kỹ thuật Mảng Hiệu.*
---
*Mỗi lệnh cập nhật (update) thực chất chỉ là một sự thay đổi biên độ (boundary change). Thay vì tác động lên từng cá nhân (elements), hãy thay đổi quy luật tại điểm bắt đầu và điểm kết thúc, kết quả cuối cùng (prefix sum) sẽ tự động được lan tỏa đến tất cả.*
Each update is actually just a change in boundary. Instead of affecting each individual (elements), change the rules at the beginning and the end, and the final result (prefix sum) will automatically spread to everyone.
