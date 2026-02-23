# Analysis for Walls and Gates
# *Phân tích cho bài toán Tường và Cổng*

## 1. Problem Essence & BFS
## *1. Bản chất vấn đề & BFS*

### The Challenge
### *Thách thức*
Fill matrix with distance to *nearest* 0.
Naive way: BFS from each room. $O(N^2 \cdot K)$? Too slow.
Better way: BFS from Gates.

### Strategy: Multi-Source BFS
### *Chiến lược: BFS Đa nguồn*
1.  Initialize Queue.
2.  Add ALL Gates (`0`) to Queue.
3.  Loop moves (BFS levels).
4.  For each room popped, check neighbors.
5.  If neighbor is `INF` (empty), update distance (current + 1) and push to Queue.
6.  If neighbor is `-1` or already visited (value != `INF`), skip.
    - Note: Since we use BFS, the first time we reach a room is guaranteed to be the shortest path.
    - Updating from `INF` to `val` marks it as visited.

---

## 2. Approach: Multi-Source BFS
## *2. Hướng tiếp cận: BFS Đa nguồn*

### Logic
### *Logic*
1.  Scan grid. Push all `(i,j)` where `rooms[i][j] == 0` to `queue`.
2.  While `queue` not empty:
    - Pop `(r, c)`.
    - Explore 4 directions `(nr, nc)`.
    - If valid and `rooms[nr][nc] == INF`:
        - `rooms[nr][nc] = rooms[r][c] + 1`
        - Push `(nr, nc)`.

### Why BFS?
### *Tại sao BFS?*
BFS naturally propagates layer by layer. All nodes at distance 1 are processed, then distance 2. This guarantees shortest path without `min` comparisons or relaxing edges (Dijkstra).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Parallel Propagation:** Like pouring water into the gates; it flows to nearest rooms first.
    *Lan truyền song song: Giống như đổ nước vào các cổng; nó chảy đến các phòng gần nhất trước.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$. Each cell visited at most once.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$ for queue.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 0 at (0,2) and (3,0).
Q: `[(0,2), (3,0)]`.
1.  Pop `(0,2)` (Val 0). Neighbors: `(0,3)` update to 1. `(1,2)` update to 1. Q adds them.
2.  Pop `(3,0)` (Val 0). Neighbors: `(2,0)` update to 1, `(3,1)` update to 1. Q adds them.
...
Eventually fills all reachable.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic Multi-Source BFS.
*BFS Đa nguồn kinh điển.*
---
*Cơ hội (cổng) mở ra cho tất cả, nhưng ai ở gần (nearest) sẽ tiếp cận trước. Lan tỏa giá trị từ nguồn đến mọi ngóc ngách.*
Opportunity (gate) opens for all, but those nearest reach it first. Propagate value from the source to every corner.
