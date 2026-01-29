# 1469. Find All The Lonely Nodes / Tìm Tất cả Các Nút Cô đơn

## Problem Description / Mô tả bài toán
Binary Tree. Node is lonely if it is the ONLY child of its parent.
Return values of all lonely nodes.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / BFS
Check children of each node.
If `left != null` and `right == null`, `left` is lonely.
If `left == null` and `right != null`, `right` is lonely.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive DFS
Traverse. If condition met, add to list.
Duyệt. Nếu điều kiện được đáp ứng, thêm vào danh sách.

---
