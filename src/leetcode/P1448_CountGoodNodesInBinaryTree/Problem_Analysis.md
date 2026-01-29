# 1448. Count Good Nodes in Binary Tree / Đếm Nút Tốt trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Binary Tree. Node X is good if path from root to X has no nodes with value > X.val.
Count good nodes.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Max Tracking
Traverse tree. Keep track of `maxVal` seen on path.
If `node.val >= maxVal`:
- Count++.
- Update `maxVal = node.val`.
Recurse.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive DFS
DFS function: `dfs(node, maxSoFar)`.
Base Case: `node == null` return 0.
Count = 0.
If `node.val >= maxSoFar`:
- `Count = 1`.
- `newMax = node.val`.
Else:
- `Count = 0`.
- `newMax = maxSoFar`.
Return `count + dfs(left, newMax) + dfs(right, newMax)`.
Hàm DFS: `dfs(node, maxSoFar)`.
Trường hợp cơ sở: `node == null` trả về 0.
Nếu `node.val >= maxSoFar`: `Count = 1`, `newMax = node.val`.

---
