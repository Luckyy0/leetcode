# Analysis for The Maze
# *Phân tích cho bài toán Mê cung*

## 1. Problem Essence & Stopping Points
## *1. Bản chất vấn đề & Các điểm dừng*

### The Challenge
### *Thách thức*
Navigating a grid where movement continues until a wall is hit. We can only change direction at stopping points.
- Normal BFS: Move 1 step to adjacent cells.
- **Maze BFS**: Move continuously in one direction until stopped. The "neighbors" of a cell are the stopping positions in 4 directions.

### Strategy: BFS on Stopping Points
### *Chiến lược: BFS trên Các điểm dừng*

1.  **State:** `(row, col)` representing a position where the ball has stopped.
2.  **Queue:** Initialize with `start`.
3.  **Visited:** `visited[m][n]` array to track **stop positions**.
    - Important: We assume we only "visit" a cell if we STOP there. Traversing through a cell doesn't count as visiting it in the graph sense (though we can assume passing through implies reachability, stopping is the key state).
4.  **Transitions:**
    - Pop `(r, c)`.
    - Loop 4 directions `(dx, dy)`.
    - **Roll:** Move `curr_r += dx`, `curr_c += dy` until hitting a wall (`1`) or boundary.
    - **Backtrack one step:** The ball stops at the cell *before* the wall.
    - If this new stopping point `(new_r, new_c)` is the destination, return `True`.
    - If not counted in `visited`, add to queue and mark `visited`.

---

## 2. Approach: BFS
## *2. Hướng tiếp cận: BFS*

### Logic
### *Logic*
(See above). The graph nodes are the empty spaces adjacent to walls (plus start). Edges are the straight paths.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Efficiency:** We only process stopping points, effectively collapsing long paths into single edges.
    *Hiệu quả: Chúng ta chỉ xử lý các điểm dừng, nén các đường đi dài thành các cạnh đơn.*
*   **Correctness:** BFS finds reachability (path length not required to be minimal, just boolean).
    *Tính đúng đắn: BFS tìm khả năng tiếp cận.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N)$. In worst case, every cell is a stop point (e.g., checkerboard pattern). Rolling takes proportional to grid size, but each cell effectively visited constant times (once per direction sort of). Actually $O(M \cdot N)$ vertices, edge traversal takes $O(\max(M, N))$, so maybe $O(M \cdot N \cdot \max(M, N))$?
    - More accurately: We push each node to queue once. Processing a node involves rolling 4 directions. Total rolling distance across whole BFS is bounded. Actually, each cell is traversed a limited number of times. Total cost is roughly $O(M \cdot N)$.
    *Độ phức tạp thời gian: $O(M \cdot N)$.*
*   **Space Complexity:** $O(M \cdot N)$ for visited array and queue.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `maze`, `start`, `dest`.
1. Q: `[start]`. `visited[start]=true`.
2. Pop `start`.
   - Roll Down: Stop at wall. New pos `P1`. If `P1==dest`, true. Else Q add `P1`.
   - Roll Right: Stop at wall. New pos `P2`...
   - ...
3. Continue BFS. If Q empty, return False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

BFS treating "rolling until wall" as a single step.
*BFS coi việc "lăn đến khi gặp tường" là một bước duy nhất.*
---
*Đôi khi cuộc đời không cho phép ta dừng lại giữa chừng (rolling until wall), ta buộc phải trôi theo dòng chảy cho đến khi va vấp vào một rào cản thực sự. Sự tự do lựa chọn (choosing next direction) chỉ đến khi ta đã đi hết một chặng đường và buộc phải dừng bước (start/stop points). Hãy tận dụng những điểm dừng chân hiếm hoi đó để định vị lại la bàn cuộc đời.*
Sometimes life does not allow us to stop in the middle (rolling until a wall), we are forced to drift along the flow until we stumble upon a real barrier. Freedom of choice (Choosing Next Direction) only comes when we have gone all the way and are forced to stop (Start/Stop Points). Take advantage of those rare stops to re -locate the compass of life.
