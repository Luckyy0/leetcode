# 513. Find Bottom Left Tree Value / Tìm Giá Trị Bên Trái Nhất Ở Tầng Cuối Cùng

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the leftmost value in the last row of the tree.
Cho `root` của một cây nhị phân, hãy trả về giá trị bên trái nhất trong hàng cuối cùng của cây.

### Example 1:
```text
Input: root = [2,1,3]
Output: 1
```

### Example 2:
```text
Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-2^31 <= Node.val <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Level-order Traversal (BFS) / Duyệt theo tầng (BFS)
To find the last row, we can use Breadth-First Search (BFS).

Algorithm:
1. Use a standard `Queue` for BFS.
2. At each level:
   - Record the value of the first node visited at that level (this is the leftmost node of the level).
3. The very last value we recorded will be our answer.

**Optimization**:
If we traverse the tree from **right to left** at each level, the last node we visit in the entire traversal will naturally be the leftmost node of the last row.

Revised Algorithm:
1. Initialize queue with `root`.
2. While queue is not empty:
   - `node = queue.poll()`.
   - Add `node.right` to queue if exists.
   - Add `node.left` to queue if exists.
3. Return `node.val` of the last node popped.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(W) where W is the maximum width of the tree.

---

## Analysis / Phân tích

### Approach: Right-to-Left Level Traversal

**Algorithm**:
1.  Initialize Queue.
2.  Iterate level by level, pushing right child then left child.
3.  The final node popped is the leftmost on the bottom-most level.

---
