# 1485. Clone Binary Tree With Random Pointer / Sao chép Cây Nhị phân Với Con trỏ Ngẫu nhiên

## Problem Description / Mô tả bài toán
Binary Tree with `random` pointer.
Clone it (Deep copy).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hash Map Mapping
Map `OldNode -> NewNode`.
Two Passes or Recursion with Map.
1. `dfs(node)`:
   - If node null, return null.
   - If map contains node, return map value.
   - Create `newNode` with `val`. Map it.
   - `newNode.left = dfs(node.left)`.
   - `newNode.right = dfs(node.right)`.
   - `newNode.random = dfs(node.random)`.
   - Return `newNode`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive DFS with Map
Standard cloning graph/tree algorithm.
Thuật toán sao chép đồ thị/cây chuẩn.

---
