# 298. Binary Tree Longest Consecutive Sequence / Chuỗi Liên Tiếp Dài Nhất Trong Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the length of the longest consecutive sequence path.
Cho `root` của một cây nhị phân, hãy trả về độ dài của đường dẫn chuỗi liên tiếp dài nhất.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
Đường dẫn đề cập đến bất kỳ chuỗi nút nào từ một số nút bắt đầu đến bất kỳ nút nào trong cây dọc theo các kết nối cha-con. Đường dẫn liên tiếp dài nhất cần phải từ cha đến con.

### Example 1:
```text
Input: root = [1,null,3,2,4,null,null,null,5]
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
```

### Example 2:
```text
Input: root = [2,null,3,2,null,1]
Output: 2
Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 3 * 10^4]`.
- `-3 * 10^4 <= Node.val <= 3 * 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### DFS Traversal with State
We need to track the current consecutive length down the path.
`dfs(node, parent_val, current_length)`
- If `node == null`, return `max`.
- If `node.val == parent_val + 1`, then `current_length++`.
- Else `current_length = 1` (Reset because sequence broke).
- Updates global `max`.
- Recurse left and right.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Top-down DFS

**Algorithm**:
1.  Global `maxLength = 0`.
2.  `dfs(root, root.val, 1)`. (Or start with `root.val - 1` to force first step logic, simplify: pass `null` logic).
    - Easier: `dfs(node, count, target)`.
    - Initial call: `dfs(root, 1, root.val + 1)`.
    - Inside: `max = max(max, count)`.
    - `if (node.left)`: if `node.left.val == target`, `dfs(left, count+1, target+1)`. Else `dfs(left, 1, left.val+1)`.

---
