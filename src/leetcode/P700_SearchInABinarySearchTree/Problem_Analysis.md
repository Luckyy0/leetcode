# 700. Search in a Binary Search Tree / Tìm kiếm trong Cây Tìm kiếm Nhị phân

## Problem Description / Mô tả bài toán
You are given the `root` of a binary search tree (BST) and an integer `val`.
Bạn được cho `root` của một cây tìm kiếm nhị phân (BST) và một số nguyên `val`.

Find the node in the BST that the node's value equals `val` and return the subtree rooted with that node. If such a node does not exist, return `null`.
Tìm nút trong BST có giá trị của nút bằng `val` và trả về cây con có gốc là nút đó. Nếu nút đó không tồn tại, trả về `null`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BST Search Property / Thuộc tính Tìm kiếm BST
In a BST, for any node:
- Values in the left subtree are smaller than the node's value.
- Values in the right subtree are larger than the node's value.

This allows for logarithmic search similar to binary search in a sorted array.

### Complexity / Độ phức tạp
- **Time**: O(H) where H is the height of the tree.
- **Space**: O(H) for recursion stack or O(1) for iterative approach.

---

## Analysis / Phân tích

### Approach: Recursive BST Search
Compare `val` with the current node's value. Based on the result, branch into the left or right subtree.
So sánh `val` với giá trị của nút hiện tại. Dựa trên kết quả, hãy rẽ nhánh vào cây con bên trái hoặc bên phải.

---
