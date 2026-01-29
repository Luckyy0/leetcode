# 1080. Insufficient Nodes in Root to Leaf Paths / Các nút Không đủ trong Đường dẫn từ Gốc đến Lá

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree and an integer `limit`, delete all **insufficient nodes** in the tree simultaneously.
Cho `root` của một cây nhị phân và một số nguyên `limit`, hãy xóa đồng thời tất cả các **nút không đủ** trong cây.

A node is insufficient if every root-to-leaf path intersecting this node has a sum strictly less than `limit`.
Một nút là không đủ nếu mọi đường dẫn từ gốc đến lá cắt qua nút này có tổng nhỏ hơn hẳn `limit`.

Return the root of the affected tree.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-Order DFS / DFS Hậu tố
We need to check if a node can be part of ANY valid path.
This depends on the max path sum from this node to any leaf.
Let `nodeSum` be sum from root to parent.
We need `nodeSum + node.val + max(path from node to leaf)` >= `limit`.
Or simplified: Pass `limit - node.val` to children. If a child returns "I am insufficient", prune it. If both children are insufficient (or null and insufficient logic applies), then this node is insufficient.

Algorithm `prune(node, currentLimit)`:
1. If `node` is leaf:
   - If `node.val < currentLimit`, it's insufficient. Return null.
   - Else return node.
2. `node.left = prune(node.left, currentLimit - node.val)`
3. `node.right = prune(node.right, currentLimit - node.val)`
4. If both `node.left` and `node.right` are null (became null after pruning or were null), this node is insufficient (unless it was a leaf, but leaf logic handled above).
   - Wait. Logic care:
   - If original leaf, check condition.
   - If internal node, check if it has valid children left. If no valid children, it implies no path through it works. So prune it.
5. Return node (or null if pruned).

Wait. "Node is insufficient if EVERY root-to-leaf path intersecting this node...".
If a node remains, it means AT LEAST ONE path through it is valid.
My logic: prune left subtree. If left subtree becomes null (all paths in left bad). Prune right. If both null, node bad.
Correct.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Pruning
Propagate the required remaining sum (`limit - current_path_sum`) down the tree. A leaf is preserved only if its value satisfies the requirement. An internal node is preserved only if at least one of its subtrees survives the pruning process (meaning a valid path exists through it).
Truyền tổng còn lại cần thiết (`limit - current_path_sum`) xuống cây. Một lá chỉ được giữ lại nếu giá trị của nó thỏa mãn yêu cầu. Một nút bên trong chỉ được giữ lại nếu ít nhất một trong các cây con của nó sống sót qua quá trình cắt tỉa (nghĩa là tồn tại một đường dẫn hợp lệ qua nó).

---
