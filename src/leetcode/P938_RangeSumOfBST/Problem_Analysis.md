# 938. Range Sum of BST / Tổng của BST trong Khoảng

## Problem Description / Mô tả bài toán
Given the `root` node of a binary search tree and two integers `low` and `high`, return the sum of values of all nodes with a value in the inclusive range `[low, high]`.
Cho nút gốc `root` của một cây tìm kiếm nhị phân và hai số nguyên `low` và `high`, hãy trả về tổng giá trị của tất cả các nút có giá trị nằm trong khoảng `[low, high]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BST Property and Pruning / Thuộc tính BST và Cắt tỉa
Algorithm:
1. If node is null, return 0.
2. If `node.val < low`: result is `sum(right-subtree)`.
3. If `node.val > high`: result is `sum(left-subtree)`.
4. If `low <= node.val <= high`: result is `node.val + sum(left) + sum(right)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H) for recursion stack.

---

## Analysis / Phân tích

### Approach: Value-directed Traversal
Leverage the inherent ordering of the Binary Search Tree to avoid exploring branches that cannot possibly contain values within the target range. This pruning significantly improves performance compared to a blind traversal.
Tận dụng thứ tự vốn có của Cây tìm kiếm nhị phân để tránh khám phá các nhánh không thể chứa các giá trị trong phạm vi mục tiêu. Việc cắt tỉa này giúp cải thiện đáng kể hiệu suất so với việc duyệt mù quáng.

---
