# 623. Add One Row to Tree / Thêm Một Hàng Vào Cây

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree and two integers `val` and `depth`, add a row of nodes with value `val` at the given depth `depth`.
Cho `root` của một cây nhị phân và hai số nguyên `val` và `depth`, thêm một hàng các nút có giá trị `val` ở độ sâu `depth` đã cho.

Note:
- The rooting depth is 1.
- The adding rule is: given a positive integer `depth`, for each not null tree node `N` at depth `depth - 1`, create two tree nodes with value `val` as `N`'s left subtree root and right subtree root. And `N`'s original left subtree should be the left subtree of the new left subtree root, and `N`'s original right subtree should be the right subtree of the new right subtree root.
- If `depth == 1`, that means there is no depth `depth - 1` at all, then create a tree node with value `val` as the new root of the whole original tree, and the original tree is the new root's left subtree.

### Example 1:
```text
Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS / BFS / DFS
Traverse to depth `d-1`.
For each node at `d-1`:
`tempLeft = node.left`
`node.left = new Node(val)`
`node.left.left = tempLeft`
`tempRight = node.right`
`node.right = new Node(val)`
`node.right.right = tempRight`

Edge case: `depth == 1`. New root. `newRoot.left = oldRoot`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (DFS stack or BFS queue).

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Algorithm**:
1.  Handle depth 1 separately.
2.  Traverse to depth-1 using recursion.
3.  Perform insertion logic.
4.  Return root.

---
