# 814. Binary Tree Pruning / Cắt tỉa Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the same tree where every subtree (of the given tree) not containing a `1` has been removed.
Cho `root` của một cây nhị phân, hãy trả về chính cây đó nhưng mọi cây con không chứa số `1` đã được loại bỏ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Depth First Search (Post-order) / DFS Đệ quy (Hậu thứ tự)
We need to decide if a node should be removed. A node should be removed if:
1. Its value is 0.
2. Its entire left subtree doesn't contain a 1.
3. Its entire right subtree doesn't contain a 1.

Algorithm:
1. Recurse down to the leaves.
2. `root.left = pruneTree(root.left)`.
3. `root.right = pruneTree(root.right)`.
4. If `root.left == null && root.right == null && root.val == 0`, return `null`.
5. Otherwise, return `root`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) for recursion stack.

---

## Analysis / Phân tích

### Approach: Bottom-up Pruning
By using post-order traversal, we prune the leaves first. This allows the removal state to propagate upwards, effectively cleaning all paths that lead to zero-only nodes.
Bằng cách sử dụng phép duyệt hậu thứ tự, chúng ta cắt tỉa các lá trước. Điều này cho phép trạng thái loại bỏ lan truyền lên trên, làm sạch hiệu quả tất cả các đường dẫn dẫn đến các nút chỉ chứa số không.

---
