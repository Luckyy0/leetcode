# 654. Maximum Binary Tree / Cây Nhị Phân Tối Đa

## Problem Description / Mô tả bài toán
You are given an integer array `nums` with no duplicates. A maximum binary tree can be built recursively from `nums` using the following algorithm:
1. Create a root node whose value is the maximum value in `nums`.
2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.

Return the maximum binary tree built from `nums`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Divide and Conquer / Chia Để Trị
Find max element, make it root. Recursively build left and right subtrees.

### Complexity / Độ phức tạp
- **Time**: O(N^2) worst case, O(N log N) average.
- **Space**: O(N).

---
