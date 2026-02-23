# Analysis for Pacific Atlantic Water Flow
# *Phân tích cho bài toán Dòng nước Thái Bình Dương - Đại Tây Dương*

## 1. Problem Essence & Inverse Reachability
## *1. Bản chất vấn đề & Khả năng tiếp cận ngược*

### The Challenge
### *Thách thức*
Finding cells from which water can flow to both oceans. Water flows from high to low (or equal) height.

### Strategy: BFS/DFS from Boundaries
### *Chiến lược: BFS/DFS từ Biên giới*
Searching from every internal cell for paths to both oceans would be inefficient ($O((MN)^2)$).
Instead, we think in reverse: **Which cells can be reached by water flowing "upwards" from the oceans?**
1.  **Pacific Reachability:** Start DFS/BFS from all cells on the top edge and left edge. Water can flow from cell $A$ to its neighbor $B$ if `height[B] >= height[A]`. Mark these cells in a `pacific` boolean matrix.
2.  **Atlantic Reachability:** Start DFS/BFS from all cells on the bottom edge and right edge using the same logic. Mark these in an `atlantic` boolean matrix.
3.  **Intersection:** Any cell `(r, c)` where both `pacific[r][c]` and `atlantic[r][c]` are `true` is a candidate for the result.

---

## 2. Approach: Multi-source DFS
## *2. Hướng tiếp cận: DFS từ nhiều nguồn*

### Logic
### *Logic*
(See above). We maintain two separate boolean grids to track reachability from each ocean. The inverse height check (`neighbor >= current`) effectively simulates the gravity flow in the opposite direction.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(MN) Complexity:** Each cell is processed at most a few times per ocean.
    *Hiệu quả O(MN): Mỗi ô được xử lý tối đa một vài lần cho mỗi đại dương.*
*   **Decoupled Logic:** Solving for each ocean independently and then intersecting simplifies the problem.
    *Logic tách biệt: Giải quyết cho từng đại dương độc lập rồi lấy giao điểm giúp đơn giản hóa bài toán.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(MN)$, where $M, N$ are dimensions of the grid.
    *Độ phức tạp thời gian: $O(MN)$.*
*   **Space Complexity:** $O(MN)$ to store the reachability matrices.
    *Độ phức tạp không gian: $O(MN)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 5x5 matrix
1. Start DFS from row 0 and col 0 for Pacific. Mark reachable internal higher cells.
2. Start DFS from row 4 and col 4 for Atlantic. Mark reachable internal higher cells.
3. Iterate through all cells. If marked in both sets, add to list.
Result: Correct coordinates returned.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Inverse DFS from boundaries.
*DFS ngược từ biên giới.*
---
*Mọi dòng chảy đều có ngọn nguồn và đích đến. Thay vì mải miết đi tìm điểm kết thúc (oceans) từ mỗi ngọn núi (cells), hãy để đại dương tự tìm đường lên (DFS from boundary) những đỉnh cao nhất. Tại nơi mà hai dòng thủy triều từ hai phía gặp mặt (intersection), đó chính là những điểm giao thoa định mệnh của vùng đất.*
Every flow has a source and a destination. Instead of tirelessly searching for the end (oceans) from each mountain (cells), let the oceans find their own way up (DFS from boundary) to the highest peaks. Where the two tides from both sides meet (intersection), those are the fateful intersection points of the land.
