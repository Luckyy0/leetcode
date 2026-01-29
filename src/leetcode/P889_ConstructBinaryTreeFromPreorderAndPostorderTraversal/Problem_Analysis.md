# 889. Construct Binary Tree from Preorder and Postorder Traversal / Xây dựng Cây Nhị phân từ phép duyệt Tiền thứ tự và Hậu thứ tự

## Problem Description / Mô tả bài toán
Construct a binary tree given its preorder and postorder traversals.
Xây dựng một cây nhị phân dựa trên các phép duyệt tiền thứ tự và hậu thứ tự của nó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Tree Construction / Xây dựng Cây Đệ quy
Preorder: `[root, (left-subtree), (right-subtree)]`
Postorder: `[(left-subtree), (right-subtree), root]`

Key observation:
If left subtree is not empty, its root is `preorder[pre_start + 1]` and also the end of the left-subtree segment in postorder.
Nếu cây con bên trái không rỗng, gốc của nó là `preorder[pre_start + 1]` và cũng là điểm kết thúc của phân đoạn cây con bên trái trong hậu thứ tự.

Algorithm:
1. `preorder[0]` is the root.
2. The root of left child is `preorder[1]`.
3. Find index `idx` of `preorder[1]` in `postorder`.
4. Elements from `postorder[0...idx]` belong to left subtree.
5. Recursively build.

### Complexity / Độ phức tạp
- **Time**: O(N^2) or O(N) with Hashmap.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Boundary Identification
Identify the root and sub-roots from the two traversal sequences. By locating the left child's root within the postorder list, we can deduce the size of the left branch, allowing for a recursive breakdown of the problem.
Xác định nút gốc và các nút gốc con từ hai chuỗi duyệt. Bằng cách định vị gốc của con bên trái trong danh sách hậu thứ tự, chúng ta có thể suy ra kích thước của nhánh trái, cho phép chia nhỏ bài toán theo cách đệ quy.

---
