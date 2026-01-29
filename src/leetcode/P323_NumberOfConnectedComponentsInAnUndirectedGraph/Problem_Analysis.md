# 323. Number of Connected Components in an Undirected Graph / Số Thành Phần Liên Thông Trong Đồ Thị Vô Hướng

## Problem Description / Mô tả bài toán
You have a graph of `n` nodes. You are given an integer `n` and an array `edges` where `edges[i] = [ai, bi]` indicates that there is an edge between `ai` and `bi` in the graph.
Bạn có một đồ thị gồm `n` nút. Bạn được cung cấp một số nguyên `n` và một mảng `edges`.

Return the number of connected components in the graph.
Trả về số lượng thành phần liên thông trong đồ thị.

### Example 1:
```text
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
```

### Example 2:
```text
Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 2000`
- `1 <= edges.length <= 5000`
- `edges[i].length == 2`
- `0 <= ai <= bi < n`
- `ai != bi`
- There are no repeated edges.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Union-Find (DSU) / Tìm-Hợp
Ideally suited for counting connected components.
- Start with `n` components.
- For each edge `(u, v)`:
    - If `find(u) != find(v)`:
        - `union(u, v)`.
        - `count--`.
- Return `count`.

### Complexity / Độ phức tạp
- **Time**: `O(E * alpha(N))`. E edges, N nodes. alpha is Inverse Ackermann (nearly constant).
- **Space**: `O(N)`.

---

## Analysis / Phân tích

### Approach: DSU

**Algorithm**:
1.  Parent array.
2.  Iterate edges to union.
3.  Count decrements on successful union.

---
