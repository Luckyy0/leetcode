# 337. House Robber III / Kẻ Trộm Nhà III

## Problem Description / Mô tả bài toán
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the `root`. Besides the `root`, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place form a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
Kẻ trộm lại tìm thấy một nơi mới. Chỉ có một lối vào gọi là `root`. Ngoài `root`, mỗi ngôi nhà chỉ có một nhà cha mẹ. Tất cả các ngôi nhà tạo thành một cây nhị phân. Cảnh sát sẽ được gọi nếu hai ngôi nhà liên kết trực tiếp bị đột nhập cùng một đêm.

Given the `root` of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
Cho `root` của cây nhị phân, trả về số tiền tối đa kẻ trộm có thể lấy mà không báo động cảnh sát.

### Example 1:
```text
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
(Rob root 3, skip 2, 3. Rob children of 2, 3 -> 3, 1).
Wait structure:
    3
   / \
  2   3
   \   \
    3   1
Options:
1. Rob 3 (root). Skip 2, 3.
   Next available: children of 2 (3), children of 3 (1).
   Total: 3 + 3 + 1 = 7.
2. Skip 3. Rob 2, 3.
   Total: 2 + 3 = 5.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `0 <= Node.val <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree DP / Quy Hoạch Động Trên Cây
For each node, we have 2 choices:
1.  **Rob this node**: We get `node.val` + `skip_left` + `skip_right`.
    - `skip_left`: Max money from left subtree if we DON'T rob left root.
    - `skip_right`: Max money from right subtree if we DON'T rob right root.
2.  **Skip this node**: We get `max_left` + `max_right`.
    - `max_left`: Max money from left subtree (either rob left or skip left).
    - `max_right`: Max money from right subtree.

State required from child:
- `robResult`: Max money if we rob the child.
- `skipResult`: Max money if we skip the child.

Let `dfs(node)` return a pair `[rob, skip]`.
- `node.rob = node.val + left.skip + right.skip`.
- `node.skip = max(left.rob, left.skip) + max(right.rob, right.skip)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H) (recursion stack).

---

## Analysis / Phân tích

### Approach: Post-Order DFS returning Pair

**Algorithm**:
1.  `dfs(node)` returns `int[]{rob, skip}`.
2.  Base case: `node == null` return `{0, 0}`.
3.  `l = dfs(node.left)`, `r = dfs(node.right)`.
4.  `rob = node.val + l[1] + r[1]`.
5.  `skip = Math.max(l[0], l[1]) + Math.max(r[0], r[1])`.
6.  Return `{rob, skip}`.
7.  Final answer: `Math.max(result[0], result[1])`.

---
