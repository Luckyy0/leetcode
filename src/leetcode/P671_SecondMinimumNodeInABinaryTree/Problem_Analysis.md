# 671. Second Minimum Node In a Binary Tree / Nút Nhỏ thứ hai trong Cây Nhị phân

## Problem Description / Mô tả bài toán
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the minimum value among its two sub-nodes.
Cho một cây nhị phân đặc biệt không trống bao gồm các nút có giá trị không âm, trong đó mỗi nút trong cây này có chính xác hai hoặc không có nút con. Nếu nút có hai nút con, thì giá trị của nút này là giá trị nhỏ nhất trong số hai nút con của nó.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree. If no such second minimum value exists, output -1 instead.
Cho một cây nhị phân như vậy, bạn cần đưa ra giá trị nhỏ thứ hai trong tập hợp bao gồm tất cả các giá trị của các nút trong toàn bộ cây. Nếu không tồn tại giá trị nhỏ thứ hai như vậy, hãy đưa ra -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Property / Thuộc tính Cây
The root is always the global minimum.
Gốc luôn là giá trị nhỏ nhất toàn cục.

To find the second minimum:
- If a child's value is greater than the root, it's a candidate for the second minimum.
- If a child's value equals the root, we must search deeper in that child's subtree for a larger value.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(H) recursion stack.

---

## Analysis / Phân tích

### Approach: Recursive Search
Because each node `v` is `min(v.left, v.right)`, the global minimum is `root.val`. We search for the smallest value strictly greater than `root.val`.
Vì mỗi nút `v` là `min(v.left, v.right)`, giá trị nhỏ nhất toàn cục là `root.val`. Chúng ta tìm kiếm giá trị nhỏ nhất lớn hơn hẳn `root.val`.

---
