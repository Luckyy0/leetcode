# 1123. Lowest Common Ancestor of Deepest Leaves / Tổ tiên Chung Thấp nhất của các Lá Sâu nhất

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the lowest common ancestor of its deepest leaves.
Cho `root` của một cây nhị phân, hãy trả về tổ tiên chung thấp nhất của các lá sâu nhất của nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### New Subtree Property (Height) / Thuộc tính Cây con Mới (Chiều cao)
Logic:
If `left` subtree is deeper than `right`, the answer is in `left`.
If `right` subtree is deeper than `left`, the answer is in `right`.
If depths are equal, the current node is the LCA (because it bridges the deepest nodes from both sides).

Algorithm:
1. `dfs(node)` returns `Pair<Depth, LCA>`.
2. Base case: `null` -> `Depth 0, null`.
3. `left = dfs(node.left)`, `right = dfs(node.right)`.
4. If `left.d == right.d`: return `Depth left.d + 1, node`.
5. If `left.d > right.d`: return `Depth left.d + 1, left.lca`.
6. Else: return `Depth right.d + 1, right.lca`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Depth-Augmented Recursion
Implement a recursive function that returns both the maximum depth of the subtree and the LCA of the deepest leaves within that subtree. At any node, if the left and right subtrees have the same maximum depth, the current node is the LCA. If one side is deeper, the LCA lies within that deeper side.
Thực hiện một hàm đệ quy trả về cả độ sâu tối đa của cây con và LCA của các lá sâu nhất trong cây con đó. Tại bất kỳ nút nào, nếu cây con bên trái và bên phải có cùng độ sâu tối đa, nút hiện tại là LCA. Nếu một bên sâu hơn, LCA nằm trong bên sâu hơn đó.

---
