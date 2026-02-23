# Analysis for The Maze III
# *Phân tích cho bài toán Mê cung III*

## 1. Problem Essence & Shortest Path with State
## *1. Bản chất vấn đề & Đường đi Ngắn nhất với Trạng thái*

### The Challenge
### *Thách thức*
Finding the path with minimal distance, tie-breaking with lexicographical order. The movement is "roll until wall/hole". This is Dijkstra's algorithm.
- Regular BFS works for unweighted graphs (step count). Here, edges have weights (distance rolled). So Dijkstra is appropriate.
- State: `(row, col)`. Value: `(distance, path_string)`.

### Strategy: Dijkstra
### *Chiến lược: Dijkstra*

1.  **Distance Array:** `dist[m][n]` storing the minimal distance found so far. Initialize with infinity.
2.  **Path Array:** `paths[m][n]` storing the lexicographically smallest path string for that minimal distance.
3.  **Priority Queue:** Stores `Point(row, col, distance, path_string)`.
    - Ordering: primary `distance`, secondary `path_string` (lexicographical).
4.  **Transitions:**
    - From `(r, c)`, roll 4 directions.
    - Count roll distance. Stop at wall OR hole.
    - If hole hit, check if this path is better than current best to hole.
    - If wall hit (stopped at `nr, nc`), check if we can update `dist[nr][nc]`.
    - **Update Logic:**
        - If `newDist < dist[nr][nc]`: Update `dist`, update `path`, push to PQ.
        - If `newDist == dist[nr][nc]` AND `newPath < path[nr][nc]`: Update `path`, push to PQ.
        - Otherwise, ignore.

---

## 2. Approach: Dijkstra with Custom Priority
## *2. Hướng tiếp cận: Dijkstra với Ưu tiên Tùy chỉnh*

### Logic
### *Logic*
(See above). The stopping condition at **Hole** is special. The ball drops immediately.
Important: A ball might roll *over* the hole? The problem says "The ball will drop into the hole if it rolls onto the hole." This implies it stops *at* the hole, not pass through. 
Wait, usually in these problems, hole stops the ball. Yes. So while rolling, check `(r, c) == hole` at every step.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Dijkstra:** Handles weighted edges naturally.
    *Dijkstra: Xử lý các cạnh có trọng số một cách tự nhiên.*
*   **Lexicographical Tie-breaking:** Handled by PQ comparator and update logic.
    *Phá vỡ thế cân bằng từ điển: Được xử lý bởi bộ so sánh PQ và logic cập nhật.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N \cdot \log(M \cdot N))$.
    *Độ phức tạp thời gian: $O(M \cdot N \cdot \log(M \cdot N))$.*
*   **Space Complexity:** $O(M \cdot N)$.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Ball `(4,3)`, Hole `(0,1)`.
1. PQ: `[(4,3, 0, "")]`.
2. Pop `(4,3)`. Roll:
   - 'l': `(4,2), (4,1), (4,0)`. Hole not hit. Wall hit. Stop `(4,0)`. Dist 3. `path="l"`. Push `(4,0, 3, "l")`.
   - 'u': Stop `(2,3)`. Dist 2. `path="u"`.
   - ...
3. Iterate. Eventually roll from `(4,0)` 'u' -> `(3,0), (2,0), (1,0), (0,0)`. Stop `(0,0)`. Dist 3+4=7. `path="lu"`.
   - From `(0,0)` 'r' -> `(0,1)`. **Hole!** Dist 7+1=8. `path="lur"`.
   - Compare with other paths...

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Dijkstra on stopping points, checking hole intersection during roll.
*Dijkstra trên các điểm dừng, kiểm tra giao cắt lỗ trong khi lăn.*
---
*Đôi khi con đường ngắn nhất (shortest distance) không phải là con đường đầu tiên ta nghĩ đến. Trong mê cung cuộc đời, việc chọn hướng đi không chỉ dựa trên tốc độ, mà còn dựa trên sự thanh lịch của các bước đi (lexicographically smallest). Khi ta kiểm soát tốt cả quãng đường và phương pháp (distance & path), cái đích cuối cùng (hole) sẽ trở nên tất yếu.*
Sometimes the shortest path (Shortest Distance) is not the first path we think of. in the maze of life, choosing a direction is not only based on speed, but also based on the elegance of the steps (lexicographically smallest). When we control both the distance and method (Distance & Path), the final destination (Hole) will become inevitable.
