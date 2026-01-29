# 1466. Reorder Routes to Make All Paths Lead to City Zero / Sắp xếp lại Các Tuyến đường để Tất cả các Đường dẫn Dẫn đến Thành phố Không

## Problem Description / Mô tả bài toán
N cities. Connection `connections[i] = [a, b]` (one-way a->b).
Reorient edges so that every city can reach city 0.
Count minimal edges changed.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / BFS on Undirected Graph
Treat edges as undirected.
But remember original direction.
Traverse starting from 0 (outwards).
If original edge is `u -> v` (away from 0 towards unknown), we must flip it. Count++.
If original edge is `v -> u` (towards 0), keep it.
Since it's a tree structure (n cities, n-1 edges), just traverse.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Graph Traversal
Adjacency list. Store neighbors and direction. `(neighbor, isOriginalDirection)`.
Example: input `[0, 1]`. Graph `0: [(1, true)]`, `1: [(0, false)]`.
Start BFS/DFS from 0.
For `0 -> 1`: `isOriginalDirection` is true. Means edge points 0->1. We want 1->0. So flip. Count++.
For `1 -> ...`.
Build graph: `adj[u].add({v, 1})` for original `u->v`. `adj[v].add({u, 0})`.
DFS from 0. When moving `u -> v`, if weight is 1, increment count.
Avoid visiting parent.
Xây dựng đồ thị: `adj[u].add({v, 1})` cho bản gốc `u->v`. `adj[v].add({u, 0})`.
DFS từ 0. Khi di chuyển `u -> v`, nếu trọng số là 1, tăng số đếm.

---
