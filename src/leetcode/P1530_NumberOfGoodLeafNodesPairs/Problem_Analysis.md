# 1530. Number of Good Leaf Nodes Pairs / Số lượng Cặp Lá Tốt

## Problem Description / Mô tả bài toán
Binary Tree. Distance `distance`.
Pair of leaf nodes is good if shortest path length <= `distance`.
Count good pairs.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Distance Reporting
DFS returns list of distances to all leaf nodes in its subtree (relative to itself).
At node `u`:
  `leftDistances = dfs(left)`.
  `rightDistances = dfs(right)`.
  Check pairs: Iterate `l` in `leftDistances` and `r` in `rightDistances`.
  If `l + r <= distance`, `count++`.
  Return list: `(d + 1)` for each `d` in `left` and `right`.
  Optimization: Filter out distances >= `distance` before returning to keep list small.
List size capped by `distance` or `number of leaves`. Since `distance` <= 10 (very small), list is small.

### Complexity / Độ phức tạp
- **Time**: O(N * D^2). With D <= 10, effectively O(N).
- **Space**: O(H * D).

---

## Analysis / Phân tích

### Approach: Post-Order DFS
Traverse. Collect distances.
Left returns leaf depths relative to left child.
Right returns leaf depths relative to right child.
Cross check.
Increment and merge for parent.
Duyệt. Thu thập khoảng cách.
Kiểm tra chéo.
Tăng và hợp nhất cho cha mẹ.

---
