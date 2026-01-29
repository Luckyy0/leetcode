# 897. Increasing Order Search Tree / Cây Tìm kiếm Thứ tự Tăng dần

## Problem Description / Mô tả bài toán
Given the `root` of a binary search tree, rearrange the tree in **in-order** so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
Cho `root` của một cây tìm kiếm nhị phân, hãy sắp xếp lại cây theo **thứ tự giữa (in-order)** sao cho nút ngoài cùng bên trái của cây hiện là gốc của cây và mọi nút đều không có nút con bên trái mà chỉ có một nút con bên phải.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### In-order Traversal and Re-linking / Duyệt thứ tự giữa và Liên kết lại
Algorithm:
1. Perform an in-order traversal of the BST.
2. During traversal, link the nodes together such that each node's `left` is `null` and `right` points to the next node in the in-order sequence.

Implementation detail:
Use a `dummy` node to keep track of the new root. Use a `curr` pointer to build the chain.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H) for recursion stack.

---

## Analysis / Phân tích

### Approach: Linear Transformation
Extract the sorted sequence of nodes inherent in a BST through in-order traversal. As each node is visited, reposition its pointers to transform the branching structure into a simplistic right-leaning list.
Trích xuất chuỗi các nút đã được sắp xếp vốn có trong BST thông qua phép duyệt thứ tự giữa. Khi mỗi nút được truy cập, hãy định vị lại các con trỏ của nó để chuyển cấu trúc phân nhánh thành một danh sách nghiêng về bên phải đơn giản.

---
