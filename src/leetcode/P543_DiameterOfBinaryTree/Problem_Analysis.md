# 543. Diameter of Binary Tree / Đường Kính Của Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the length of the **diameter** of the tree.
Cho `root` của một cây nhị phân, hãy trả về độ dài của **đường kính** của cây.

The diameter of a binary tree is the **length** of the longest path between any two nodes in a tree. This path may or may not pass through the `root`.
Đường kính của cây nhị phân là **độ dài** của đường đi dài nhất giữa hai nút bất kỳ trong cây. Đường đi này có thể không đi qua `root`.

The length of a path between two nodes is represented by the number of edges between them.
Độ dài của đường đi giữa hai nút được biểu thị bằng số lượng cạnh giữa chúng.

### Example 1:
```text
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth-First Search (Post-order) / Tìm Kiếm Theo Chiều Sâu (Hậu Thứ Tự)
For any node, the longest path passing through it is `depth(left) + depth(right)`.
The diameter is the maximum of this value over all nodes.

Algorithm:
1. Initialize `maxDiameter = 0`.
2. Define a helper function `depth(node)`:
   - If `node` is null, return 0.
   - `L = depth(node.left)`.
   - `R = depth(node.right)`.
   - `maxDiameter = max(maxDiameter, L + R)`.
   - Return `max(L, R) + 1`.
3. Valid edge count is calculated accurately because depth counts nodes, so depth-1 is edges? No, usually depth returns longest chain of nodes.
   - If depth returns max nodes in a branch:
     - `L` is depth of left child. Path through root uses `L` edges + `R` edges?
     - Let's say depth of leaf is 1.
     - Path len = `depth(left) + depth(right)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Height Calculation

**Algorithm**:
1.  Recursively calculate height of subtrees.
2.  Update global diameter using `left + right`.
3.  Return `max(left, right) + 1`.

---
