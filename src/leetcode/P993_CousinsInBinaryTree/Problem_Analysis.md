# 993. Cousins in Binary Tree / Anh em họ trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Two nodes of a binary tree are **cousins** if they have the same depth but **different parents**.
Hai nút của một cây nhị phân được gọi là **anh em họ** nếu chúng có cùng độ sâu nhưng **khác cha**.

Given `root`, `x`, and `y`, return `true` if they are cousins.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Traversal (BFS or DFS) / Duyệt Cây (BFS hoặc DFS)
Algorithm:
1. `dfs(node, parent, depth, target)`:
   - Find and record `(parent, depth)` for `x` and `y`.
2. Compare:
   - `depthX == depthY`
   - `parentX != parentY`

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Lineage Verification
Contextualize each target node by its vertical position and its immediate ancestor. Comparison of these two attributes allows us to distinguish "siblings" (same parent) from "cousins" (different parent), verifying the requirements for the latter.
Ngữ cảnh hóa mỗi nút mục tiêu bằng vị trí dọc và tổ tiên trực tiếp của nó. Việc so sánh hai thuộc tính này cho phép chúng ta phân biệt "anh chị em" (cùng cha mẹ) với "anh em họ" (khác cha mẹ), đồng thời xác minh các yêu cầu đối với trường hợp sau.

---
