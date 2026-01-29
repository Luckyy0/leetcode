# 1361. Validate Binary Tree Nodes / Xác thực các Nút Cây Nhị phân

## Problem Description / Mô tả bài toán
`n` nodes (0 to n-1).
`leftChild` and `rightChild` arrays.
Return `true` if valid Binary Tree.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Properties
1. Exactly one root (node with in-degree 0).
2. Every other node has in-degree 1.
3. No cycles.
4. All nodes reachable from root (connected).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Logic Check + Graph Traversal
1. Calculate in-degrees for all nodes.
2. Find root: node with in-degree 0. Must be unique. If 0 or >1 roots, false.
3. Check in-degrees: all non-roots must have in-degree 1. If any > 1, false.
4. Check connectivity/cycles: Traverse from root (BFS/DFS) and count visited nodes. Visited count must be `n`.
1. Tính in-degrees cho tất cả các nút.
2. Tìm gốc: nút có in-degree 0. Phải là duy nhất. Nếu 0 hoặc >1 gốc, false.
3. Kiểm tra in-degrees: tất cả các nút không phải gốc phải có in-degree 1. Nếu bất kỳ > 1, false.
4. Kiểm tra kết nối/chu kỳ: Duyệt từ gốc (BFS/DFS) và đếm số nút đã truy cập. Số lượng truy cập phải là `n`.

---
