# 285. Inorder Successor in BST / Người Kế Vị Trung Tự trong BST

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree and a node `p` in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return `null`.
Cho `root` của một cây tìm kiếm nhị phân và một nút `p` trong đó, hãy trả về người kế vị trung tự của nút đó trong BST. Nếu nút đã cho không có người kế vị trung tự trong cây, hãy trả về `null`.

The successor of a node `p` is the node with the smallest key greater than `p.val`.
Người kế vị của một nút `p` là nút có khóa nhỏ nhất lớn hơn `p.val`.

### Example 1:
```text
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor is 2.
```

### Example 2:
```text
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no node in the tree that has a value greater than 6.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 10^4]`.
- `-10^5 <= Node.val <= 10^5`
- All Nodes will have unique values.

---

## Theoretical Foundation / Cơ sở lý thuyết

### BST Property Traversal / Duyệt Theo Tính Chất BST
We are looking for the smallest node `node` such that `node.val > p.val`.
We can traverse from `root`:
- If `p.val >= root.val`, then `root` (and its left subtree) cannot be the successor. The successor must be in the right subtree. Go Right.
- If `p.val < root.val`, then `root` is a potential successor (it is greater than `p`). However, there might be a smaller valid node in the left subtree. So we record `root` as a **candidate** and Go Left to see if we find something closer.

### Complexity / Độ phức tạp
- **Time**: O(H). We go down the tree.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Iterative Search

**Algorithm**:
1.  `successor = null`.
2.  `curr = root`.
3.  While `curr != null`:
    - If `curr.val > p.val`:
        - `successor = curr`.
        - `curr = curr.left`.
    - Else (`curr.val <= p.val`):
        - `curr = curr.right`.
4.  Return `successor`.

---

## Edge Cases / Các trường hợp biên
1.  **Successor is in tree**: Returns correct node.
2.  **No Successor**: Returns null (p is max element).
