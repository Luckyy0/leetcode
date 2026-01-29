# 1368. Minimum Cost to Make at Least One Valid Path in a Grid / Chi phí Tối thiểu để Tạo Ít nhất Một Đường dẫn Hợp lệ trong Lưới

## Problem Description / Mô tả bài toán
Grid with signs: 1 (R), 2 (L), 3 (D), 4 (U).
Start (0,0) to target (m-1, n-1).
Move according to sign: cost 0.
Change sign: cost 1.
Find min cost.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / Dijkstra / 0-1 BFS
Graph problem.
Nodes are cells.
Edges:
- To direction of sign: weight 0.
- To other 3 directions: weight 1.
Use 0-1 BFS (Deque) for efficiency.
If weight 0, push front. If weight 1, push back.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: 0-1 BFS
This is a shortest path problem on a grid. From any cell `(i, j)`, we can move to adjacent cells. If we move in the direction the current cell points to, the cost is 0. If we move to any other adjacent cell, the cost is 1 (effectively changing the sign). Since edge weights are only 0 or 1, we can use 0-1 BFS with a Deque.
Initialize `dist` matrix with infinity, `dist[0][0] = 0`. Add `(0,0)` to Deque.
While Deque not empty:
Pop `(r, c)`. For each neighbor:
If matching sign, cost 0: update dist, push front.
If not matching, cost 1: update dist, push back.
Đây là một bài toán đường đi ngắn nhất trên lưới. Từ bất kỳ ô `(i, j)`, chúng ta có thể di chuyển đến các ô liền kề. Nếu chúng ta di chuyển theo hướng mà ô hiện tại trỏ đến, chi phí là 0. Nếu chúng ta di chuyển đến bất kỳ ô liền kề nào khác, chi phí là 1 (thay đổi biển báo). Vì trọng số cạnh chỉ là 0 hoặc 1, chúng ta có thể sử dụng 0-1 BFS với một Deque.

---
