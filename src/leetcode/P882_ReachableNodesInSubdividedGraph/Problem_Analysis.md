# 882. Reachable Nodes In Subdivided Graph / Các Nút có thể tiếp cận trong Đồ thị Phân chia

## Problem Description / Mô tả bài toán
You are given an undirected graph with `n` nodes. Each edge `[u, v, cnt]` is subdivided into `cnt` new nodes.
Bạn được cấp một đồ thị vô hướng với `n` nút. Mỗi cạnh `[u, v, cnt]` được chia nhỏ thành `cnt` nút mới.

Return the total number of nodes (original nodes and newly created nodes) that are reachable from node 0 in at most `maxMoves`.
Trả về tổng số nút (các nút gốc và các nút mới được tạo) có thể tiếp cận được từ nút 0 trong tối đa `maxMoves`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dijkstra's Algorithm / Thuật toán Dijkstra
This is essentially a shortest path problem on the original nodes.
Về cơ bản đây là bài toán tìm đường đi ngắn nhất trên các nút gốc.

Algorithm:
1. Use Dijkstra to find the shortest distance `dist[u]` from node 0 to all other original nodes.
2. A node `u` is reachable if `dist[u] <= maxMoves`.
3. For each edge `[u, v, cnt]`:
   - Number of nodes reachable from `u` side: `min(cnt, maxMoves - dist[u])` (if `dist[u] < maxMoves`).
   - Number of nodes reachable from `v` side: `min(cnt, maxMoves - dist[v])` (if `dist[v] < maxMoves`).
   - Total reachable on this edge: `min(cnt, count_u + count_v)`.

### Complexity / Độ phức tạp
- **Time**: O(E log V).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Shortest Path with Edge Saturation
Solve for the main intersections using Dijkstra. Then, calculate how much of each "road" (subdivided edge) can be covered by the remaining movement budget from both endpoints.
Giải quyết các điểm giao nhau chính bằng Dijkstra. Sau đó, tính toán xem mỗi "con đường" (cạnh được chia nhỏ) có thể được bao phủ bao nhiêu bởi ngân sách di chuyển còn lại từ cả hai đầu mút.

---
