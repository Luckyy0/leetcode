# 366. Find Leaves of Binary Tree / Tìm Lá Của Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, collect a tree's nodes as if you were doing this:
- Collect all the leaf nodes.
- Remove all the leaf nodes.
- Repeat until the tree is empty.
Cho `root` của cây nhị phân, thu thập các nút...

### Example 1:
```text
Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
1. Remove leaves [4,5,3]. Tree becomes [1,2].
2. Remove leaf [2]. Tree becomes [1].
3. Remove leaf [1]. Tree empty.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 100]`.
- `-100 <= Node.val <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Height-Based Grouping / Nhóm Theo Chiều Cao
Instead of physically removing nodes (which is destructive and requires O(N) per pass -> O(N^2)), calculate the **height** of each node from the bottom.
- Leaves have height 0.
- Parents of leaves have height 1.
- `height(node) = 1 + max(height(left), height(right))`.
All nodes with height `h` are removed in the `h`-th iteration (0-indexed).
We can collect them directly into a list of lists where `result[h]` stores nodes of height `h`.

### Complexity / Độ phức tạp
- **Time**: O(N). Visits each node once.
- **Space**: O(N) (recursion + result).

---

## Analysis / Phân tích

### Approach: Post-Order DFS (Height Calculation)

**Algorithm**:
1.  `dfs(node)`.
2.  If null, return -1.
3.  `h = 1 + max(dfs(left), dfs(right))`.
4.  Ensure `result` has size `h + 1`.
5.  `result.get(h).add(node.val)`.
6.  Return `h`.
7.  Call `dfs(root)`. Return `result`.

---
