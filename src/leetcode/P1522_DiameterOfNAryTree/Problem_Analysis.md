# 1522. Diameter of N-Ary Tree / Đường kính của Cây N-Ary

## Problem Description / Mô tả bài toán
Diameter: Longest path between any two nodes.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS Height Calculation
For each node, compute height (max depth of subtree).
Diameter passing through node `u` = Sum of two largest heights of children + (0, 1, or 2 edges depending on definition). Usually sum of max depths.
If heights are lengths of paths from current to leaf.
`max1` and `max2` among `dfs(child)`.
`globalDiameter = max(globalDiameter, max1 + max2)`.
Return `max1 + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive DFS
DFS returns max path length from node to leaf.
Inside DFS, track top 2 lengths. Update global max.
DFS trả về độ dài đường dẫn tối đa từ nút đến lá.
Bên trong DFS, theo dõi 2 độ dài hàng đầu. Cập nhật tối đa toàn cầu.

---
