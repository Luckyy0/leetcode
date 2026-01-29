# 404. Sum of Left Leaves / Tổng Các Lá Bên Trái

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the sum of all left leaves.
Cho `root` của một cây nhị phân, hãy trả về tổng của tất cả các lá bên trái.

A **leaf** node is a node with no children. A **left leaf** is a leaf that is the left child of another node.
Một nút **lá** là một nút không có nút con. Một **lá bên trái** là một nút lá và đồng thời là con bên trái của một nút khác.

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
```

### Example 2:
```text
Input: root = [1]
Output: 0
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 1000]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Traversal (DFS) / Duyệt Cây (DFS)
We can traverse the tree recursively. To identify a "left leaf", we need to know:
1. Is the node a leaf? (`node.left == null && node.right == null`)
2. Did we arrive at this node from its parent's left pointer?

Algorithm:
1. Define a helper function `dfs(node, isLeft)`.
2. Base case: if `node` is null, return 0.
3. If `node` is a leaf:
   - If `isLeft` is true, return `node.val`.
   - Else return 0.
4. Recursive step: return `dfs(node.left, true) + dfs(node.right, false)`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) where H is the height of the tree (recursion stack).

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  Implement the recursive helper.
2.  Initial call: `dfs(root, false)`.

---
