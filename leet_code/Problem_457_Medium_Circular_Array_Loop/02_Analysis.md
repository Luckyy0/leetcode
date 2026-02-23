# Analysis for Circular Array Loop
# *Phân tích cho bài toán Vòng lặp Mảng Vòng*

## 1. Problem Essence & Cycle Detection Constraints
## *1. Bản chất vấn đề & Ràng buộc Phát hiện Chu kỳ*

### The Challenge
### *Thách thức*
Detecting a cycle in a circular array move-set.
- **Constraints:**
    1.  Cycle length must be $> 1$.
    2.  Cycle must be uni-directional (all positive or all negative).

### Strategy: Fast and Slow Pointers (Floyd's Cycle-Finding)
### *Chiến lược: Con trỏ Nhanh và Chậm (Floyd's Cycle-Finding)*

1.  **Iterate through each starting position:** Many indices might not lead to a valid cycle.
2.  **Pointer Movement:**
    - `slow` moves 1 step.
    - `fast` moves 2 steps.
3.  **Validation during movement:**
    - Ensure direction is consistent with the starting direction (e.g., if `nums[start] > 0`, all visited `nums[i]` must be `> 0`).
    - If direction flips or we hit a "cycle of length 1" (`next(i) == i`), terminate the current search.
4.  **Cycle Found:** If `slow == fast` and not a length-1 cycle, return `true`.
5.  **Optimization:** Mark visited nodes with `0` (or another special value) to avoid re-calculating paths that we already know don't lead to a cycle.

---

## 2. Approach: Graph Traversal Logic
## *2. Hướng tiếp cận: Logic Duyệt đồ thị*

### Logic
### *Logic*
(See above). The `next(i)` function is `(i + nums[i] % n + n) % n`. We must ensure the direction remains consistent by checking `nums[curr] * nums[next] > 0`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Marking visited nodes ensures we don't repeat work. In a graph where each node has exactly one outgoing edge, we visit each node a constant number of times.
    *Hiệu quả O(N): Đánh dấu các nút đã truy cập đảm bảo không lặp lại công việc. Trong mảng này, mỗi nút có đúng một cạnh ra.*
*   **Constant Space:** Only a few pointers needed.
    *Không gian hằng số: Chỉ cần một số con trỏ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is length of `nums`.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ additional space (modifying in-place or using a few variables).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [2, -1, 1, 2, 2]`
1. Start at index 0 (positive).
   - Slow: 0. Fast: 0.
   - Slow moves to `(0+2)=2`.
   - Fast moves to `(0+2)=2` then `(2+1)=3`.
   - ... eventually they meet at index 0 or 2 or 3.
   - Direction checked: `nums[0, 2, 3]` are all positive. Valid.
Result: `true`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Fast and Slow pointers with direction-consistency checks.
*Con trỏ Nhanh và Chậm kết hợp kiểm tra tính nhất quán về hướng.*
---
*Vòng lặp cuộc đời (circular array loop) chỉ thực sự có ý nghĩa khi ta tiến về phía trước một cách nhất quán (uni-directional). Nếu ta cứ thay đổi phương hướng (direction change) hay chỉ quẩn quanh tại chỗ (length-1 cycle), ta sẽ không bao giờ tạo nên một vòng chuyển động thực thụ. Bằng cách sử dụng hai nhịp độ khác nhau (fast/slow pointers), ta có thể nhận diện được điểm giao thoa của định mệnh.*
Nature loop (Circular Array Loop) only truly meaningful when we move forward consistently (UNI-Directional). If we change directions (Direction Change) or just go around in place (Length-1 cycle), we will never create a real motion. By using two different tempos (Fast/Slow Pointers), we can identify the intersection of fate.
