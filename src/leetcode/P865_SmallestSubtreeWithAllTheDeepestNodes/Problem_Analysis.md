# 865. Smallest Subtree with all the Deepest Nodes / Cây con Nhỏ nhất chứa Tất cả các Nút Sâu nhất

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the smallest subtree that contains all the deepest nodes of the original tree.
Cho `root` của một cây nhị phân, hãy trả về cây con nhỏ nhất chứa tất cả các nút sâu nhất của cây ban đầu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Depth Calculation / Tính toán Độ sâu Đệ quy
For each node, we want to know the maximum depth of its left and right subtrees.
Đối với mỗi nút, chúng ta muốn biết độ sâu tối đa của các cây con bên trái và bên phải của nó.

Algorithm:
1. Define a helper `depth(node)` that returns `(totalDepth, resultSubtree)`.
2. For current node:
   - `(L_depth, L_res) = depth(node.left)`
   - `(R_depth, R_res) = depth(node.right)`
3. If `L_depth == R_depth`: the current node is the lowest common ancestor of all deepest nodes in its own subtree. Return `(L_depth + 1, node)`.
4. If `L_depth > R_depth`: the deepest nodes are all on the left. Return `(L_depth + 1, L_res)`.
5. If `R_depth > L_depth`: the deepest nodes are all on the right. Return `(R_depth + 1, R_res)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Depth-Comparison LCA
Find the lowest common ancestor (LCA) specifically for the set of nodes belonging to the maximum depth level. By comparing the heights of left and right children, we can locate the exact subtree where these nodes converge.
Tìm tổ tiên chung thấp nhất (LCA) cụ thể cho tập hợp các nút thuộc mức độ sâu tối đa. Bằng cách so sánh chiều cao của các nút con bên trái và bên phải, chúng ta có thể định vị chính xác cây con nơi các nút này hội tụ.

---
