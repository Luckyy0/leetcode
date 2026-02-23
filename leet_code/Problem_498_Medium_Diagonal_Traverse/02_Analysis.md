# Analysis for Diagonal Traverse
# *Phân tích cho bài toán Duyệt Chéo*

## 1. Problem Essence & Index Sum
## *1. Bản chất vấn đề & Tổng chỉ số*

### The Challenge
### *Thách thức*
Traversing a matrix diagonally.
- Diagonals are defined by `i + j == constant`.
- Direction flips every time: Up-Right then Down-Left.

### Strategy: Simulation or Sorting by Sum
### *Chiến lược: Mô phỏng hoặc Sắp xếp theo Tổng*

1.  **Index Sum Property:**
    - Elements on the same diagonal have same `sum = i + j`.
    - Sum ranges from `0` to `m + n - 2`.
    - If `sum` is even, we traverse Up (`i` decreases).
    - If `sum` is odd, we traverse Down (`i` increases).
2.  **Simulation:**
    - Initialize `row=0, col=0`. `direction=Up`.
    - Loop `m*n` times.
    - Calculate next position. Handle boundaries carefully.
        - Up: `row--, col++`. If out of bounds: `col++` (if possible) or `row++` (if col out) -> change invalid.
        - Correct Boundary Logic (Up):
            - If `col` at end `n-1`: next is `row+1`.
            - Else if `row` at 0: next is `col+1`.
            - Else `row--, col++`.
        - Correct Boundary Logic (Down):
            - If `row` at end `m-1`: next is `col+1`.
            - Else if `col` at 0: next is `row+1`.
            - Else `row++, col--`.

---

## 2. Approach: Simulation
## *2. Hướng tiếp cận: Mô phỏng*

### Logic
### *Logic*
(See above). The simulation approach iterates exactly one step at a time, checking boundaries.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Space:** No extra storage besides result.
    *Không gian O(1): Không tốn bộ nhớ thêm ngoài kết quả.*
*   **Linear Scan:** Exact $M \times N$ steps.
    *Duyệt tuyến tính: Chính xác $M \times N$ bước.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(1)$ auxiliary.
    *Độ phức tạp không gian: $O(1)$ phụ trợ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[[1,2,3],[4,5,6],[7,8,9]]` (3x3)
1. `(0,0)`, v=1. Up. Bounds check: row 0. Move to `(0, 1)`, Dir Down.
2. `(0,1)`, v=2. Down `(1,0)`.
3. `(1,0)`, v=4. Bounds: col 0. Move to `(2,0)`, Dir Up.
4. `(2,0)`, v=7. Up `(1,1)` -> `(0,2)`.
5. `(0,2)`, v=3. Bounds: col 2 (end). Move to `(1,2)`, Dir Down.
6. `(1,2)`, v=6. Down `(2,1)`.
7. `(2,1)`, v=8. Bounds: row 2 (end). Move to `(2,2)`, Dir Up.
8. `(2,2)`, v=9. Bounds: row 2, col 2. Move to... End.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Simulate the traversal with direction flipping at boundaries.
*Mô phỏng quá trình duyệt với việc đảo ngược hướng tại các biên.*
---
*Đường đời (diagonal) không bao giờ thẳng tắp. Có lúc ta phải leo dốc (Up-Right) đầy nỗ lực, có lúc ta lại trượt xuống (Down-Left) nhẹ nhàng. Nhưng dù hướng đi có thay đổi thế nào (flipping direction), điều quan trọng là không bao giờ vượt quá giới hạn (boundaries) và luôn tiến về phía trước để hoàn thành bức tranh tổng thể (matrix elements).*
The path of life (Diagonal) is never straight. Sometimes we have to climb the slope (Up-Right) fully effortlessly, sometimes we slide down (Down-Left) gently. But no matter how the direction changes (Flipping Direction), it is important never to exceed the boundaries (Boundaries) and always move forward to complete the overall picture (Matrix Elements).
