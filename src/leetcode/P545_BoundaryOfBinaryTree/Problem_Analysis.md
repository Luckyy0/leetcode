# 545. Boundary of Binary Tree / Đường Biên Của Cây Nhị Phân

## Problem Description / Mô tả bài toán
The **boundary** of a binary tree is the concatenation of the **root**, the **left boundary**, the **leaves** ordered from left-to-right, and the **reverse right boundary**.
**Đường biên** của cây nhị phân là sự kết hợp của **gốc**, **biên trái**, **các lá** được sắp xếp từ trái sang phải, và **biên phải đảo ngược**.

The **left boundary** is defined as the path from the root to the **left-most** node. `root` is part of it. If a node in the left boundary has a left child, then the left child is in the left boundary. If it doesn't, but has a right child, the right child is in the left boundary. The **left-most** node is also a leaf. The root and the left-most node are not included in the left boundary definition for this specific problem concatenation (handled separately usually to avoid duplicates).
Wait, problem definition of "left boundary" excludes root and leaves.

Let's stick to the problem's exact requirement:
1. Root.
2. Left Boundary (nodes on the left edge, excluding root and leaf).
3. Leaves (all leaf nodes left to right).
4. Right Boundary (nodes on the right edge, excluding root and leaf, in reverse order).

### Example 1:
```text
Input: root = [1,null,2,3,4]
Output: [1,3,4,2]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Structural Decomposition / Phân rã Cấu trúc
We can perform three separate traversals (or logic blocks) to collect the nodes.

Algorithm:
1. Add `root.val`.
2. **Left Boundary**: Start `curr = root.left`.
   - While `curr` is not a leaf:
     - Add `curr.val`.
     - Move to `curr.left` if exists, else `curr.right`.
3. **Leaves**: Perform a simple DFS traversal. Add node if it is a leaf (and `node != root`).
4. **Right Boundary**: Start `curr = root.right`.
   - While `curr` is not a leaf:
     - Push `curr.val` to a stack (or recursive list to reverse later).
     - Move to `curr.right` if exists, else `curr.left`.
   - Pop stack and add to result.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Component-based Traversal

**Algorithm**:
1.  Add root (if not leaf).
2.  Traverse left boundary (top-down).
3.  Traverse leaves (DFS in-order).
4.  Traverse right boundary (result reversed).

---
