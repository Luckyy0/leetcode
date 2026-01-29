# 971. Flip Binary Tree To Match Preorder Traversal / Lật Cây Nhị phân để khớp với Thứ tự Trước

## Problem Description / Mô tả bài toán
You are given the `root` of a binary tree with `n` nodes, where each node has a unique value from `1` to `n`. You are also given a sequence of `n` values `voyage`, which is the desired **preorder traversal** of the binary tree.
Cho gốc `root` của một cây nhị phân có `n` nút, trong đó mỗi nút có một giá trị duy nhất từ `1` đến `n`. Bạn cũng được cho một chuỗi gồm `n` giá trị `voyage`, đây là thứ tự **duyệt trước (preorder traversal)** mong muốn của cây nhị phân đó.

You can flip any node. Flipping a node means swapping its left and right child subtrees.
Bạn có thể lật bất kỳ nút nào. Lật một nút có nghĩa là hoán đổi các cây con bên trái và bên phải của nó.

Return a list of values of all nodes flipped such that the preorder traversal matches `voyage`. If impossible, return `[-1]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Preorder DFS with Greedy Choice / DFS thứ tự trước với lựa chọn Tham lam
Algorithm:
1. Maintain a global `index` in `voyage`.
2. `dfs(node)`:
   - If node is null, return true.
   - If `node.val != voyage[index++]`, return false (mismatch).
   - If `node.left` exists and `node.left.val != voyage[index]`:
     - This is the point to flip: record `node.val`.
     - Swap order of DFS: `dfs(node.right)` then `dfs(node.left)`.
   - Else:
     - Normal order: `dfs(node.left)` then `dfs(node.right)`.

Check if final result is valid.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Predictive Traversal Check
Traverse the tree while comparing each node with the target sequence. If a mismatch is detected at the left child, attempt a local swap to see if the alternate path aligns with the sequence. If neither path works, the target voyage is inherently unreachable.
Duyệt cây đồng thời so sánh mỗi nút với chuỗi mục tiêu. Nếu phát hiện thấy sự sai lệch ở nút con bên trái, hãy thử hoán đổi cục bộ để xem liệu đường dẫn thay thế có khớp với chuỗi hay không. Nếu cả hai đường dẫn đều không hoạt động, chuỗi mục tiêu vốn dĩ không thể đạt tới.

---
