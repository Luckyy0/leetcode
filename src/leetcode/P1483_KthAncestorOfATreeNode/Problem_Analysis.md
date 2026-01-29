# 1483. Kth Ancestor of a Tree Node / Tổ tiên Thứ K của Nút Cây

## Problem Description / Mô tả bài toán
Tree `n` nodes. `parent` array.
`getKthAncestor(node, k)`.
Return -1 if not exists.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Lifting (LCA preprocessing technique)
`up[i][j]` = $2^j$-th ancestor of node `i`.
`up[i][0] = parent[i]`.
`up[i][j] = up[up[i][j-1]][j-1]`.
To get k-th ancestor:
K = bitmask. Jump according to set bits in K.
Max depth N=50000. Logs approx 16.

### Complexity / Độ phức tạp
- **Time**: Precalc O(N log N). Query O(log N).
- **Space**: O(N log N).

---

## Analysis / Phân tích

### Approach: Binary Lifting Array
Init table `up[n][LOG]`.
Compute standard DP.
Query: iterate bits of k. Update node. If node becomes -1, return -1.
Khởi tạo bảng `up[n][LOG]`.
Tính toán DP tiêu chuẩn.
Truy vấn: lặp lại các bit của k. Cập nhật nút.

---
