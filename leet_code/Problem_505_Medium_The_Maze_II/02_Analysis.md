# Analysis for The Maze II
# *Phân tích cho bài toán Mê cung II*

## 1. Problem Essence & Minimum Distance
## *1. Bản chất vấn đề & Khoảng cách Tối thiểu*

### The Challenge
### *Thách thức*
Finding the path with minimal distance where edges are "rolling" segments.
- Weighted graph where nodes are "stopping coordinates".
- Edge weight = Length of roll.
- Dijkstra's Algorithm is the standard solution for shortest paths in weighted graphs.
- (BFS is for unweighted edges).

### Strategy: Dijkstra
### *Chiến lược: Dijkstra*

1.  **State:** `(row, col)`.
2.  **Distance Map:** `dist[m][n]` storing min distance. Init `MAX`.
3.  **PQ:** `(distance, row, col)`.
4.  **Transitions:**
    - From `(r, c)`, try 4 instructions (U, D, L, R).
    - Roll until wall. New pos `(nr, nc)`. Distance `d`.
    - If `curr_dist + d < dist[nr][nc]`: Update `dist`, Push to PQ.

---

## 2. Approach: Dijkstra
## *2. Hướng tiếp cận: Dijkstra*

### Logic
### *Logic*
(See above).
Compared to Maze III (Hard), we don't need lexicographical path string, simplifying the PQ logic (just distance).
Compared to Maze I (Medium), we need distance, not just reachability.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimality:** Dijkstra guarantees shortest path.
    *Tính tối ưu: Dijkstra đảm bảo đường đi ngắn nhất.*
*   **Simplicity:** Standard template.
    *Đơn giản: Mẫu chuẩn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \cdot N \log(M \cdot N))$.
    *Độ phức tạp thời gian: $O(M \cdot N \log(M \cdot N))$.*
*   **Space Complexity:** $O(M \cdot N)$.
    *Độ phức tạp không gian: $O(M \cdot N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** Start `(0,4)`, Dest `(4,4)`.
1. PQ: `[(0, 0, 4)]`. Dist `[0][4]=0`.
2. Pop `(0,4)`.
   - Roll Left -> Stop `(0,2)`. Cost 2. Push `(2, 0, 2)`.
   - Roll Down -> Stop `(2,4)`. Cost 2? No, wall at `(3,3)`? Checks maze.
   - ...
3. Eventually pop Dest `(4,4)` with minimal cost.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Dijkstra's Algorithm on stopping points.
*Thuật toán Dijkstra trên các điểm dừng.*
---
*Trong mê cung (Maze) của những lựa chọn, không phải con đường nào ngắn nhất về địa lý cũng là con đường nhanh nhất về thời gian (rolling constraint). Dijkstra dạy ta rằng, hãy luôn chọn bước đi tiếp theo dựa trên chi phí tích lũy nhỏ nhất (accumulated cost), và đừng ngần ngại thay đổi hướng đi khi va phải những trở ngại không thể vượt qua.*
In the maze (Maze) of choices, not every path that is geographically shortest is the fastest in time (Rolling Constraint). Dijkstra teaches us, always choose the next step based on the smallest accumulated cost, and do not hesitate to change direction when hitting insurmountable obstacles.
