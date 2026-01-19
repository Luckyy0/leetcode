# 235. Lowest Common Ancestor of a Binary Search Tree / Tổ Tiên Chung Thấp Nhất của Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
Cho một cây tìm kiếm nhị phân (BST), hãy tìm tổ tiên chung thấp nhất (LCA) của hai nút đã cho trong BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”
Theo định nghĩa về LCA trên Wikipedia: “Tổ tiên chung thấp nhất được xác định giữa hai nút `p` và `q` là nút thấp nhất trong `T` có cả `p` và `q` là hậu duệ (trong đó chúng ta cho phép **một nút là hậu duệ của chính nó**).”

### Example 1:
```text
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```

### Example 2:
```text
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[2, 10^5]`.
- `-10^9 <= Node.val <= 10^9`
- All `Node.val` are **unique**.
- `p != q`
- `p` and `q` will exist in the BST.

---

## Theoretical Foundation / Cơ sở lý thuyết

### BST Property Exploitation / Khai Thác Tính Chất BST
In a BST:
- Left subtree values < Root value.
- Right subtree values > Root value.

**Logic**:
Start from the `root`.
1.  If both `p` and `q` are **smaller** than `root.val`: The LCA must be in the **left** subtree.
2.  If both `p` and `q` are **larger** than `root.val`: The LCA must be in the **right** subtree.
3.  Otherwise (one is smaller, one is larger, OR one is the root itself): The **current root** is the LCA. This is the split point.

---

## Analysis / Phân tích

### Approach: Iterative BST Traversal

**Algorithm**:
1.  Current node = `root`.
2.  While true:
    - If `p.val < current.val` AND `q.val < current.val`: `current = current.left`.
    - Else if `p.val > current.val` AND `q.val > current.val`: `current = current.right`.
    - Else: Break (Found the split point).
3.  Return `current`.

### Complexity / Độ phức tạp
- **Time**: O(H) - Height of the tree (O(log N) average, O(N) worst).
- **Space**: O(1) iterative (or O(H) recursive).

---

## Edge Cases / Các trường hợp biên
1.  **p or q is root**: Returns root.
2.  **p is ancestor of q**: Returns p.
3.  **Smallest/Largest nodes**: Path traversal works correctly.
