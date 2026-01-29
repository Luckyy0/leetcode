# 617. Merge Two Binary Trees / Hợp Nhất Hai Cây Nhị Phân

## Problem Description / Mô tả bài toán
You are given two binary trees `root1` and `root2`.
Bạn được cho hai cây nhị phân `root1` và `root2`.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
Hãy tưởng tượng rằng khi bạn đặt một trong số chúng để che cái kia, một số nút của hai cây bị chồng lấp trong khi những nút khác thì không. Bạn cần hợp nhất hai cây thành một cây nhị phân mới. Quy tắc hợp nhất là nếu hai nút chồng lấp, thì tổng giá trị nút lên làm giá trị mới của nút hợp nhất. Nếu không, nút KHÔNG null sẽ được sử dụng làm nút của cây mới.

Return the merged tree.
Trả về cây đã hợp nhất.

Note: The merging process must start from the root nodes of both trees.
Lưu ý: Quá trình hợp nhất phải bắt đầu từ các nút gốc của cả hai cây.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive DFS / DFS Đệ Quy
Function `merge(t1, t2)`:
- If `t1` null, return `t2`.
- If `t2` null, return `t1`.
- New node val = `t1.val + t2.val`.
- `node.left = merge(t1.left, t2.left)`
- `node.right = merge(t1.right, t2.right)`
- Return node.

We can reuse `t1` to save space if allowed, or create new nodes.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is min nodes.
- **Space**: O(Height).

---

## Analysis / Phân tích

### Approach: Preorder Traversal Merge

**Algorithm**:
1.  Check nulls.
2.  Sum values if both exist.
3.  Recursively merge children.

---
