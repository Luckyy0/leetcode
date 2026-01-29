# 1008. Construct Binary Search Tree from Preorder Traversal / Xây dựng Cây Tìm kiếm Nhị phân từ Duyệt Thứ tự Trước

## Problem Description / Mô tả bài toán
Given an array of integers `preorder`, which represents the preorder traversal of a BST, construct the tree and return its root.
Cho một mảng các số nguyên `preorder`, đại diện cho kết quả duyệt thứ tự trước của một BST, hãy xây dựng cây và trả về gốc của nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Preorder Property with Bounds / Thuộc tính Thứ tự Trước với Giới hạn
First element is root. Elements smaller than root are in left subtree. Elements larger are in right subtree.
Phần tử đầu tiên là gốc. Các phần tử nhỏ hơn gốc nằm ở cây con bên trái. Các phần tử lớn hơn nằm ở cây con bên phải.

Algorithm:
1. Recursive approach: `build(bound)`.
2. Maintain a global index.
3. If next element > bound or index out of range, return null.
4. Create node with `current`.
5. `node.left = build(node.val)`.
6. `node.right = build(bound)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Bound-constrained Recursion
Iterate through the preorder stream. Pass a "maximum allowed value" constraint down the recursion. As long as the current value fits within the constraint, it belongs to the current subtree; otherwise, backtrack to a higher level.
Lặp qua luồng thứ tự trước. Truyền một ràng buộc "giá trị tối đa cho phép" xuống đệ quy. Miễn là giá trị hiện tại phù hợp với ràng buộc, nó thuộc về cây con hiện tại; nếu không, quay lui lên cấp cao hơn.

---
