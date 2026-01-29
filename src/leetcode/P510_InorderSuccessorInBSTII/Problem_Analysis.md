# 510. Inorder Successor in BST II / Người Kế Tiếp Trung Thứ Tự Trong BST II

## Problem Description / Mô tả bài toán
Given a `node` in a binary search tree (BST), return its **inorder successor**. If the node has no inorder successor, return `null`.
Cho một `node` trong một cây tìm kiếm nhị phân (BST), hãy trả về **người kế tiếp trung thứ tự (inorder successor)** của nó. Nếu nút đó không có người kế tiếp, hãy trả về `null`.

Each node has a reference to its **parent** node.
Mỗi nút đều có tham chiếu đến nút **cha (parent)** của nó.

The **inorder successor** of a node is the node with the smallest key greater than `node.val`.
**Người kế tiếp trung thứ tự** của một nút là nút có giá trị nhỏ nhất lớn hơn `node.val`.

### Example 1:
```text
Input: node = 2 (in [2,1,3])
Output: 3
```

### Example 2:
```text
Input: node = 6 (in [15,6,18,3,7,17,20,2,4,null,13,null,null,null,null,null,null,null,null,9])
Output: 7
```

## Constraints / Ràng buộc
- `-10^5 <= node.val <= 10^5`
- All values in the tree are unique.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Structural Successor Logic / Logic Người kế tiếp dựa trên Cấu trúc
There are two cases to consider when finding the inorder successor with parent pointers:

1. **Case 1: Node has a right child**.
   - The successor is the **leftmost** node in the right subtree.
   - Start from `node.right` and keep move `left` as long as possible.

2. **Case 2: Node has no right child**.
   - The successor is one of its ancestors. Specifically, it's the first ancestor for which the current node (or the subtree containing the current node) is in the **left** subtree.
   - Move up using the `parent` pointer as long as the current node is the `right` child of its parent.
   - The successor is the parent where the path came from the `left` child.

### Complexity / Độ phức tạp
- **Time**: O(H) where H is the height of the tree.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Right-Child/Ancestor Decision

**Algorithm**:
1.  Check for right child.
2.  If exists, find leftmost descendant.
3.  If not, move up ancestors until a left-child transition is found.

---
