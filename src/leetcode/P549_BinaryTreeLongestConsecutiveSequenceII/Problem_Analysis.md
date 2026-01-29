# 549. Binary Tree Longest Consecutive Sequence II / Chuỗi Liên Tiếp Dài Nhất Trong Cây Nhị Phân II

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the length of the longest consecutive path in the tree.
Cho `root` của một cây nhị phân, hãy trả về độ dài của đường đi liên tiếp dài nhất trong cây.

This path can be either increasing or decreasing. For example, `[1,2,3,4]` and `[4,3,2,1]` are both considered valid, but the path `[1,2,4,3]` is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child relationship.
Đường đi này có thể tăng dần hoặc giảm dần. Ví dụ, `[1,2,3,4]` và `[4,3,2,1]` đều được coi là hợp lệ, nhưng đường đi `[1,2,4,3]` không hợp lệ. Mặt khác, đường đi có thể theo thứ tự con-Cha-con, không nhất thiết phải là quan hệ cha-con.

### Example 1:
```text
Input: root = [1,2,3]
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-order DFS / Duyệt Hậu Thứ Tự DFS
At each node, we want to know:
1. Longest increasing path starting at this node and going down. (`incr`)
2. Longest decreasing path starting at this node and going down. (`decr`)

Algorithm:
1. Helper function `dfs(node)` returns `{incr, decr}`.
2. At `node`:
   - Get `{l_in, l_de}` from left child.
   - Get `{r_in, r_de}` from right child.
   - If `node.val == left.val + 1`: `incr = max(incr, l_in + 1)`.
   - If `node.val == left.val - 1`: `decr = max(decr, l_de + 1)`.
   - Same for right child.
   - Update global max with `incr + decr - 1` (merging paths at root: increasing from left going up + decreasing from root going down to right = total sequence).
3. Return `{incr, decr}`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Bottom-Up Path Tracking

**Algorithm**:
1.  Recursively process subtrees.
2.  Track increasing and decreasing lengths from children.
3.  Extend paths if value continuity exists.
4.  Combine paths passing through current node for global maximum.
5.  Return max single-branch lengths to parent.

---
