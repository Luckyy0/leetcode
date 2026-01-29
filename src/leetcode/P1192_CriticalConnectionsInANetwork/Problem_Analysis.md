# 1192. Critical Connections in a Network / Các Kết nối Quan trọng trong một Mạng

## Problem Description / Mô tả bài toán
There are `n` servers numbered from `0` to `n-1` connected by undirected server-to-server `connections`.
A critical connection is a connection that, if removed, will make some server unable to reach some other server.
Return all critical connections in the network in any order.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tarjan's Bridge-Finding Algorithm / Thuật toán Tìm Cầu của Tarjan
Standard algorithm to find bridges in an undirected graph.
DFS traversal maintaining:
- `disc[u]`: discovery time of node `u`.
- `low[u]`: lowest discovery time reachable from `u` (including back-edges).
Edges `(u, v)` where `low[v] > disc[u]` are bridges.

### Complexity / Độ phức tạp
- **Time**: O(V + E).
- **Space**: O(V + E).

---

## Analysis / Phân tích

### Approach: Tarjan's Bridge Finding
Use Tarjan's algorithm or Hopcroft-Tarjan algorithm logic (DFS). Track discovery times (`disc`) and lowest reachable times (`low`) for each node. If for an edge $u \to v$, `low[v] > disc[u]`, it implies there is no back-edge from $v$ or its descendants to $u$ or its ancestors, making $(u, v)$ a critical connection (bridge).
Sử dụng thuật toán Tarjan hoặc logic thuật toán Hopcroft-Tarjan (DFS). Theo dõi thời gian khám phá (`disc`) và thời gian có thể truy cập thấp nhất (`low`) cho mỗi nút. Nếu đối với một cạnh $u \to v$, `low[v] > disc[u]`, điều đó ngụ ý không có cạnh ngược từ $v$ hoặc con cháu của nó đến $u$ hoặc tổ tiên của nó, khiến $(u, v)$ trở thành một kết nối quan trọng (cầu).

---
