# 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree / Tìm Nút Tương ứng của Cây Nhị phân trong Bản sao của Cây đó

## Problem Description / Mô tả bài toán
Original tree `original`, Clone tree `cloned`, Target node `target` (from original).
Find reference to same node in `cloned`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Traversal (Simultaneous)
Traverse both trees simultaneously.
If `original_node == target`, return `cloned_node`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive DFS
Recursively traverse `original` and `cloned` in lockstep.
`dfs(o, c)`:
If `o == null` return null.
If `o == target` return `c`.
`res = dfs(o.left, c.left)`. If `res` not null, return it.
Return `dfs(o.right, c.right)`.
Đệ quy duyệt `original` và `cloned` đồng thời.
`dfs(o, c)`:
Nếu `o == null` trả về null.
Nếu `o == target` trả về `c`.
`res = dfs(o.left, c.left)`. Nếu `res` không null, trả về nó.
Trả về `dfs(o.right, c.right)`.

---
