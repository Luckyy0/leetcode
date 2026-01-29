# 1161. Maximum Level Sum of a Binary Tree / Tổng Cấp độ Lớn nhất của Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level `x` such that the sum of all the values of nodes at level `x` is maximal.
Cho `root` của một cây nhị phân, cấp độ của gốc là 1, cấp độ của con cái là 2, v.v.
Trả về cấp độ nhỏ nhất `x` sao cho tổng của tất cả các giá trị của các nút tại cấp độ `x` là lớn nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS Level Order Traversal / Duyệt theo Bậc (BFS)
Traverse tree level by level. Compute sum. Track max sum and level.

---
