# 236. Lowest Common Ancestor of a Binary Tree / Tổ Tiên Chung Thấp Nhất của Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
Cho một cây nhị phân, hãy tìm tổ tiên chung thấp nhất (LCA) của hai nút đã cho trong cây.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow **a node to be a descendant of itself**).”
Theo định nghĩa về LCA trên Wikipedia: “Tổ tiên chung thấp nhất được xác định giữa hai nút `p` và `q` là nút thấp nhất trong `T` có cả `p` và `q` là hậu duệ (trong đó chúng ta cho phép **một nút là hậu duệ của chính nó**).”

### Example 1:
```text
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
```

### Example 2:
```text
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
```

### Example 3:
```text
Input: root = [1,2], p = 1, q = 2
Output: 1
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[2, 10^5]`.
- `-10^9 <= Node.val <= 10^9`
- All `Node.val` are **unique**.
- `p != q`
- `p` and `q` will exist in the tree.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Recursive DFS (Bottom-Up) / DFS Đệ quy (Từ dưới lên)
Since it's not a BST, we cannot decide which way to go based on values. We must search the entire tree.
Vì đây không phải là BST, chúng ta không thể quyết định đi hướng nào dựa trên giá trị. Chúng ta phải tìm kiếm toàn bộ cây.

**Logic for `lowestCommonAncestor(root, p, q)`**:
1.  **Base Case**:
    - If `root` is `null`, return `null`.
    - If `root` is `p` or `q`, return `root`. (If we found one of the targets, we return it up).

2.  **Recursive Step**:
    - `left = lowestCommonAncestor(root.left, p, q)`
    - `right = lowestCommonAncestor(root.right, p, q)`

3.  **Combine**:
    - If both `left` and `right` are **non-null**: It means `p` is in the left subtree and `q` is in the right (or vice versa). The current `root` is the split point, i.e., the LCA. Return `root`.
    - If only `left` is non-null: Both nodes are in the left subtree (or one dominates the other in the left). Return `left`.
    - If only `right` is non-null: Both nodes are in the right subtree. Return `right`.
    - If both are null: Return `null`.

---

## Analysis / Phân tích

### Approach: Recursive DFS

**Complexity / Độ phức tạp**:
- **Time**: O(N) - In the worst case, we might visit all nodes.
- **Space**: O(H) - Recursion stack height (O(N) for skewed tree).

---

## Edge Cases / Các trường hợp biên
1.  **Root is p or q**: Returns root immediately.
2.  **p and q in same branch**: The ancestor will bubble up.
3.  **Skewed tree**: Max recursion depth.
