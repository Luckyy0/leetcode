# 261. Graph Valid Tree / Đồ Thị Cây Hợp Lệ

## Problem Description / Mô tả bài toán
You have a graph of `n` nodes labeled from `0` to `n - 1`. You are given an integer `n` and a list of `edges` where `edges[i] = [ai, bi]` indicates that there is an undirected edge between nodes `ai` and `bi` in the graph.
Bạn có một đồ thị gồm `n` nút được dán nhãn từ `0` đến `n - 1`. Bạn được cho một số nguyên `n` và một danh sách `edges` trong đó `edges[i] = [ai, bi]` chỉ ra rằng có một cạnh vô hướng giữa các nút `ai` và `bi` trong đồ thị.

Return `true` if the edges of the given graph make up a valid tree, and `false` otherwise.
Trả về `true` nếu các cạnh của đồ thị đã cho tạo thành một cây hợp lệ, và `false` nếu không.

### Example 1:
```text
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true
```

### Example 2:
```text
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
```

## Constraints / Ràng buộc
- `1 <= n <= 2000`
- `0 <= edges.length <= 5000`
- `edges[i].length == 2`
- `0 <= ai, bi < n`
- `ai != bi`
- There are no self-loops or repeated edges.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Properties / Các Tính Chất Của Cây
A graph is a valid tree if and only if:
1.  It is **fully connected** (contains only 1 connected component).
2.  It contains **no cycles**.

Alternatively:
- A graph with `n` nodes is a tree if it is fully connected and has exactly `n - 1` edges.
- If edges != `n-1`, it's not a tree (either cycle or disconnected).

**Algorithm (Union-Find / Disjoint Set Option)**:
1.  Check if `edges.length != n - 1`. Return `false` immediately.
2.  Initialize Union-Find with `n` components.
3.  For each edge `(u, v)`:
    - If `find(u) == find(v)`: Cycle detected. Return `false`.
    - `union(u, v)`.
4.  After processing all edges, check if number of connected components is 1. Since we started with `n` and performed `n-1` successful unions (no cycles), we are guaranteed 1 component.
    - Actually, if we pass the edge count check and the cycle check, connectivity is guaranteed for `n` nodes with `n-1` acyclic edges.

### Complexity / Độ phức tạp
- **Time**: O(E * alpha(N)) which is nearly O(N) given E = N-1.
- **Space**: O(N) for Union-Find parent array.

---

## Analysis / Phân tích

### Approach: Union-Find

**Algorithm**:
1.  If `n == 1` and `edges` empty: return True.
2.  If `edges.length != n - 1`: return False.
3.  Init `parent` array.
4.  For each edge:
    - `rootX = find(x)`, `rootY = find(y)`.
    - If `rootX == rootY`: return False (Cycle).
    - `union(rootX, rootY)`.
5.  Return True.

---

## Edge Cases / Các trường hợp biên
1.  **n=1**: 0 edges. Tree.
2.  **Disconnected**: Edges check catches some, but Union-Find ensures cycle-free. Combined `edges == n-1` + `no cycle` => `connected`.
