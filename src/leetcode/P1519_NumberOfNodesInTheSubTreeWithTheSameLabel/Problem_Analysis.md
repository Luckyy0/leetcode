# 1519. Number of Nodes in the Sub-Tree With the Same Label / Số lượng Nút trong Cây con Có Cùng Nhãn

## Problem Description / Mô tả bài toán
Tree `n` nodes, edges. String `labels`.
For each node `i`, find number of nodes in `i`'s subtree having same label as `i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS with Count Merging
DFS returns an array of counts (size 26) representing labels in subtree.
At node `u`:
  Initialize `count` array.
  `count[labels[u] - 'a']++`.
  For each child `v`:
    `childCounts = dfs(v)`.
    Merge `childCounts` into `count`.
  `result[u] = count[labels[u] - 'a']`.
  Return `count`.

### Complexity / Độ phức tạp
- **Time**: O(N * 26) = O(N).
- **Space**: O(N * 26) or O(H * 26).

---

## Analysis / Phân tích

### Approach: Post-Order Traversal
Build adjacency list.
DFS. Aggregate frequency arrays from children. Add current node. Store result.
Xây dựng danh sách kề.
DFS. Tổng hợp mảng tần số từ con. Thêm nút hiện tại. Lưu trữ kết quả.

---
